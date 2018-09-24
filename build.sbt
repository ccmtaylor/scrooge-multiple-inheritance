import com.twitter.scrooge.ScroogeSBT.autoImport.{scroogePublishThrift, _}

lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-thrift" % "18.9.0",
      "com.twitter" %% "scrooge-core" % "18.9.0"
    ),
    scroogePublishThrift := true,
    scroogeThriftSourceFolder := baseDirectory(_ / "src" / "main" / "thrift").value,
    unmanagedResourceDirectories in Compile += baseDirectory(_ / "src" / "main" / "thrift").value
  )
