package controllers

import javax.inject._

import dao.UserDao
import entity.user.User
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import scaldi.{Injectable, Injector}
import scala.concurrent.ExecutionContext.Implicits.global


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController(implicit inj: Injector) extends Controller with Injectable {

  val userDao = inject[UserDao]

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action.async { implicit request =>
    //Ok
    userDao.insert(User(3, "inafalcao3@gmail.com", "senha")).map(e => Ok(Json.toJson(e)))
  }
}
