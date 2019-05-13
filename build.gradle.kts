@file:Suppress("SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `maven-publish`
    kotlin("jvm") version "1.3.31"
    id("com.github.gmazzo.buildconfig") version "1.5.0"
}

val kProjectVersion = "0.0.1"

group = "ca.warp7.rt.router"
version = kProjectVersion

val kRootDir = ".rt-router"
val kStorePath = "$kRootDir/$kProjectVersion/"


tasks {
    val checkInKey = create("checkInKey") {
        val key = project.properties["tbaKey"] ?: ""
        buildConfig {
            forClass("ca.warp7.rt.router.internal", "BuildConfig") {
                buildConfigField("String", "tbaKey", "\"$key\"")
            }
        }
    }

    test { dependsOn(checkInKey) }
}

buildConfig {
    forClass("ca.warp7.rt.router.internal", "BuildConfig") {
        buildConfigField("String", "kProjectVersion", "\"$kProjectVersion\"")
        buildConfigField("String", "kStorePath", "\"$kStorePath\"")
    }
}

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    // Kotlin Coroutines
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = "1.2.1")
    // HTTP Requests Library
    implementation(group = "com.github.kittinunf.fuel", name = "fuel", version = "2.0.1")
    // JSON Library
    implementation(group = "com.beust", name = "klaxon", version = "5.0.5")
    // Test Libraries
    testImplementation(kotlin("test"))
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    repositories {
        maven {
            // change to point to your repo, e.g. http://my.org/repo
            url = uri("$buildDir/repo")
        }
    }
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
            artifactId = "rt-router"
        }
    }
}