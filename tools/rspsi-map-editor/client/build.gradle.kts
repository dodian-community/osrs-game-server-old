plugins {
	//id("org.openjfx.javafxplugin") version "0.0.10"
}

description = "Client"

dependencies {
	implementation(project(":rs-cache-library"))
    implementation("org.apache.commons:commons-math3:3.6.1")
	implementation("org.tukaani:xz:1.6")
	implementation("org.brotli:dec:0.1.2")
    implementation("com.google.guava:guava:23.1-jre")
	implementation("com.fasterxml.jackson.core:jackson-core:2.9.1")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.9.1")
	implementation("net.coobird:thumbnailator:0.4.8")
	implementation("org.jfree:fxgraphics2d:1.7")
	implementation("org.quartz-scheduler:quartz:2.3.0")
	implementation("org.greenrobot:eventbus:3.1.1")
}

/*javafx {
	modules("javafx.fxml", "javafx.controls", "javafx.media", "javafx.swing")
}*/
