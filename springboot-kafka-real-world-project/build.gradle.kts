plugins {
    id("java") apply true
    id("org.springframework.boot") version "3.3.0" apply false
    id("io.spring.dependency-management") version "1.1.5" apply false
}

group = "org.ivc.nikstanov"
version = "1.0-SNAPSHOT"

allprojects{
    apply(plugin = "java")
    dependencies{
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    repositories {
        mavenCentral()
    }

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

    tasks.test {
        useJUnitPlatform()
    }
}
dependencies {

}

