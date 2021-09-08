plugins {
    java
    kotlin("jvm") version "1.5.21"
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "net.dodian"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")

        implementation("io.netty:netty-all:4.1.67.Final")

        implementation("com.michael-bull.kotlin-inline-logger:kotlin-inline-logger-jvm:1.0.3")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")

        implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.4")
        implementation("org.springframework.boot:spring-boot-starter-jdbc:2.5.4")
        implementation("org.springframework.boot:spring-boot-starter-security:2.5.4")
        implementation("org.springframework.boot:spring-boot-starter-web:2.5.4")
        implementation("org.springframework.session:spring-session-jdbc:2.5.2")
        runtimeOnly("org.springframework.boot:spring-boot-devtools:2.5.4")
        testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.4")

        implementation("com.zaxxer:HikariCP:4.0.3")
    }
}