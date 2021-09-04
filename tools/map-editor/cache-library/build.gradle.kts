plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testCompileOnly("junit:junit:4.12")
    compileOnly("com.github.jponge:lzma-java:1.3")
	compileOnly("org.apache.commons:commons-compress:1.14")
}
