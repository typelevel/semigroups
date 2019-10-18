package io.chrisdavenport.semigroups

import cats._
import cats.kernel.laws.discipline._
import cats.laws.discipline._
import cats.implicits._
import org.scalatest.funsuite.AnyFunSuite
import org.typelevel.discipline.scalatest.Discipline
import org.scalatest.Matchers

class LastTests extends AnyFunSuite with SemigroupsArbitraries with Discipline with Matchers {
  checkAll("Last", OrderTests[Last[Int]].order)
  checkAll("Last", BandTests[Last[Int]].band)
  checkAll("Last", MonadTests[Last].monad[Int, Int, Int])
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