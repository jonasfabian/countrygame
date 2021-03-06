/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db.tables.daos


import ch.countryname.countrygame.db.tables.Modifier
import ch.countryname.countrygame.db.tables.records.ModifierRecord

import java.lang.Double
import java.lang.Integer
import java.lang.String
import java.util.List

import org.jooq.Configuration
import org.jooq.impl.DAOImpl


class ModifierDao(configuration : Configuration) extends DAOImpl[ModifierRecord, ch.countryname.countrygame.db.tables.pojos.Modifier, Integer](Modifier.MODIFIER, classOf[ch.countryname.countrygame.db.tables.pojos.Modifier], configuration) {

  def this() = {
    this(null)
  }

  override protected def getId(o : ch.countryname.countrygame.db.tables.pojos.Modifier) : Integer = {
    o.getModifierid
  }

  def fetchByModifierid(values : Integer*) : List[ch.countryname.countrygame.db.tables.pojos.Modifier] = {
    fetch(Modifier.MODIFIER.MODIFIERID, values:_*)
  }

  def fetchOneByModifierid(value : Integer) : ch.countryname.countrygame.db.tables.pojos.Modifier = {
    fetchOne(Modifier.MODIFIER.MODIFIERID, value)
  }

  def fetchByModifiername(values : String*) : List[ch.countryname.countrygame.db.tables.pojos.Modifier] = {
    fetch(Modifier.MODIFIER.MODIFIERNAME, values:_*)
  }

  def fetchByModifiervalue(values : Double*) : List[ch.countryname.countrygame.db.tables.pojos.Modifier] = {
    fetch(Modifier.MODIFIER.MODIFIERVALUE, values:_*)
  }
}
