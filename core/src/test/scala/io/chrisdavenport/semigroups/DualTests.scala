package io.chrisdavenport.semigroups

import cats._
import cats.tests.CatsSuite
import cats.kernel.laws.discipline._
import cats.laws.discipline._

class DualTests extends CatsSuite with SemigroupsArbitraries {
  checkAll("Dual", OrderTests[Dual[Int]].order)
  checkAll("Dual", SemigroupTests[Dual[Int]].semigroup)
  checkAll("Dual", MonadTests[Dual].monad)
  checkAll("Dual", NonEmptyTraverseTests[Dual].nonEmptyTraverse[Option, Int, Int, Int, Int, Option, Option])
  checkAll("Dual", DistributiveTests[Dual].distributive[Int, Int, Int, Option, Id])

  test("show"){
    Dual(true).show shouldEqual "Dual(true)"
    Dual(false).show shouldEqual "Dual(false)"
  }

  test("inverse default"){
      val first = "Hello "
      val second = "World"
      val expected = "Hello World"
      first |+| second shouldEqual expected 
      (Dual(second) |+| Dual(first)).getDual shouldEqual expected
  }
}