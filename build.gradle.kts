import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.1" apply false
	id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false
	id("org.jetbrains.kotlin.jvm") version "1.4.0"
	id("org.jetbrains.kotlin.plugin.spring") version "1.3.72" apply false
}

allprojects{
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	group = "com.example"
	version = "0.0.1-SNAPSHOT"

	java {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	repositories {
		mavenCentral()
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {
	tasks {
		withType<Jar>() {
			enabled = true
		}

		withType<org.springframework.boot.gradle.tasks.bundling.BootJar>() {
			enabled = false
		}
	}
}

project(":application"){
	dependencies{
		implementation(project(":domain"))
	}
}

dependencies{
	implementation(project(":application"))
}
