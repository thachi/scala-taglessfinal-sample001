package interpreter

import core._
import models.{Blog, BlogRepository, Image, ImageRepository}

import scala.collection.mutable
import scala.util.Try

object DebugBlogRepositoryInterpreter extends BlogRepository[Try] {

  private val blogs = mutable.HashMap.empty[Identifier[Blog], Blog]


  def getBlogs: Seq[Blog] = blogs.values.toSeq

  override def allocate(): Try[Identifier[Blog]] = Try {
    StringIdentifier("blog-" + (blogs.size + 1))
  }

  override def create(entity: Blog): Try[Unit] = Try {
    blogs += entity.id -> entity
  }
}


object DebugImageRepositoryInterpreter extends ImageRepository[Try] {

  private val images = mutable.HashMap.empty[Identifier[Image], Image]

  def getImages: Seq[Image] = images.values.toSeq


  override def allocate(): Try[Identifier[Image]] = Try {
    StringIdentifier("image-" + (images.size + 1))
  }

  override def create(entity: Image): Try[Unit] = Try {
    images += entity.id -> entity
  }
}



