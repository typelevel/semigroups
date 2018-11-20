package io.chrisdavenport.semigroups

import cats.kernel.{Semigroup, Order}

final case class Max[A](getMax: A) extends AnyVal
object Max {
  implicit def orderedMaxSemigroup[A: Order]: Semigroup[Max[A]] = new Semigroup[Max[A]]{
    def combine(x: Max[A], y: Max[A]): Max[A] = Max(Order[A].max(x.getMax, y.getMax))
  }
}