plugins {
	java
	id("org.springframework.boot") version "3.3.0" apply true
	id("io.spring.dependency-management") version "1.1.5" apply true
}

group = "com.ivc.nikstanov"
version = "0.0.1-SNAPSHOT"

allprojects{
	apply(plugin = "java")
	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(17)
		}
	}
	configurations {
		compileOnly {
			extendsFrom(configurations.annotationProcessor.get())
		}
	}
	repositories {
		mavenCentral()
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.kafka:spring-kafka")
		compileOnly("org.projectlombok:lombok")
		annotationProcessor("org.projectlombok:lombok")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.springframework.kafka:spring-kafka-test")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}








