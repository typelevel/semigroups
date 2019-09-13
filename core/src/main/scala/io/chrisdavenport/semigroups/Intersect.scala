package io.chrisdavenport.semigroups

import cats._
import cats.implicits._
import cats.kernel.{Semilattice, CommutativeMonoid}

final case class Intersect[A](getIntersect: Set[A]) extends AnyVal
object Intersect extends IntersectInstances

private[semigroups] abstract class IntersectInstances  {

  implicit def intersectSemilattice[A]: Semilattice[Intersect[A]] = new Semilattice[Intersect[A]] {
    def combine(x: Intersect[A], y: Intersect[A]): Intersect[A] = Intersect(x.getIntersect.intersect(y.getIntersect))
  }

  implicit def intersectShow[A: Show]: Show[Intersect[A]] = 
    Show.show[Intersect[A]](ia => show"Intersect(${ia.getIntersect})")

  implicit def IntersectEq[A: Eq]: Eq[Intersect[A]] = Eq.by(_.getIntersect)

  implicit val intersectInstances: MonoidK[Intersect] with UnorderedTraverse[Intersect] = 
    new MonoidK[Intersect] with UnorderedTraverse[Intersect] {
      def empty[A]: Intersect[A] = Intersect(MonoidK[Set].empty)
      def combineK[A](x: Intersect[A], y: Intersect[A]): Intersect[A] = 
        Intersect(SemigroupK[Set].combineK(x.getIntersect, y.getIntersect))
      def unorderedTraverse[G[_]: CommutativeApplicative, A, B](sa: Intersect[A])(f: A => G[B]): G[Intersect[B]] = 
        UnorderedTraverse[Set].unorderedTraverse(sa.getIntersect)(f).map(Intersect(_))
      def unorderedFoldMap[A, B: CommutativeMonoid](fa: Intersect[A])(f: A => B): B =
        UnorderedFoldable[Set].unorderedFoldMap(fa.getIntersect)(f)
    }
}
