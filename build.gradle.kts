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
    implementation("org.json:json:20210307")
    implementation("org.jfree:jfreechart:1.5.3")
implementation ("org.apache.httpcomponents:httpclient:4.5.13")
}

subprojects {
    tasks.withType<JavaCompile> {
        options.isDeprecation = true
    }
}

tasks.test {
    useJUnitPlatform()
}