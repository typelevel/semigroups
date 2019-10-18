package io.chrisdavenport.semigroups

import cats._
import cats.kernel.laws.discipline._
import cats.laws.discipline._
import cats.implicits._
import org.scalatest.funsuite.AnyFunSuite
import org.typelevel.discipline.scalatest.Discipline
import org.scalatest.Matchers

class FirstTests extends AnyFunSuite with SemigroupsArbitraries with Discipline with Matchers {
  checkAll("First", OrderTests[First[Int]].order)
  checkAll("First", BandTests[First[Int]].band)
  checkAll("First", MonadTests[First].monad[Int, Int, Int])
  checkAll("First", NonEmptyTraverseTests[First].nonEmptyTraverse[Option, Int, Int, Int, Int, Option, Option])
  checkAll("First", DistributiveTests[First].distributive[Int, Int, Int, Option, Id])

  test("show"){
    First(true).show shouldEqual "First(true)"
    First(false).show shouldEqual "First(false)"
  }

  test("returns first"){
      val first = First("Hello ")
      val second = First("World")
      first |+| second shouldEqual first
  }

}