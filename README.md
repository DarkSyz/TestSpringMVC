This is a sample to integrate gradle with IDEA, and test Spring MVC with jetty

Open IDEA, crate a gradle project. To integrate gradle with IDEA, please add idea plugin in build.gradle:
    apply plugin: 'idea'
then execute the following command in terminal(and please rerun it once you update the dependencies in build.gradle):
    gradlew idea
you can find the ipr have been generated.

Close the current project and use File|Open to open ipr file, you can find the dependencies have been created under external Libraries in Project explorer.

To integrate Spring MVC with jetty, configure jetty in gradle:
    ...
    apply plugin: 'war'
    apply plugin: 'jetty'
    dependencies {
        compile 'org.springframework:spring-webmvc:4.1.6.RELEASE'
        compile 'javax.servlet:jstl:1.2'
        compile 'commons-logging:commons-logging:1.2'
        compile 'log4j:log4j:1.2.13'
    }
    jettyRun {
        contextPath = 'web'
        httpPort = 8088
    }
    jettyRunWar {
        contextPath = 'web'
        httpPort = 8088
    }
    ...
and create the file structure accordingly:
    src
        main
            java
                [java package]
            resource
                log4j.properties
            webapp
                WEB-INF
                    views
                        jsp
                            *.jsp
                        spring-core-config.xml
                        spring-mvc-config.xml
                        web.xml

run the following command to start the web application.
    gradlew clean build jettyRun
