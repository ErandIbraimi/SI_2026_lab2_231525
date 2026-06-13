plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("-ea")
}

application {
    mainClass.set("org.example.SI2026Lab2Main")
}