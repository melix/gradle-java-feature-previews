plugins {
    `java-library`
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

// If you're running Gradle with Java 14 and want to try
// records, the two following configuration blocks are enough
tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("--enable-preview")
}

// Gradle also works currently with Java 15 ea+26, but if it didn't
// you could run it with 14 and fork compilation to use 15

providers.environmentVariable("JDK15")
        .forUseAtConfigurationTime()
        .map(::File)
        .orNull?.let { javaHome ->
            println("Configuring your build to use JDK 15 from $javaHome")
            tasks.withType<Test>().configureEach {
                executable = "${javaHome}/bin/java"
                jvmArgs("--enable-preview")
            }

            tasks.withType<JavaCompile>().configureEach {
                options.isFork = true
                options.forkOptions.javaHome = javaHome
                options.compilerArgs.addAll(listOf("--enable-preview", "--release", "15"))
            }
        }

