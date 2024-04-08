plugins {
    id("java")
}

group = "io.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // embedded tomcat
    implementation ("org.apache.tomcat.embed:tomcat-embed-core:8.5.42")
    implementation ("org.apache.tomcat.embed:tomcat-embed-jasper:8.5.42")

    implementation ("ch.qos.logback:logback-classic:1.4.14")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation ("org.assertj:assertj-core:3.25.3")
}

tasks.test {
    useJUnitPlatform()
}