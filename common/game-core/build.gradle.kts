dependencies {
    implementation("it.unimi.dsi:fastutil:8.5.4")
    implementation("com.typesafe:config:1.4.1")
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("org.reflections:reflections:0.9.12")
    implementation("com.warrenstrange:googleauth:1.5.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")
    implementation("io.reactivex.rxjava3:rxjava:3.1.1")
    implementation("backport-util-concurrent:backport-util-concurrent:3.1")
    implementation("redis.clients:jedis:3.6.3")

    api(project(":common:game-models"))

    implementation(fileTree("../../libs") {
        include("*.jar")
    })

    // TODO: Remove Gson entirely
    implementation("com.google.code.gson:gson:2.8.8")
}