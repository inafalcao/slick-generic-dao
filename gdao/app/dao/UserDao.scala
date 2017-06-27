package dao

import db.GenericDao
import entity.user.{User, UserTable}
import scaldi.Injector
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by inafalcao on 5/20/17.
  */
abstract class UserDao(implicit inj: Injector) extends GenericDao[UserTable, Long]{

}
