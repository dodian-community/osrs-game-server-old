plugins {
    java
    application
    id("org.springframework.boot") version "2.4.0"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "io.nozemi.mapeditor"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

application {
    mainClass.set("io.nozemi.mapeditor.MapEditorApplication")
}

javafx {
    modules("javafx.fxml", "javafx.controls", "javafx.media", "javafx.swing", "javafx.base", "javafx.graphics")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":client"))
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.jfoenix:jfoenix:9.0.10")
    implementation("org.controlsfx:controlsfx:8.40.15")
    implementation("org.greenrobot:eventbus:3.1.1")
    implementation("com.google.guava:guava:28.0-jre")
}

subprojects {

    apply(plugin = "org.openjfx.javafxplugin")

    dependencies {
        implementation("com.google.guava:guava:28.0-jre")
    }

    javafx {
        modules("javafx.fxml", "javafx.controls", "javafx.media", "javafx.swing", "javafx.base", "javafx.graphics")
    }
}