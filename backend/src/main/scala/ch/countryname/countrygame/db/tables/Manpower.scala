/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db.tables


import ch.countryname.countrygame.db.CountryGame
import ch.countryname.countrygame.db.Indexes
import ch.countryname.countrygame.db.Keys
import ch.countryname.countrygame.db.tables.records.ManpowerRecord

import java.lang.Class
import java.lang.Double
import java.lang.Integer
import java.lang.String
import java.util.Arrays
import java.util.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Index
import org.jooq.Name
import org.jooq.Record
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.TableImpl

import scala.Array


object Manpower {

  val MANPOWER = new Manpower
}

class Manpower(
  alias : Name,
  child : Table[_ <: Record],
  path : ForeignKey[_ <: Record, ManpowerRecord],
  aliased : Table[ManpowerRecord],
  parameters : Array[ Field[_] ]
)
extends TableImpl[ManpowerRecord](
  alias,
  CountryGame.COUNTRY_GAME,
  child,
  path,
  aliased,
  parameters,
  DSL.comment("")
)
{

  override def getRecordType : Class[ManpowerRecord] = {
    classOf[ManpowerRecord]
  }

  val MANPOWERID : TableField[ManpowerRecord, Integer] = createField("manpowerId", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), "")

  val MANPOWERTYPE : TableField[ManpowerRecord, Double] = createField("manpowerType", org.jooq.impl.SQLDataType.DOUBLE, "")

  val MANPOWERNUMBER : TableField[ManpowerRecord, Double] = createField("manpowerNumber", org.jooq.impl.SQLDataType.DOUBLE, "")

  val COUNTRYID : TableField[ManpowerRecord, Integer] = createField("countryId", org.jooq.impl.SQLDataType.INTEGER.nullable(false), "")

  def this() = {
    this(DSL.name("manpower"), null, null, null, null)
  }

  def this(alias : String) = {
    this(DSL.name(alias), null, null, ch.countryname.countrygame.db.tables.Manpower.MANPOWER, null)
  }

  def this(alias : Name) = {
    this(alias, null, null, ch.countryname.countrygame.db.tables.Manpower.MANPOWER, null)
  }

  private def this(alias : Name, aliased : Table[ManpowerRecord]) = {
    this(alias, null, null, aliased, null)
  }

  def this(child : Table[_ <: Record], key : ForeignKey[_ <: Record, ManpowerRecord]) = {
    this(Internal.createPathAlias(child, key), child, key, ch.countryname.countrygame.db.tables.Manpower.MANPOWER, null)
  }

  override def getSchema : Schema = CountryGame.COUNTRY_GAME

  override def getIndexes : List[ Index ] = {
    return Arrays.asList[ Index ](Indexes.MANPOWER_COUNTRYID, Indexes.MANPOWER_PRIMARY)
  }

  override def getIdentity : Identity[ManpowerRecord, Integer] = {
    Keys.IDENTITY_MANPOWER
  }

  override def getPrimaryKey : UniqueKey[ManpowerRecord] = {
    Keys.KEY_MANPOWER_PRIMARY
  }

  override def getKeys : List[ UniqueKey[ManpowerRecord] ] = {
    return Arrays.asList[ UniqueKey[ManpowerRecord] ](Keys.KEY_MANPOWER_PRIMARY)
  }

  override def getReferences : List[ ForeignKey[ManpowerRecord, _] ] = {
    return Arrays.asList[ ForeignKey[ManpowerRecord, _] ](Keys.COUNTRYID)
  }

  def country : Country = {
    return new Country(this, Keys.COUNTRYID)
  }

  override def as(alias : String) : Manpower = {
    new Manpower(DSL.name(alias), this)
  }

  override def as(alias : Name) : Manpower = {
    new Manpower(alias, this)
  }

  override def rename(name : String) : Manpower = {
    new Manpower(DSL.name(name), null)
  }

  override def rename(name : Name) : Manpower = {
    new Manpower(name, null)
  }
}
