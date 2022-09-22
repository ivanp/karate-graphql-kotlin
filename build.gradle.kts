import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "com.primaguna"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.intuit.karate:karate-junit5:1.2.0")
    testImplementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation("net.masterthought:cucumber-reporting:5.7.2")
}

tasks.test {
    useJUnitPlatform()
    systemProperties(mapOf<String, Any?>(
        "karate.options" to (project.properties["karate.options"] ?: ""),
        "karate.env" to (project.properties["karate.env"] ?: ""),
        "karate.config.dir" to "src/test/kotlin",
        "test.parallel" to (project.properties["test.parallel"] ?: true)
    ))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

sourceSets {
    test {
        resources {
            srcDir(file("src/test/kotlin"))
            exclude("**/*.kt")
        }
    }
}