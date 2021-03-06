@file:Suppress("SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `maven-publish`
    kotlin("jvm") version "1.3.50"
    id("com.github.gmazzo.buildconfig") version "1.5.0"
    id("com.gradle.build-scan") version "2.3"
}

val kProjectVersion = "0.0.1"

group = "ca.warp7.rt.router"
version = kProjectVersion

val Any?.quoted get() = "\"$this\""

val kBuildConfigPackage = "ca.warp7.rt.router.impl"
val kBuildConfigClass = "BuildConfig"

val kRootDir = ".rt-router"
val kStorePath = "/$kRootDir/$kProjectVersion/"
val kPropertiesFile = "router.properties"

val kUserAgent = "${project.name} / $kProjectVersion"

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
}

buildConfig {
    forClass(kBuildConfigPackage, kBuildConfigClass) {
        buildConfigField("String", "kStorePath", kStorePath.quoted)
        buildConfigField("String", "kPropertiesFile", kPropertiesFile.quoted)
        buildConfigField("String", "kUserAgent", kUserAgent.quoted)
    }
}

tasks {
    val checkInKey = create("checkInKey") {
        val key = project.properties["tbaKey"]
        buildConfig {
            forClass(kBuildConfigPackage, kBuildConfigClass) {
                buildConfigField("String", "tbaKey", key.quoted)
            }
        }
    }

    test { dependsOn(checkInKey) }
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
    // Support Library to integrate Fuel and Coroutines
    implementation(group = "com.github.kittinunf.fuel", name = "fuel-coroutines", version = "2.0.1")
    // JSON Library
    implementation(group = "com.beust", name = "klaxon", version = "5.0.5")
    // DataFrame Library
    implementation(group = "de.mpicbg.scicomp", name = "krangl", version = "0.11")
    // Test Libraries
    testImplementation(kotlin("test"))
    testImplementation(group = "junit", name = "junit", version = "4.12")
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
    exclude("ca/warp7/rt/router/impl/**/*.kt")
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
            artifactId = "rt-router"
        }
    }
    repositories {
        maven {
            // change to point to your repo, e.g. http://my.org/repo
            url = uri("$buildDir/maven")
        }
    }
}