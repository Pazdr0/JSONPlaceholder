plugins {
    kotlin("jvm") version "1.3.61"
    id("org.openjfx.javafxplugin") version "0.0.8"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "bgolc.jsonplaceholder"
version = "1.0-SNAPSHOT"

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
    testCompile("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testCompile("org.junit.jupiter:junit-jupiter-engine:5.4.2")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.4.2")
    testCompile("org.mockito:mockito-core:2.+")
}


buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.openjfx:javafx-plugin:0.0.8")
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
    }
}

apply(plugin = "org.openjfx.javafxplugin")
apply(plugin = "com.github.johnrengelman.shadow")

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    jar {
        manifest {
            attributes(
                mapOf("Main-Class" to "bgolc.jsonplaceholder.StartGUI")
            )
        }
    }
    test {
        useJUnitPlatform()

        testLogging.showStandardStreams = true
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}