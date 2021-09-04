plugins {
}

group = "io.nozemi.runescape"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation(kotlin("stdlib"))

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.netty:netty-all:4.1.17.Final")
    implementation("com.typesafe:config:1.4.1")
    implementation("com.google.guava:guava:22.0")
    implementation("it.unimi.dsi:fastutil:8.1.0")
    implementation("org.reflections:reflections:0.9.11")
    implementation("backport-util-concurrent:backport-util-concurrent:3.1")
    implementation("com.google.code.gson:gson:2.8.1")
    implementation("com.michael-bull.kotlin-inline-logger:kotlin-inline-logger:1.0.3")
    implementation("io.github.classgraph:classgraph:4.8.102")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("io.reactivex.rxjava3:rxjava:3.0.13")
    implementation("com.warrenstrange:googleauth:1.4.0")
    implementation("io.github.classgraph:classgraph:4.8.113")

    implementation("redis.clients:jedis:2.9.0")

    implementation("com.zaxxer:HikariCP:4.0.3")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")

    implementation(fileTree("libs") {
        include("*.jar")
    })
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.isIncremental = true
}