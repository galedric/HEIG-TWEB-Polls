name := """tweb-polls"""
version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"
scalacOptions ++= Seq(
	//"-Xlog-implicits",
	"-feature",
	"-deprecation",
	"-Xfatal-warnings",
	"-unchecked",
	"-language:reflectiveCalls",
	"-language:higherKinds"
)

incOptions := incOptions.value.withNameHashing(true)
updateOptions := updateOptions.value.withCachedResolution(cachedResoluton = true)

libraryDependencies ++= Seq(cache)

//angular2 dependencies
libraryDependencies ++= {
	val ngVersion = "2.4.4"
	Seq(
		"org.webjars.npm" % "angular__common" % ngVersion,
		"org.webjars.npm" % "angular__compiler" % ngVersion,
		"org.webjars.npm" % "angular__core" % ngVersion,
		"org.webjars.npm" % "angular__http" % ngVersion,
		"org.webjars.npm" % "angular__forms" % ngVersion,
		"org.webjars.npm" % "angular__router" % "3.4.4",
		"org.webjars.npm" % "angular__platform-browser-dynamic" % ngVersion,
		"org.webjars.npm" % "angular__platform-browser" % ngVersion,
		"org.webjars.npm" % "angular__material" % "2.0.0-beta.1",
		"org.webjars.npm" % "systemjs" % "0.19.41",
		"org.webjars.npm" % "zone.js" % "0.6.26",
		"org.webjars.npm" % "rxjs" % "5.0.3",
		"org.webjars.npm" % "reflect-metadata" % "0.1.9",
		"org.webjars.npm" % "core-js" % "2.4.1",
		"org.webjars.npm" % "symbol-observable" % "1.0.4"
	)
}

// use the webjars npm directory (target/web/node_modules ) for resolution of module imports of angular2/core etc
resolveFromWebjarsNodeModulesDir := true

routesGenerator := InjectedRoutesGenerator

enablePlugins(DockerPlugin)
