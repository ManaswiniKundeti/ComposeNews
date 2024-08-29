// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Apply the Kotlin Gradle plugin
    kotlin("android") version "1.8.21" apply false
    kotlin("kapt") version "1.8.21" apply false
    id("com.android.application") version "8.0.0" apply false
    id("com.android.library") version "8.0.0" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
}

// Define common configurations for all projects/modules
allprojects {
    // Add common configurations here if needed
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}