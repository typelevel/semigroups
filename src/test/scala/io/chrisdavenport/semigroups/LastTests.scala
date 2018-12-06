package io.chrisdavenport.semigroups

import cats._
import cats.tests.CatsSuite
import cats.kernel.laws.discipline._
import cats.laws.discipline._

class LastTests extends CatsSuite with SemigroupsArbitraries {
  checkAll("Last", OrderTests[Last[Int]].order)
  checkAll("Last", SemigroupTests[Last[Int]].semigroup)
  checkAll("Last", MonadTests[Last].monad)
  checkAll("Last", NonEmptyTraverseTests[Last].nonEmptyTraverse[Option, Int, Int, Int, Int, Option, Option])
  checkAll("Last", DistributiveTests[Last].distributive[Int, Int, Int, Option, Id])

  test("show"){
    Last(true).show shouldEqual "Last(true)"
    Last(false).show shouldEqual "Last(false)"
  }

  test("returns Last"){
      val first = Last("Hello ")
      val second = Last("World")
      first |+| second shouldEqual second
  }

}