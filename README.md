# semigroups [![Build Status](https://travis-ci.com/ChristopherDavenport/semigroups.svg?branch=master)](https://travis-ci.com/ChristopherDavenport/semigroups) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/semigroups_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/semigroups_2.12)


Set of Generic Semigroup Types and Accompanying Instances very useful for abstract programming.

Exposes instances for

- `Dual` inverts the combine operation.
- `Max` exposes a Max that given an `Order` will return the maximum value.
- `Min` exposes a Min that given an `Order` will returh the minimum value.

## Quick Start

To use this project in an existing SBT project with Scala 2.11 or a later version, add the following dependencies to your
`build.sbt` depending on your needs:

```scala
libraryDependencies ++= Seq(
  "io.chrisdavenport" %% "semigroups"     % "<version>"
)
```
