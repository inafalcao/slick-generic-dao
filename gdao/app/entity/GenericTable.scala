package entity

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._
import scala.reflect.ClassTag

/**
  * Created by inafalcao on 5/20/17.
  */
abstract class GenericTable[E](tag: Tag, schemaName: Option[String], tableName: String)
    extends Table[E](tag, schemaName, tableName) {

    val id: Rep[Long]

}
