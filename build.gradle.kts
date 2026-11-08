plugins {
    id("org.springframework.boot") version "4.0.9"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.graalvm.buildtools.native") version "0.11.5"
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
}

group = "de.tschuehly"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

// Kotlin 2.2 cannot emit Java 25 bytecode; compile for 17, build/run on JDK 25 (GraalVM 25 for native).
tasks.withType<JavaCompile> {
    options.release = 17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.springframework.boot:spring-boot-starter-aspectj")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("tools.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("de.tschuehly:spring-view-component-thymeleaf:0.9.1")

    implementation("org.webjars.npm:htmx.org:1.9.10")
    implementation("org.webjars.npm:alpinejs:3.13.3")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    main {
        resources {
            srcDir("src/main/kotlin")
            exclude("**/*.kt")
        }
    }
}

graalvmNative {
    binaries {
        named("main") {
            // libc dynamic, everything else static: runs on gcr.io/distroless/base
            buildArgs.add("-H:+StaticExecutableWithDynamicLibC")
        }
    }
}
