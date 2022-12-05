plugins {
    kotlin("jvm")
    id("fabric-loom")
    `maven-publish`
    java
}

group = property("maven_group")!!
version = property("mod_version")!!

repositories {
    // Add repositories to retrieve artifacts from in here.
    // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
    // See https://docs.gradle.org/current/userguide/declaring_repositories.html
}

dependencies {
    minecraft("com.mojang:minecraft:1.19.2")
    mappings("net.fabricmc:yarn:22w13oneblockatatime+build.1:v2")
    modImplementation("net.fabricmc:fabric-loader:0.14.10")

    modImplementation("net.fabricmc:fabric-language-kotlin:1.8.7+kotlin.1.7.22")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.68.1+1.19.3")
}

tasks {

    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        from("LICENSE.md")
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                artifact(remapJar) {
                    builtBy(remapJar)
                }
                artifact(kotlinSourcesJar) {
                    builtBy(remapSourcesJar)
                }
            }
        }

        // select the repositories you want to publish to
        repositories {
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    withSourcesJar()
}
