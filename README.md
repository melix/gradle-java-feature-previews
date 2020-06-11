## Enabling Java feature previews in Gradle

This project demonstrates how to configure your Gradle build to enable feature previews
in Java.

It uses a [JDK 14 record](https://blogs.oracle.com/javamagazine/records-come-to-java) as an example, as well as [JDK 15 sealed types](https://blogs.oracle.com/javamagazine/inside-the-language-sealed-types).

Enabling feature previews is trivial, just be aware that this is NOT for production code.

It assumes you will run with JDK 14 or JDK 15.
If you want to run Gradle with an older JDK, and compile/test with JDK 15, just set the `JDK15` environment variable to point to your JDK 15 installation.
Future releases of Gradle will make it even easier to configure cross-compilation (using a different JDK than what Gradle itself is using).

Details can be found in this [blog post](https://melix.github.io/blog/2020/06/java-feature-previews-gradle.html).