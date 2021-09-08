plugins {
    id("org.springframework.boot")
}

java {
    sourceCompatibility = JavaVersion.VERSION_15
    targetCompatibility = JavaVersion.VERSION_15
}

dependencies {
    implementation("io.github.classgraph:classgraph:4.8.114")

    runtimeOnly("com.h2database:h2:1.4.200")

    implementation(project(":common:game-core"))
    implementation(project(":common:game-cache"))
    implementation(project(":common:game-models"))

    implementation(fileTree("../libs") {
        include("*.jar")
    })
}