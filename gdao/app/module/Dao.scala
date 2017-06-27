package module

import dao.{UserDao, UserDaoImpl}
import scaldi.Module

/**
  * Created by inafalcao on 5/20/17.
  */
class Dao extends Module {

  bind[UserDao] to new UserDaoImpl

}
