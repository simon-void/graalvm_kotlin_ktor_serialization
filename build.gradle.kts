
plugins {
    application
    id("org.graalvm.buildtools.native") version "0.9.25"
    val kotlinVersion = "1.9.10"
    kotlin("jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.serialization") version kotlinVersion
}

group = "simonvoid.gmx.de"
version = "0.0.1"
application {
    mainClass.set("simonvoid.gmx.de.ktor_graalvm.ApplicationKt")
}

//kotlin {
//    // uses org.gradle.java.installations.auto-download=false in gradle.properties to disable auto provisioning of JDK
//    jvmToolchain(17)
//}

repositories {
    mavenCentral()
}

dependencies {
    val ktorVersion = "2.3.4"

    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-cio:$ktorVersion")


    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
    testImplementation(kotlin("test"))
}

tasks {
    test {
        useJUnitPlatform()
    }
}

graalvmNative {
    binaries {
        named("main") {
            fallback.set(false)
            verbose.set(true)

            buildArgs.add("--initialize-at-build-time=io.ktor,kotlin")

            buildArgs.add("-H:+InstallExitHandlers")
            buildArgs.add("-H:+ReportUnsupportedElementsAtRuntime")
            buildArgs.add("-H:+ReportExceptionStackTraces")
            buildArgs.add("--initialize-at-build-time=kotlinx.coroutines")
            buildArgs.add("--initialize-at-build-time=org.slf4j.LoggerFactory")

            imageName.set("graalvm_kotlin_ktor_serialization")
        }
    }
}