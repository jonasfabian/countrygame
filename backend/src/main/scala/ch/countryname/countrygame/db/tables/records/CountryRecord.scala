/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db.tables.records


import ch.countryname.countrygame.db.tables.Country

import java.lang.Integer
import java.lang.String

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record4
import org.jooq.Row4
import org.jooq.impl.UpdatableRecordImpl


class CountryRecord extends UpdatableRecordImpl[CountryRecord](Country.COUNTRY) with Record4[Integer, String, String, String] {

  def setCountryid(value : Integer) : Unit = {
    set(0, value)
  }

  def getCountryid : Integer = {
    val r = get(0)
    if (r == null) null else r.asInstanceOf[Integer]
  }

  def setCountryname(value : String) : Unit = {
    set(1, value)
  }

  def getCountryname : String = {
    val r = get(1)
    if (r == null) null else r.asInstanceOf[String]
  }

  def setCountrydetails(value : String) : Unit = {
    set(2, value)
  }

  def getCountrydetails : String = {
    val r = get(2)
    if (r == null) null else r.asInstanceOf[String]
  }

  def setCountrycode(value : String) : Unit = {
    set(3, value)
  }

  def getCountrycode : String = {
    val r = get(3)
    if (r == null) null else r.asInstanceOf[String]
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------
  override def key : Record1[Integer] = {
    return super.key.asInstanceOf[ Record1[Integer] ]
  }

  // -------------------------------------------------------------------------
  // Record4 type implementation
  // -------------------------------------------------------------------------

  override def fieldsRow : Row4[Integer, String, String, String] = {
    super.fieldsRow.asInstanceOf[ Row4[Integer, String, String, String] ]
  }

  override def valuesRow : Row4[Integer, String, String, String] = {
    super.valuesRow.asInstanceOf[ Row4[Integer, String, String, String] ]
  }
  override def field1 : Field[Integer] = Country.COUNTRY.COUNTRYID
  override def field2 : Field[String] = Country.COUNTRY.COUNTRYNAME
  override def field3 : Field[String] = Country.COUNTRY.COUNTRYDETAILS
  override def field4 : Field[String] = Country.COUNTRY.COUNTRYCODE
  override def component1 : Integer = getCountryid
  override def component2 : String = getCountryname
  override def component3 : String = getCountrydetails
  override def component4 : String = getCountrycode
  override def value1 : Integer = getCountryid
  override def value2 : String = getCountryname
  override def value3 : String = getCountrydetails
  override def value4 : String = getCountrycode

  override def value1(value : Integer) : CountryRecord = {
    setCountryid(value)
    this
  }

  override def value2(value : String) : CountryRecord = {
    setCountryname(value)
    this
  }

  override def value3(value : String) : CountryRecord = {
    setCountrydetails(value)
    this
  }

  override def value4(value : String) : CountryRecord = {
    setCountrycode(value)
    this
  }

  override def values(value1 : Integer, value2 : String, value3 : String, value4 : String) : CountryRecord = {
    this.value1(value1)
    this.value2(value2)
    this.value3(value3)
    this.value4(value4)
    this
  }

  def this(countryid : Integer, countryname : String, countrydetails : String, countrycode : String) = {
    this()

    set(0, countryid)
    set(1, countryname)
    set(2, countrydetails)
    set(3, countrycode)
  }
}