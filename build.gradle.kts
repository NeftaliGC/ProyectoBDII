plugins {
    id("java")
}

group = "com.nintech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
// https://mvnrepository.com/artifact/org.postgresql/postgresql
implementation("org.postgresql:postgresql:42.6.0")
}

subprojects {
    tasks.withType<JavaCompile> {
        options.isDeprecation = true
    }
}

tasks.test {
    useJUnitPlatform()
}