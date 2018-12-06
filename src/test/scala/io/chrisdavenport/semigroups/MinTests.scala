package io.chrisdavenport.semigroups

import cats._
import cats.tests.CatsSuite
import cats.kernel.laws.discipline._
import cats.laws.discipline._

class MinTests extends CatsSuite with SemigroupsArbitraries {
  checkAll("Min", OrderTests[Min[Int]].order)
  checkAll("Min", SemigroupTests[Min[Int]].semigroup)
  checkAll("Min", MonadTests[Min].monad)
  checkAll("Min", NonEmptyTraverseTests[Min].nonEmptyTraverse[Option, Int, Int, Int, Int, Option, Option])
  checkAll("Min", DistributiveTests[Min].distributive[Int, Int, Int, Option, Id])

  test("show"){
    Min(true).show shouldEqual "Min(true)"
    Min(false).show shouldEqual "Min(false)"
  }

  test("returns Smaller"){
      val first = Min(1)
      val second = Min(3)
      first |+| second shouldEqual first
  }

}