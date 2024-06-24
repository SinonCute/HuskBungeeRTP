plugins {
    `java-library`
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
    maven {
        url = uri("https://repo.minebench.de/")
    }
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    maven {
        name = "william278Releases"
        url = uri("https://repo.william278.net/releases")
    }
}


dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    compileOnly("net.william278:huskhomes:4.5.5")
    implementation("redis.clients:jedis:5.1.3")
    implementation("com.zaxxer:HikariCP:5.0.1")
}

group = "me.William278"
version = "1.1.1"
description = "HuskBungeeRTP"
java.sourceCompatibility = JavaVersion.VERSION_16

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks {
//    processResources {
//        outputs.upToDateWhen { false }
//        filesMatching(listOf("**/plugin.yml")) {
//            expand(mapOf("version" to project.version.toString()))
//            println("$name: set version to ${project.version}")
//        }
//        duplicatesStrategy = DuplicatesStrategy.INCLUDE
//        filteringCharset = Charsets.UTF_8.name()
//    }

    shadowJar {
        archiveFileName.set("HuskBungeeRTP-${project.version}.jar")
    }

    assemble {
        dependsOn(processResources, shadowJar)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}
