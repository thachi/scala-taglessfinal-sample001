package interpreter

import core.StringIdentifier
import org.scalatest.funsuite.AnyFunSuite
import models._
import cats._

import scala.util.Success

class DebugRepositoryInterpreterTest extends AnyFunSuite {

  val service = new Service(DebugImageRepositoryInterpreter, DebugBlogRepositoryInterpreter)

  test("ざっくり試してみる") {
    val Success(created) = service.createBlog("たいとる", "コンテンツ", "https://image.example.com/path/to/image.png")

    assert(created == StringIdentifier("blog-1"))

    assert(DebugBlogRepositoryInterpreter.getBlogs.size == 1)
    assert(DebugBlogRepositoryInterpreter.getBlogs.head.id == StringIdentifier("blog-1"))
    assert(DebugImageRepositoryInterpreter.getImages.size == 1)
    assert(DebugImageRepositoryInterpreter.getImages.head.id == StringIdentifier("image-1"))
  }

}
