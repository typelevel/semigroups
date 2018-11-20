package io.chrisdavenport.semigroups

import cats._

final case class Last[A](getLast: A) extends AnyVal

object Last {
  implicit def lastSemigroup[A]: Semigroup[Last[A]] = new Semigroup[Last[A]]{
    def combine(x: Last[A], y: Last[A]): Last[A] = y
  }
}