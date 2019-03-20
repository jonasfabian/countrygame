/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db.tables.daos


import ch.countryname.countrygame.db.tables.Manpower
import ch.countryname.countrygame.db.tables.records.ManpowerRecord

import java.lang.Integer
import java.util.List

import org.jooq.Configuration
import org.jooq.impl.DAOImpl


class ManpowerDao(configuration : Configuration) extends DAOImpl[ManpowerRecord, ch.countryname.countrygame.db.tables.pojos.Manpower, Integer](Manpower.MANPOWER, classOf[ch.countryname.countrygame.db.tables.pojos.Manpower], configuration) {

  def this() = {
    this(null)
  }

  override protected def getId(o : ch.countryname.countrygame.db.tables.pojos.Manpower) : Integer = {
    o.getManpowerid
  }

  def fetchByManpowerid(values : Integer*) : List[ch.countryname.countrygame.db.tables.pojos.Manpower] = {
    fetch(Manpower.MANPOWER.MANPOWERID, values:_*)
  }

  def fetchOneByManpowerid(value : Integer) : ch.countryname.countrygame.db.tables.pojos.Manpower = {
    fetchOne(Manpower.MANPOWER.MANPOWERID, value)
  }

  def fetchByManpowernumber(values : Integer*) : List[ch.countryname.countrygame.db.tables.pojos.Manpower] = {
    fetch(Manpower.MANPOWER.MANPOWERNUMBER, values:_*)
  }
}
