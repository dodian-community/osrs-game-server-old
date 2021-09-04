plugins {
	java
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnly(project(":cache-library"))
    compileOnly("org.apache.commons:commons-math3:3.6.1")
	compileOnly("org.tukaani:xz:1.6")
	compileOnly("org.brotli:dec:0.1.2")
    compileOnly("com.google.guava:guava:23.1-jre")
	compileOnly("com.fasterxml.jackson.core:jackson-core:2.9.1")
	compileOnly("com.fasterxml.jackson.core:jackson-databind:2.9.1")
	compileOnly("net.coobird:thumbnailator:0.4.8")
	compileOnly("org.jfree:fxgraphics2d:1.7")
	compileOnly("org.quartz-scheduler:quartz:2.3.0")
	compileOnly("org.greenrobot:eventbus:3.1.1")
}

