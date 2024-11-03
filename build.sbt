
scalaVersion := "2.12.15"

name := "scalaSparkApp"
organization := "com.example"
version := "1.0"

val sparkVersion = "3.4.4"

libraryDependencies ++= Seq(
	    "org.apache.spark"              %% "spark-core"         % sparkVersion  % Provided,
        "org.apache.spark"              %% "spark-sql"          % sparkVersion  % Provided,
        "org.apache.spark"              %% "spark-hive"         % sparkVersion  % Test,
        "org.apache.spark"              %% "spark-streaming"    % sparkVersion  % Test,
        "com.holdenkarau"               %% "spark-testing-base" % "3.4.1_1.5.3" % Test
        "io.delta"                      %% "delta-core"         % "2.4.0"       % Provided,
        "org.scalatest"                 %% "scalatest"          % "3.1.4"       % Test,
        "net.javacrumbs.json-unit"      % "json-unit-assertj"   % "2.9.0"       % Test,
        "com.github.scopt"              %% "scopt"              % "4.0.1"
)

fork := true