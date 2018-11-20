package io.chrisdavenport.semigroups

import cats._

final case class First[A](getFirst: A) extends AnyVal
object First {
  implicit def firstSemigroup[A]: Semigroup[First[A]] = new Semigroup[First[A]]{
    def combine(x: First[A], y: First[A]): First[A] = x
  }
}