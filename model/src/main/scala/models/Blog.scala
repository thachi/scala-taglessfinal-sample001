package models

import cats.Monad
import core.{Entity, Identifier, Repository, Undefined}

case class BlogId(id: String) extends Identifier[Blog]

case class Blog(id: Identifier[Blog] = Undefined, title: String, content: String, image: Identifier[Image]) extends Entity[Blog]

abstract class BlogRepository[F[_] : Monad] extends Repository[F, Blog]
