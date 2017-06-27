package db

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import scaldi.{Injectable, Injector}
import slick.ast.BaseTypedType
import slick.jdbc.JdbcProfile
import slick.lifted.{AbstractTable, TableQuery}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

/**
  * Created by inafalcao on 5/19/17.
  */
abstract class GenericDao[T <: AbstractTable[_], I: BaseTypedType](implicit inj: Injector)
   extends HasDatabaseConfig[JdbcProfile] with Injectable {

  val dbConfig = inject[DatabaseConfigProvider].get[JdbcProfile]

  type Id = I
  val slickTable: TableQuery[T]
  def getId(row: T): Rep[Id]

  def insert(model: T#TableElementType) = db run (slickTable += model)

  def getInsertAction(model: T#TableElementType) = slickTable += model

  def insertAction(action: DBIO[Id]) = db run action

  def findById(id: Id) = slickTable filter (getId(_) === id)

}
