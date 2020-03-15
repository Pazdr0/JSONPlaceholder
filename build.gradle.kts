plugins {
    kotlin("jvm") version "1.3.61"
    id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "org.example"
version = "1.0-SNAPSHOT"

buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.openjfx:javafx-plugin:0.0.8")
    }
}
apply(plugin = "org.openjfx.javafxplugin")

javafx {
    version = "11"
    modules("javafx.controls")
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.code.gson:gson:2.8.6")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testCompile("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()

        testLogging.showStandardStreams = true
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}