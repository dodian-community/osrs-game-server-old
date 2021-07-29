plugins {
    id("com.github.harbby.gradle.serviceloader") version "1.1.5"
}

subprojects {
    apply(plugin = "com.github.harbby.gradle.serviceloader")

    group = "plugins"
    version = "1.0.0"

    dependencies {
        implementation(project(":editor"))
        implementation(project(":client"))
        implementation(project(":rs-cache-library"))
        implementation("org.apache.commons:commons-compress:1.14")
    }

    serviceLoader {
        serviceInterfaces.add("com.rspsi.plugins.ClientPlugin")
        serviceInterfaces.add("com.rspsi.plugins.ApplicationPlugin")
    }

    tasks {

        jar {
            archiveFileName.set(project.name + ".jar")
            archiveBaseName.set(project.name)
        }

        register<Copy>("copyJarToBin") {
            from("build/libs/" + project.name + ".jar")
            into(File(project(":editor").projectDir, "/plugins/active"))
        }

        register("buildAndMove") {
            dependsOn(compileJava, jar, ":plugins:" + project.name + ":copyJarToBin")
        }
    }
}