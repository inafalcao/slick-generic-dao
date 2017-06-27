package dao

import entity.user.UserTable
import scaldi.Injector
import slick.lifted.TableQuery

/**
  * Created by inafalcao on 5/20/17.
  */
class UserDaoImpl(implicit inj: Injector) extends UserDao {

  val slickTable = TableQuery[UserTable]
  def getId(table: UserTable) = table.id

}
