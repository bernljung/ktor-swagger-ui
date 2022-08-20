import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    `maven-publish`
}

group = "io.github.smiley4"
version = "0.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.0.1")
    implementation("io.ktor:ktor-server-webjars:2.0.1")
    implementation("io.ktor:ktor-server-auth:2.0.1")
    implementation("org.webjars:swagger-ui:4.13.2")
    implementation("io.swagger.parser.v3:swagger-parser:2.1.1")
    implementation("com.github.victools:jsonschema-generator:4.25.0")
    implementation("com.github.victools:jsonschema-module-jackson:4.25.0")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")

    testImplementation("io.ktor:ktor-server-netty-jvm:2.0.1")
    testImplementation("io.ktor:ktor-server-content-negotiation:2.0.1")
    testImplementation("io.ktor:ktor-serialization-jackson:2.0.1")
    testImplementation("io.ktor:ktor-server-auth:2.0.1")
    testImplementation("ch.qos.logback:logback-classic:1.2.11")
    testImplementation("io.ktor:ktor-server-call-logging:2.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "ktor-swagger-ui"
            from(components["java"])
            pom {
                name.set("Ktor Swagger-UI")
                description.set("Ktor plugin to document routes and enable Swagger UI ")
                url.set("https://github.com/SMILEY4/ktor-swagger-ui")
            }
        }
    }
}