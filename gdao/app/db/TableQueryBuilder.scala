package db

/**
  * Created by inafalcao on 5/20/17.
  */
import slick.lifted.{AbstractTable, TableQuery}

import scala.reflect.macros.Context
import scala.language.experimental.macros
object TableQueryBuilderMacro {
  def createBuilderImpl[T<:AbstractTable[_]:c.WeakTypeTag](c: Context) = {
    import c.universe._
    val T = weakTypeOf[T]
    q"""new TableQueryBuilder[$T]{
      def apply(): TableQuery[$T] = {
        TableQuery[$T]
      }
    }"""
  }
}

trait TableQueryBuilder[T<:AbstractTable[_]] {
  def apply(): TableQuery[T]
}

object TableQueryBuilder {
  implicit def builderForTable[T<:AbstractTable[_]]: TableQueryBuilder[T] =
  macro TableQueryBuilderMacro.createBuilderImpl[T]

  def build[T<:AbstractTable[_]:TableQueryBuilder](): TableQuery[T] = implicitly[TableQueryBuilder[T]].apply()
}
