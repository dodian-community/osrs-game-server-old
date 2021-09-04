plugins {
    application
    id("org.openjfx.javafxplugin") version "0.0.10"
}

javafx {
    modules("javafx.fxml", "javafx.controls", "javafx.media", "javafx.swing", "javafx.base", "javafx.graphics")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

application {
    mainClass.set("io.nozemi.editor.DataEditorApplication")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.jfoenix:jfoenix:9.0.10")
    implementation("org.controlsfx:controlsfx:8.40.15")
    implementation("org.greenrobot:eventbus:3.1.1")
    implementation("com.google.guava:guava:28.0-jre")

    runtimeOnly("org.postgresql:postgresql")

    implementation("com.zaxxer:HikariCP:4.0.3")
}