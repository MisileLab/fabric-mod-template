rootProject.name = "fabric-example-mod-kotlin-with-kotlin-dsl"
pluginManagement {
    repositories {
        mavenCentral()
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        gradlePluginPortal()
    }

    plugins {
        id("fabric-loom") version "1.1.11"
        id("org.jetbrains.kotlin.jvm") version "1.8.20"
    }

}
