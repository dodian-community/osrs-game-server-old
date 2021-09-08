plugins {
    id("org.springframework.boot")
}

java {
    sourceCompatibility = JavaVersion.VERSION_15
    targetCompatibility = JavaVersion.VERSION_15
}

dependencies {
    implementation("com.google.guava:guava:22.0")
    implementation("it.unimi.dsi:fastutil:8.1.0")
    implementation("org.reflections:reflections:0.9.11")
    implementation("io.github.classgraph:classgraph:4.8.113")
    implementation("redis.clients:jedis:2.9.0")

    runtimeOnly("com.h2database:h2")

    implementation(project(":common:game-core"))
    implementation(project(":common:game-cache"))

    // TODO: Remove Gson entirely
    implementation("com.google.code.gson:gson:2.8.1")


    implementation("com.warrenstrange:googleauth:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("io.reactivex.rxjava3:rxjava:3.0.13")
    implementation("backport-util-concurrent:backport-util-concurrent:3.1")
    implementation("com.typesafe:config:1.4.1")

    implementation(fileTree("libs") {
        include("*.jar")
    })
}