package entity.user

import entity.GenericTable
import slick.jdbc.PostgresProfile.api._
import slick.lifted.{TableQuery, Tag}

/**
  * Created by inafalcao on 5/20/17.
  */
//trait UserTable {

class UserTable(tag: Tag) extends Table[User](tag, Some("public"), "users") {

    def id = column[Long]("user_sq_id", O.PrimaryKey, O.AutoInc)

    def email = column[String]("user_nm_email")

    def password = column[String]("user_cd_password")

    def * = (id, email, password) <> (User.tupled, User.unapply)
}
