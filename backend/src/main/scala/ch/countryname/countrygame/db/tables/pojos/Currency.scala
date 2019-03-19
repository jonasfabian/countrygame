/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db.tables.pojos


import java.io.Serializable
import java.lang.Integer
import java.lang.String
import java.lang.StringBuilder


case class Currency(
    currencyid : Integer
  , currencyname : String
) extends Serializable {

  def this (value : Currency) = {
    this(
        value.currencyid
      , value.currencyname
    )
  }

  def getCurrencyid : Integer = {
    this.currencyid
  }

  def getCurrencyname : String = {
    this.currencyname
  }

  override def toString : String = {
    val sb = new StringBuilder("Currency (")

    sb.append(currencyid)
    sb.append(", ").append(currencyname)

    sb.append(")")
    return sb.toString
  }
}