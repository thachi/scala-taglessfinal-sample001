package models

import cats.Monad
import cats.implicits._
import core.Identifier

class Service[F[_] : Monad](
                             val imageRepository: ImageRepository[F],
                             val blogRepository: BlogRepository[F]
                           ) {

  def createBlog(title: String, content: String, imageurl: String): F[Identifier[Blog]] = for {
    imageId <- imageRepository.allocate()
    _ <- imageRepository.create(Image(imageId, imageurl))
    blogId <- blogRepository.allocate()
    blog = Blog(blogId, title, content, imageId)
    _ <- blogRepository.create(blog)
  } yield blogId

}
