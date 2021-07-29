plugins {
    application
    //id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "Editor UI"

dependencies {
    implementation(project(":client"))
    implementation(project(":rs-cache-library"))
    implementation("org.controlsfx:controlsfx:8.40.15")
    implementation("com.jfoenix:jfoenix:8.0.9")
    implementation("org.quartz-scheduler:quartz:2.3.0")
    implementation("org.greenrobot:eventbus:3.1.1")
    implementation("net.coobird:thumbnailator:0.4.8")
    implementation("org.apache.commons:commons-compress:1.14")
    implementation("com.fasterxml.jackson.core:jackson-core:2.9.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.1")
    implementation("org.apache.commons:commons-math3:3.6.1")
}

application {
    mainClass.set("com.rspsi.LauncherWindow")
    applicationName = "RSPSi"
}

/*javafx {
    modules("javafx.fxml", "javafx.controls", "javafx.media", "javafx.swing")
}*/
