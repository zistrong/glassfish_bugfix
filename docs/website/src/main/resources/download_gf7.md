# Eclipse GlassFish 7.x Downloads


### GlassFish 7.0.11

GlassFish 7.0.11 is a final release, containing final Jakarta EE 10 APIs. It compiles and runs on JDK 11 to JDK 21. MicroProfile support requires JDK 17 or higher.

GlassFish 7.0.11 compiles and passes all internal tests using OpenJDK 21. Several Jakarta EE 10 TCKs passed on JDK 21 as well. The Jakarta EE 10 TCK as a whole is not JDK 21 compatible and it's not possible to run all the Jakarta EE TCK tests. 

This release sees an important fix where WebSockets would not work at all for applications on the default context root (e.g. https://example.com vs https://example.com/myapp). 

This month we have concentrated on the AdminGUI and fixed an assortment of small but annoying defects in it. Various major components were updated, such as Jersey (Jakarta REST), Tyrus (Jakarta WebSockets) and Mojarra (Jakarta Faces). 

To keep the project maintainable and well tested, several tests were added and improved as well.

Download:

* [Eclipse GlassFish 7.0.11, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.11.zip)
* [Eclipse GlassFish 7.0.11, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.11.zip)
* [Eclipse GlassFish Embedded 7.0.11, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.11/jar)
* [Eclipse GlassFish Embedded 7.0.11, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.11/jar)

More details:

* [Eclipse GlassFish 7.0.11 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.11)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10


### GlassFish 7.0.10

GlassFish 7.0.10 is a final release, containing final Jakarta EE 10 APIs. It compiles and runs on JDK 11 to JDK 21. MicroProfile support requires JDK 17 or higher.

This release is the second GlassFish release after OpenJDK 21 was released. GlassFish 7.0.10 compiles and passes all internal tests using OpenJDK 21. Several Jakarta EE 10 TCKs passed on JDK 21 as well. The Jakarta EE 10 TCK as a whole is not JDK 21 compatible and it's not possible to run all the Jakarta EE TCK tests. 

In this release a 10 months long operation to get an internal dependency to the slf4j-api removed finally got to fruition. This involved the intense cooperation of multiple teams, and we're exceptionally happy to have finally been able to do this. 

We also did a lot of work to make our builds repeatable, and we did a ton of refactoring to the internal security packages of GlassFish, making them easier to understand and therefore easier to maintain. Any external code depending on these internal packages (such as potentially custom LoginModules/Realms) may have to update (we recommend of course not depending on internal packages and using public APIs). 

As every release, we integrated many component updates, and did a number of smaller fixes.

Download:

* [Eclipse GlassFish 7.0.10, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.10.zip)
* [Eclipse GlassFish 7.0.10, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.10.zip)
* [Eclipse GlassFish Embedded 7.0.10, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.10/jar)
* [Eclipse GlassFish Embedded 7.0.10, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.10/jar)

More details:

* [Eclipse GlassFish 7.0.10 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.10)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10

### GlassFish 7.0.9

GlassFish 7.0.9 is a final release, containing final Jakarta EE 10 APIs. It compiles and runs on JDK 11 to JDK 21. MicroProfile support requires JDK 17 or higher.

This release is the first GlassFish release after OpenJDK 21 was released. GlassFish 7.0.9 compiles and passes all internal tests using OpenJDK 21. Several Jakarta EE 10 TCKs passed on JDK 21 as well. The Jakarta EE 10 TCK as a whole is not JDK 21 compatible and it's not possible to run all the Jakarta EE TCK tests. 

In this release the modularity of GlassFish is once again increased by moving the Jakarta Authentication implementation code to a new standalone project: [Epicyro](https://github.com/eclipse-ee4j/epicyro). We also enabled the GlassFish embedded tests again, which were dormant for a long time. Among the many updated components, Exousia was updated specifically to fix a bug with deployments on virtual servers, and the ORB was updated to fix a somewhat obscure bug where a remote EJB returned a JDK defined enum type.

Download:

* [Eclipse GlassFish 7.0.9, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.9.zip)
* [Eclipse GlassFish 7.0.9, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.9.zip)
* [Eclipse GlassFish Embedded 7.0.9, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.9/jar)
* [Eclipse GlassFish Embedded 7.0.9, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.9/jar)

More details:

* [Eclipse GlassFish 7.0.9 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.9)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10

### GlassFish 7.0.8

GlassFish 7.0.8 is a final release, containing final Jakarta EE 10 APIs. It compiles and runs on JDK 11 to JDK 21ea33. MicroProfile support requires JDK 17 or higher.

This release prepares GlassFish for the upcoming JDK 21; it compiles and passes all internal tests using OpenJDK 21ea35. Several TCKs passed on JDK 21 as well, but the TCK as a whole is not JDK 21 compatible yet. 

This release fixes multi-jar compatibility in GlassFish and does further preparations for JDK 21. It includes various component updates among which those for CDI, Faces, and JSON. Test coverage is improved by adding the TCKs for REST Client and Connectors. Finally, various CDI extensions have been optimised to reduce excessive and unnecessary calls to them.

Download:

* [Eclipse GlassFish 7.0.8, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.8.zip)
* [Eclipse GlassFish 7.0.8, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.8.zip)
* [Eclipse GlassFish Embedded 7.0.8, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.8/jar)
* [Eclipse GlassFish Embedded 7.0.8, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.8/jar)

More details:

* [Eclipse GlassFish 7.0.8 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.8)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10




### GlassFish 7.0.7

GlassFish 7.0.7 is a final release, containing final Jakarta EE 10 APIs. It compiles and runs on JDK 11 to JDK 21ea33. MicroProfile support requires JDK 17 or higher.

This release prepares GlassFish for the upcoming JDK 21; it compiles and passes all internal tests using OpenJDK 21ea33. Several TCKs passed on JDK 21 as well, but the TCK as a whole is not JDK 21 compatible yet. 

This release also adds support for MicroProfile JWT 2.1, and has many components updated to their latest version. Several issues have again been fixed in the Admin Console. An important bug regarding Enterprise Beans method generation has been fixed, as has a remote access issue for Enterprise Beans.

Download:

* [Eclipse GlassFish 7.0.7, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.7.zip)
* [Eclipse GlassFish 7.0.7, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.7.zip)
* [Eclipse GlassFish Embedded 7.0.7, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.7/jar)
* [Eclipse GlassFish Embedded 7.0.7, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.7/jar)

More details:

* [Eclipse GlassFish 7.0.7 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.7)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10


### GlassFish 7.0.6

GlassFish 7.0.6 is a final release, containing final Jakarta EE 10 APIs. It compiles and runs on JDK 11 to JDK 20. MicroProfile support requires JDK 17 or higher.

The main features of this release are the newly added support of the MicroProfile REST Client and a new way to start GlassFish, which is a preparation for Docker images that will run GlassFish in the foreground in a single JVM process to save memory consumed by Docker containers.

This release also contains the usual amount of fixes, and a number of important component updates. Specifically the EclipseLink and Soteria updates fix important bugs (see their release notes).

Download:

* [Eclipse GlassFish 7.0.6, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.6.zip)
* [Eclipse GlassFish 7.0.6, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.6.zip)
* [Eclipse GlassFish Embedded 7.0.6, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.6/jar)
* [Eclipse GlassFish Embedded 7.0.6, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.6/jar)

More details:

* [Eclipse GlassFish 7.0.6 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.6)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10


### GlassFish 7.0.5

GlassFish 7.0.5 is a final release, containing final Jakarta EE 10 APIs. It compiles and runs on JDK 11 to JDK 20. MicroProfile support requires JDK 17 or higher.

The main features of this release are a number of important bug fixes such as one in deployment-time recursive bytecode, resetting the security context if a principal has not changed, and several fixes in clustering.

Jakarta EE components have been updated for Mail, JSON Processing, and REST. Auxiliary components such as Jackson and Commons IO have also been updated to their latest version.

Download:

* [Eclipse GlassFish 7.0.5, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.5.zip)
* [Eclipse GlassFish 7.0.5, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.5.zip)
* [Eclipse GlassFish Embedded 7.0.5, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.5/jar)
* [Eclipse GlassFish Embedded 7.0.5, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.5/jar)

More details:

* [Eclipse GlassFish 7.0.5 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.5)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10


### GlassFish 7.0.4

GlassFish 7.0.4 is a final release, containing final Jakarta EE 10 APIs. It compiles and runs on JDK 11 to JDK 20. MicroProfile support requires JDK 17 or higher.

The main features of this release are important bug fixes for things like a class loader leak, and again several fixes in the admin console such as the ability to upload a war file. 

A new feature for ScatteredArchive has been added to GlassFsih Embedded.

Download:

* [Eclipse GlassFish 7.0.4, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.4.zip)
* [Eclipse GlassFish 7.0.4, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.4.zip)
* [Eclipse GlassFish Embedded 7.0.4, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.4/jar)
* [Eclipse GlassFish Embedded 7.0.4, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.4/jar)

More details:

* [Eclipse GlassFish 7.0.4 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.4)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10


### GlassFish 7.0.3

Eclipse GlassFish 7.0.3 is the third maintenance update of GlassFish 7. It compiles and runs on JDK 11 to JDK 20. MicroProfile support requires JDK 17 or higher.

Download:

* [Eclipse GlassFish 7.0.3, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.3.zip)
* [Eclipse GlassFish 7.0.3, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.3.zip)
* [Eclipse GlassFish Embedded 7.0.3, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.3/jar)
* [Eclipse GlassFish Embedded 7.0.3, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.3/jar)

More details:

* [Eclipse GlassFish 7.0.3 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.3)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10


### GlassFish 7.0.2

Eclipse GlassFish 7.0.2 is the second maintenance update of GlassFish 7. It compiles and runs on JDK 11 to JDK 19. MicroProfile support requires JDK 17 or higher. Compiling and running on JDK 20ea has been sucesfully tested, but is not yet officially supported.

Download:

* [Eclipse GlassFish 7.0.2, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.2.zip)
* [Eclipse GlassFish 7.0.2, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.2.zip)
* [Eclipse GlassFish Embedded 7.0.2, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.2/jar)
* [Eclipse GlassFish Embedded 7.0.2, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.2/jar)

More details:

* [Eclipse GlassFish 7.0.2 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.2)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10


### GlassFish 7.0.1

Eclipse GlassFish 7.0.1 is the first maintenance update of GlassFish 7. It compiles and runs on JDK 11 to JDK 19. MicroProfile support requires JDK 17 or higher. Compiling and running on JDK 20ea has been sucesfully tested, but is not yet officially supported.

Download:

* [Eclipse GlassFish 7.0.1, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.1.zip)
* [Eclipse GlassFish 7.0.1, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.1.zip)
* [Eclipse GlassFish Embedded 7.0.1, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.1/jar)
* [Eclipse GlassFish Embedded 7.0.1, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.1/jar)

More details:

* [Eclipse GlassFish 7.0.1 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.1)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10


### GlassFish 7.0.0

Eclipse GlassFish 7.0.0 is a final release, containing final [Jakarta EE 10](https://jakarta.ee/specifications/platform/10) APIs and final Jakarta EE 10 implementation components. It compiles and runs on JDK 11 to JDK 19. MicroProfile support requires JDK 17 or higher.

Download:

* [Eclipse GlassFish 7.0.0, Jakarta EE Platform, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.0.zip)
* [Eclipse GlassFish 7.0.0, Jakarta EE Web Profile, 10](https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/web-7.0.0.zip)
* [Eclipse GlassFish Embedded 7.0.0, Jakarta EE Full Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-all/7.0.0/jar)
* [Eclipse GlassFish Embedded 7.0.0, Jakarta EE Web Profile, 10](https://search.maven.org/artifact/org.glassfish.main.extras/glassfish-embedded-web/7.0.0/jar)

More details:

* [Eclipse GlassFish 7.0.0 Release Notes](https://github.com/eclipse-ee4j/glassfish/releases/tag/7.0.0)
* [Jakarte EE Platform Specification Project](https://jakartaee.github.io/jakartaee-platform/) for more info about Jakarta EE 10
