//// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript{
//    repositories {
//        // Make sure that you have the following two repositories
//        google()
//
//        mavenCentral()
//    }
//    dependencies {
//
//        // Add the depency for the Google services Gradle Plugin
//
//    }
//}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    id("com.google.gms.google-services") version "4.4.2" apply false


}