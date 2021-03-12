package models

import cats.Monad
import core.{Entity, Identifier, Repository, Undefined}

case class ImageId(id: String) extends Identifier[Image]

case class Image(id: Identifier[Image] = Undefined, url: String, alt: Option[String] = None) extends Entity[Image]

abstract class ImageRepository[F[_] : Monad] extends Repository[F, Image]
