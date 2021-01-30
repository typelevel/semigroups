package io.chrisdavenport.semigroups

import cats._
import cats.kernel.laws.discipline._
import cats.laws.discipline._
import cats.implicits._
import org.scalatest.funsuite.AnyFunSuite
import org.typelevel.discipline.scalatest.FunSuiteDiscipline
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class MinTests extends AnyFunSuite with SemigroupsArbitraries with FunSuiteDiscipline with Matchers with ScalaCheckDrivenPropertyChecks{
  checkAll("Min", OrderTests[Min[Int]].order)
  checkAll("Min", BoundedSemilatticeTests[Min[Int]].boundedSemilattice)
  checkAll("Min", MonadTests[Min].monad[Int, Int, Int])
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