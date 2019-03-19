/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db.tables.records


import ch.countryname.countrygame.db.tables.Currency

import java.lang.Integer
import java.lang.String

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record2
import org.jooq.Row2
import org.jooq.impl.UpdatableRecordImpl


class CurrencyRecord extends UpdatableRecordImpl[CurrencyRecord](Currency.CURRENCY) with Record2[Integer, String] {

  def setCurrencyid(value : Integer) : Unit = {
    set(0, value)
  }

  def getCurrencyid : Integer = {
    val r = get(0)
    if (r == null) null else r.asInstanceOf[Integer]
  }

  def setCurrencyname(value : String) : Unit = {
    set(1, value)
  }

  def getCurrencyname : String = {
    val r = get(1)
    if (r == null) null else r.asInstanceOf[String]
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------
  override def key : Record1[Integer] = {
    return super.key.asInstanceOf[ Record1[Integer] ]
  }

  // -------------------------------------------------------------------------
  // Record2 type implementation
  // -------------------------------------------------------------------------

  override def fieldsRow : Row2[Integer, String] = {
    super.fieldsRow.asInstanceOf[ Row2[Integer, String] ]
  }

  override def valuesRow : Row2[Integer, String] = {
    super.valuesRow.asInstanceOf[ Row2[Integer, String] ]
  }
  override def field1 : Field[Integer] = Currency.CURRENCY.CURRENCYID
  override def field2 : Field[String] = Currency.CURRENCY.CURRENCYNAME
  override def component1 : Integer = getCurrencyid
  override def component2 : String = getCurrencyname
  override def value1 : Integer = getCurrencyid
  override def value2 : String = getCurrencyname

  override def value1(value : Integer) : CurrencyRecord = {
    setCurrencyid(value)
    this
  }

  override def value2(value : String) : CurrencyRecord = {
    setCurrencyname(value)
    this
  }

  override def values(value1 : Integer, value2 : String) : CurrencyRecord = {
    this.value1(value1)
    this.value2(value2)
    this
  }

  def this(currencyid : Integer, currencyname : String) = {
    this()

    set(0, currencyid)
    set(1, currencyname)
  }
}
