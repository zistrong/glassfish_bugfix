/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.gjc.common;

import static java.util.logging.Level.FINEST;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.internal.api.ClassLoaderHierarchy;
import org.glassfish.internal.api.Globals;

import com.sun.enterprise.util.i18n.StringManager;
import com.sun.gjc.util.MethodExecutor;
import com.sun.logging.LogDomains;

import jakarta.resource.ResourceException;

/**
 * Utility class, which would create necessary Datasource object according to
 * the specification.
 *
 * @author Binod P.G
 * @version 1.0, 02/07/23
 * @see com.sun.gjc.common.DataSourceSpec
 * @see com.sun.gjc.util.MethodExcecutor
 */
public class DataSourceObjectBuilder implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Logger _logger = LogDomains.getLogger(MethodExecutor.class, LogDomains.RSR_LOGGER);
    private static final StringManager sm = StringManager.getManager(DataSourceObjectBuilder.class);

    private static boolean jdbc40 = detectJDBC40();
    private static boolean jdbc41 = detectJDBC41();

    private DataSourceSpec spec;
    private Hashtable driverProperties;
    private MethodExecutor executor;

    /**
     * Construct a DataSource Object from the spec.
     *
     * @param spec <code> DataSourceSpec </code> object.
     */
    public DataSourceObjectBuilder(DataSourceSpec spec) {
        this.spec = spec;
        executor = new MethodExecutor();
    }

    /**
     * Construct the DataSource Object from the spec.
     *
     * @return Object constructed using the DataSourceSpec.
     * @throws <code>ResourceException</code> if the class is not found or some
     * issue in executing some method.
     */
    public Object constructDataSourceObject() throws ResourceException {
        driverProperties = parseDriverProperties(spec, true);
        Object dataSourceObject = getDataSourceObject();
        Method[] methods = dataSourceObject.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            String methodName = methods[i].getName();
            // Check for driver properties first since some jdbc properties
            // may be supported in form of driver properties
            if (driverProperties.containsKey(methodName.toUpperCase(Locale.getDefault()))) {
                Vector values = (Vector) driverProperties.get(methodName.toUpperCase(Locale.getDefault()));
                executor.runMethod(methods[i], dataSourceObject, values);
            } else if (methodName.equalsIgnoreCase("setUser")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.USERNAME), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setPassword")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.PASSWORD), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setLoginTimeOut")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.LOGINTIMEOUT), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setLogWriter")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.LOGWRITER), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setDatabaseName")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.DATABASENAME), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setDataSourceName")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.DATASOURCENAME), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setDescription")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.DESCRIPTION), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setNetworkProtocol")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.NETWORKPROTOCOL), methods[i],
                        dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setPortNumber")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.PORTNUMBER), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setRoleName")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.ROLENAME), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setServerName")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.SERVERNAME), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setMaxStatements")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.MAXSTATEMENTS), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setInitialPoolSize")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.INITIALPOOLSIZE), methods[i],
                        dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setMinPoolSize")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.MINPOOLSIZE), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setMaxPoolSize")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.MAXPOOLSIZE), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setMaxIdleTime")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.MAXIDLETIME), methods[i], dataSourceObject);

            } else if (methodName.equalsIgnoreCase("setPropertyCycle")) {
                executor.runJavaBeanMethod(spec.getDetail(DataSourceSpec.PROPERTYCYCLE), methods[i], dataSourceObject);

            }
        }
        return dataSourceObject;
    }

    /**
     * Get the extra driver properties from the DataSourceSpec object and parse them
     * to a set of methodName and parameters. Prepare a hashtable containing these
     * details and return.
     *
     * @param spec <code> DataSourceSpec </code> object.
     * @return Hashtable containing method names and parameters,
     * @throws ResourceException If delimiter is not provided and property string is
     * not null.
     */
    public Hashtable parseDriverProperties(DataSourceSpec spec, boolean returnUpperCase) throws ResourceException {
        String delim = spec.getDetail(DataSourceSpec.DELIMITER);
        String escape = spec.getDetail(DataSourceSpec.ESCAPECHARACTER);
        String prop = spec.getDetail(DataSourceSpec.DRIVERPROPERTIES);

        if (prop == null || prop.trim().equals("")) {
            return new Hashtable();
        }

        if (delim == null || delim.equals("")) {
            throw new ResourceException(sm.getString("dsob.delim_not_specified"));
        }

        if (escape == null || escape.equals("")) {
            throw new ResourceException(sm.getString("dsob.escape_char_not_specified"));
        }

        return parseDriverProperties(prop, escape, delim, returnUpperCase);
    }

    /**
     * parse the driver properties and re-generate name value pairs with unescaped
     * values.
     *
     * @param values driverProperties
     * @param escape escape character
     * @param delimiter delimiter
     * @return Hashtable
     */
    public Hashtable parseDriverProperties(String values, String escape, String delimiter, boolean returnUpperCase) {
        Hashtable result = new Hashtable();
        String parsedValue = "";
        String name = "";
        String value = "";
        char escapeChar = escape.charAt(0);
        char delimiterChar = delimiter.charAt(0);
        while (values.length() > 0) {
            if (values.charAt(0) == delimiterChar) {
                if (values.length() > 1 && values.charAt(1) == delimiterChar) {
                    if (values.length() > 2 && values.charAt(2) == delimiterChar) {
                        // Check for first property that does not have a value
                        // There is no value specified for this property.
                        // Store the name or it will be lost
                        if (returnUpperCase) {
                            name = parsedValue.toUpperCase(Locale.getDefault());
                        } else {
                            name = parsedValue;
                        }
                        // no value specified for value
                        parsedValue = "";
                    }
                    value = parsedValue;
                    Vector v = new Vector();
                    v.add(value);
                    result.put(name, v);
                    parsedValue = "";
                    values = values.substring(2);
                } else {
                    if (returnUpperCase) {
                        name = parsedValue.toUpperCase(Locale.getDefault());
                    } else {
                        name = parsedValue;
                    }
                    parsedValue = "";
                    values = values.substring(1);
                }
            } else if (values.charAt(0) == escapeChar) {
                if (values.charAt(1) == escapeChar) {
                    parsedValue += values.charAt(1);
                } else if (values.charAt(1) == delimiterChar) {
                    parsedValue += values.charAt(1);
                }
                values = values.substring(2);
            } else if (values.charAt(0) != escapeChar) {
                parsedValue += values.charAt(0);
                values = values.substring(1);
            }
        }

        return result;
    }

    /**
     * Creates a Datasource object according to the spec.
     *
     * @return Initial DataSource Object instance.
     * @throws <code>ResourceException</code> If class name is wrong or classpath is
     * not set properly.
     */
    private Object getDataSourceObject() throws ResourceException {
        String className = spec.getDetail(DataSourceSpec.CLASSNAME);

        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            Class<?> dataSourceClass;
            try {
                dataSourceClass = Class.forName(className, true, cl);
            } catch (ClassNotFoundException cnfe) {
                // OSGi-ed apps can't see lib dir, so try using CommonClassLoader
                cl = Globals.get(ClassLoaderHierarchy.class).getCommonClassLoader();
                dataSourceClass = Class.forName(className, true, cl);
            }

            return dataSourceClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException cnfe) {
            _logger.log(Level.SEVERE, "jdbc.exc_cnfe_ds", cnfe);
            throw new ResourceException(sm.getString("dsob.class_not_found", className), cnfe);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException ce) {
            _logger.log(Level.SEVERE, "jdbc.exc_inst", className);
            throw new ResourceException(sm.getString("dsob.error_instantiating", className), ce);
        } catch (IllegalAccessException ce) {
            _logger.log(Level.SEVERE, "jdbc.exc_acc_inst", className);
            throw new ResourceException(sm.getString("dsob.access_error", className), ce);
        }
    }

    public static boolean isJDBC40() {
        return jdbc40;
    }

    public static boolean isJDBC41() {
        return jdbc41;
    }

    /**
     * Check whether the jdbc api version is 4.0 or not.
     *
     * @return boolean
     */
    private static boolean detectJDBC40() {
        boolean jdbc40 = false;
        try {
            Class.forName("java.sql.Wrapper");
            jdbc40 = true;
        } catch (ClassNotFoundException cnfe) {
            _logger.log(FINEST, "could not find Wrapper(available in jdbc-40), jdk supports only jdbc-30");
        }

        return jdbc40;
    }

    /**
     * Detect if jdbc api version is 4.1 or not
     *
     * @return boolean
     */
    private static boolean detectJDBC41() {
        boolean jdbc41 = false;
        try {
            Class.forName("java.sql.PseudoColumnUsage");
            jdbc41 = true;
        } catch (ClassNotFoundException cnfe) {
            _logger.log(FINEST, "could not find PseudoColumnUsage(enum available in jdbc-41),"
                        + " jdk supports jdbc-40 or lesser");
        }

        return jdbc41;
    }
}
