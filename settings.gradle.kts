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
        id("fabric-loom") version "1.8.9"
        id("org.jetbrains.kotlin.jvm") version "2.0.21"
    }

}
