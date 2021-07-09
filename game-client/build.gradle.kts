buildscript {

    repositories {
        mavenCentral()
    }
}

plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "2.0.0"
}

group = "io.nozemi"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
}

application {
    mainClass.set("client.Loader")
}

repositories {
    mavenCentral()
}

dependencies {
    testCompileOnly("junit:junit:4.12")

    compileOnly(fileTree("libs") {
        include("*.jar")
    })

    apply(plugin = "java")
}

tasks {

    javadoc {
        options.encoding = "UTF-8"
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    compileTestJava {
        options.encoding = "UTF_8"
    }

    shadowJar {
        archiveBaseName.set("gameclient")
        archiveClassifier.set("")
        archiveVersion.set("")
    }

    register("generatemd5") {

        doLast {
            //ant.checksum(file: tasks.shadowJar.outputs.files.asPath, algorithm: "md5", todir: "$project.buildDir/libs")
        }
    }

    register("obfuscator") {
        dependsOn("shadowJar")

        /*println(tasks.shadowJar.outputs.files.asPath)
        doLast {
            println(tasks.shadowJar.outputs.files.asPath)
            ant.taskdef(name: 'allatori', classname: 'com.allatori.ant.ObfuscatorTask') {
                classpath {
                    fileset(dir: './lib', includes: '*.jar')
                }
            }
            ant.allatori(config: 'lib/config.xml') {

            }
        }*/
    }
}