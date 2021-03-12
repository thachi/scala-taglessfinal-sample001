package core

import cats.Monad


abstract class Repository[F[_] : Monad, A <: Entity[A]] {

  def allocate(): F[Identifier[A]]

  def create(entity: A): F[Unit]

}


trait Entity[+E]

trait Identifier[+E <: Entity[E]]

case class StringIdentifier[E <: Entity[E]](value: String) extends Identifier[E]

case object Undefined extends Identifier[Nothing]

