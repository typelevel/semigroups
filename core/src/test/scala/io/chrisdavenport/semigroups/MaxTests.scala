package io.chrisdavenport.semigroups

import cats._
import cats.tests.CatsSuite
import cats.kernel.laws.discipline._
import cats.laws.discipline._

class MaxTests extends CatsSuite with SemigroupsArbitraries {
  checkAll("Max", OrderTests[Max[Int]].order)
  checkAll("Max", SemilatticeTests[Max[Int]].semilattice)
  checkAll("Max", MonadTests[Max].monad)
  checkAll("Max", NonEmptyTraverseTests[Max].nonEmptyTraverse[Option, Int, Int, Int, Int, Option, Option])
  checkAll("Max", DistributiveTests[Max].distributive[Int, Int, Int, Option, Id])

  test("show"){
    Max(true).show shouldEqual "Max(true)"
    Max(false).show shouldEqual "Max(false)"
  }

  test("returns Larger"){
      val first = Max(1)
      val second = Max(3)
      first |+| second shouldEqual second
  }

}