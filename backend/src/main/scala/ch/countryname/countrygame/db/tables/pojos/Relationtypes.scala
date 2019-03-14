/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db.tables.pojos


import java.io.Serializable
import java.lang.Integer
import java.lang.String
import java.lang.StringBuilder


case class Relationtypes(
    relationtypeid : Integer
  , relationtype : String
  , relationtypedescription : String
) extends Serializable {

  def this (value : Relationtypes) = {
    this(
        value.relationtypeid
      , value.relationtype
      , value.relationtypedescription
    )
  }

  def getRelationtypeid : Integer = {
    this.relationtypeid
  }

  def getRelationtype : String = {
    this.relationtype
  }

  def getRelationtypedescription : String = {
    this.relationtypedescription
  }

  override def toString : String = {
    val sb = new StringBuilder("Relationtypes (")

    sb.append(relationtypeid)
    sb.append(", ").append(relationtype)
    sb.append(", ").append(relationtypedescription)

    sb.append(")")
    return sb.toString
  }
}