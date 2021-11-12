plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.2.1" // https://github.com/JetBrains/gradle-intellij-plugin and https://lp.jetbrains.com/gradle-intellij-plugin/
}

// Import variables from gradle.properties file
val pluginIdeaVersion: String by project
val pluginDownloadIdeaSources: String by project
val pluginVersion: String by project
val pluginJavaVersion: String by project

group = "jug.demo"
version = pluginVersion

repositories {
    mavenCentral()
}

intellij {
    downloadSources.set(pluginDownloadIdeaSources.toBoolean())
    pluginName.set("JUG Clock Demo")
    updateSinceUntilBuild.set(false)
    version.set(pluginIdeaVersion)
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = pluginJavaVersion
        targetCompatibility = pluginJavaVersion
        options.compilerArgs = listOf("-Xlint:deprecation")
    }
    buildSearchableOptions {
        enabled = false
    }
}
