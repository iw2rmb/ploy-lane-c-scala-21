plugins { application; id("com.google.cloud.tools.jib") version "3.4.0" }
repositories { mavenCentral() }
dependencies { implementation("io.undertow:undertow-core:2.3.12.Final") }
application { mainClass.set("com.ploy.app.Main") }
jib { from { image = "eclipse-temurin:21-jre" } to { image = System.getenv("JIB_TO_IMAGE") ?: "registry.dev.ployman.app/ploy-lane-c-scala-21:dev" } container { ports=listOf("8080"); mainClass = "com.ploy.app.Main" } }
