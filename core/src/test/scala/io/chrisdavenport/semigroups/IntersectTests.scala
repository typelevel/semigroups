package io.chrisdavenport.semigroups

import cats.kernel.laws.discipline._
import cats.laws.discipline._
import cats.implicits._
import org.scalatest.funsuite.AnyFunSuite
import org.typelevel.discipline.scalatest.Discipline
import org.scalatest.Matchers

class IntersectTests extends AnyFunSuite with SemigroupsArbitraries with Discipline with Matchers {
  checkAll("Intersect", EqTests[Intersect[Int]].eqv)
  checkAll("Intersect", SemilatticeTests[Intersect[Int]].semilattice)
  checkAll("Intersect", MonoidKTests[Intersect].monoidK[Int])
  checkAll("Intersect", UnorderedTraverseTests[Intersect].unorderedTraverse[Int, Int, Int, Option, Option])

  test("show"){
    Intersect(Set(1, 2)).show shouldEqual "Intersect(Set(1, 2))"
    Intersect(Set(1)).show shouldEqual "Intersect(Set(1))"
    Intersect(Set.empty[Int]).show shouldEqual "Intersect(Set())"
  }

  test("returns Intersect"){
      val first = Intersect(Set(1, 2, 3))
      val second = Intersect(Set(2, 3, 4))
      first |+| second shouldEqual Intersect(Set(2, 3))
  }

}