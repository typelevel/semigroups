package io.chrisdavenport.semigroups

import cats.Semigroup

final case class Dual[A](getDual: A) extends AnyVal
object Dual {
  implicit def dualSemigroup[A: Semigroup]: Semigroup[Dual[A]] = new Semigroup[Dual[A]]{
    def combine(x: Dual[A], y: Dual[A]): Dual[A] = Dual(Semigroup[A].combine(y.getDual, x.getDual))
  }
}