plugins {
    java
    application
    id("io.franzbecker.gradle-lombok") version "3.3.0"
}

group = "RSPSi Editor"
version = "1.16.1"

allprojects {

    repositories {
        mavenCentral()
        mavenLocal()
        maven(url = "https://repo.maven.apache.org/maven2")
        maven(url = "https://repo.adobe.com/nexus/content/repositories/public/")
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.franzbecker.gradle-lombok")

    dependencies {
        implementation("ch.qos.logback:logback-classic:1.2.3")
        implementation("org.checkerframework:checker-qual:2.9.0")
        implementation("com.google.guava:guava:28.0-jre")
        implementation("com.google.code.gson:gson:2.8.5")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lombok { // optional: values below are the defaults
        version = "1.18.12"
        sha256 = "49381508ecb02b3c173368436ef71b24c0d4418ad260e6cc98becbcf4b345406"
    }
}