package io.chrisdavenport.semigroups

import cats._
import cats.kernel.laws.discipline._
import cats.laws.discipline._
import cats.implicits._
import org.scalatest.funsuite.AnyFunSuite
import org.typelevel.discipline.scalatest.FunSuiteDiscipline
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class MaxTests extends AnyFunSuite with SemigroupsArbitraries with FunSuiteDiscipline with Matchers with ScalaCheckDrivenPropertyChecks{
  checkAll("Max", OrderTests[Max[Int]].order)
  checkAll("Max", BoundedSemilatticeTests[Max[Int]].boundedSemilattice)
  checkAll("Max", MonadTests[Max].monad[Int, Int, Int])
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