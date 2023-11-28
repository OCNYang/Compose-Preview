plugins {
    id("org.jetbrains.kotlin.jvm")
}

group = "com.ocnyang"
version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.20-1.0.14")
    implementation("com.squareup:kotlinpoet:1.15.1")
    implementation("androidx.annotation:annotation:1.6.0")
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}
