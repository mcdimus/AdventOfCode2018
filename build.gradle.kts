import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.10"
}

group = "eu.maksimov.advent"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform() {
        includeEngines("spek")
    }
}

dependencies {
    compile(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.platform:junit-platform-runner:1.3.2")
    testImplementation("org.junit.platform:junit-platform-launcher:1.3.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.0.0")
    testImplementation(kotlin("reflect"))
    testImplementation(kotlin("test"))
    testCompile("org.jetbrains.spek:spek-api:1.1.5")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
    testCompile("org.assertj:assertj-core:3.11.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Wrapper> {
    gradleVersion = "5.0"
    distributionType = Wrapper.DistributionType.ALL
}