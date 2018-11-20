package io.chrisdavenport.semigroups

import cats.kernel.Semigroup
import cats.kernel.Order

final case class Min[A](getMin: A) extends AnyVal
object Min {
  implicit def orderedMinSemigroup[A: Order]: Semigroup[Min[A]] = new Semigroup[Min[A]]{
    def combine(x: Min[A], y: Min[A]): Min[A] = 
      Min(Order.min(x.getMin, y.getMin))
  }
}