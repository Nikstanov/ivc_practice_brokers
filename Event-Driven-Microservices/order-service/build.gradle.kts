plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
}

dependencies{
	implementation(project(":base-domain"))
}
