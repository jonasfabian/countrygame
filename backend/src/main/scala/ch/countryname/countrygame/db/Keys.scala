/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db


import ch.countryname.countrygame.db.tables.Country
import ch.countryname.countrygame.db.tables.FlywaySchemaHistory
import ch.countryname.countrygame.db.tables.Relations
import ch.countryname.countrygame.db.tables.Relationtypes
import ch.countryname.countrygame.db.tables.records.CountryRecord
import ch.countryname.countrygame.db.tables.records.FlywaySchemaHistoryRecord
import ch.countryname.countrygame.db.tables.records.RelationsRecord
import ch.countryname.countrygame.db.tables.records.RelationtypesRecord

import java.lang.Integer

import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.UniqueKey
import org.jooq.impl.Internal


object Keys {

  // -------------------------------------------------------------------------
  // IDENTITY definitions
  // -------------------------------------------------------------------------

  val IDENTITY_COUNTRY = Identities0.IDENTITY_COUNTRY
  val IDENTITY_RELATIONS = Identities0.IDENTITY_RELATIONS

  // -------------------------------------------------------------------------
  // UNIQUE and PRIMARY KEY definitions
  // -------------------------------------------------------------------------

  val KEY_COUNTRY_PRIMARY = UniqueKeys0.KEY_COUNTRY_PRIMARY
  val KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY = UniqueKeys0.KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY
  val KEY_RELATIONS_PRIMARY = UniqueKeys0.KEY_RELATIONS_PRIMARY
  val KEY_RELATIONTYPES_PRIMARY = UniqueKeys0.KEY_RELATIONTYPES_PRIMARY

  // -------------------------------------------------------------------------
  // FOREIGN KEY definitions
  // -------------------------------------------------------------------------

  val COUNTRYID1 = ForeignKeys0.COUNTRYID1
  val COUNTRYID2 = ForeignKeys0.COUNTRYID2

  // -------------------------------------------------------------------------
  // [#1459] distribute members to avoid static initialisers > 64kb
  // -------------------------------------------------------------------------

  private object Identities0 {
    val IDENTITY_COUNTRY : Identity[CountryRecord, Integer] = Internal.createIdentity(Country.COUNTRY, Country.COUNTRY.COUNTRYID)
    val IDENTITY_RELATIONS : Identity[RelationsRecord, Integer] = Internal.createIdentity(Relations.RELATIONS, Relations.RELATIONS.RELATIONID)
  }

  private object UniqueKeys0 {
    val KEY_COUNTRY_PRIMARY : UniqueKey[CountryRecord] = Internal.createUniqueKey(Country.COUNTRY, "KEY_country_PRIMARY", Country.COUNTRY.COUNTRYID)
    val KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY : UniqueKey[FlywaySchemaHistoryRecord] = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "KEY_flyway_schema_history_PRIMARY", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK)
    val KEY_RELATIONS_PRIMARY : UniqueKey[RelationsRecord] = Internal.createUniqueKey(Relations.RELATIONS, "KEY_relations_PRIMARY", Relations.RELATIONS.RELATIONID)
    val KEY_RELATIONTYPES_PRIMARY : UniqueKey[RelationtypesRecord] = Internal.createUniqueKey(Relationtypes.RELATIONTYPES, "KEY_relationtypes_PRIMARY", Relationtypes.RELATIONTYPES.RELATIONTYPEID)
  }

  private object ForeignKeys0 {
    val COUNTRYID1 : ForeignKey[RelationsRecord, CountryRecord] = Internal.createForeignKey(ch.countryname.countrygame.db.Keys.KEY_COUNTRY_PRIMARY, Relations.RELATIONS, "countryId1", Relations.RELATIONS.COUNTRYID1)
    val COUNTRYID2 : ForeignKey[RelationsRecord, CountryRecord] = Internal.createForeignKey(ch.countryname.countrygame.db.Keys.KEY_COUNTRY_PRIMARY, Relations.RELATIONS, "countryId2", Relations.RELATIONS.COUNTRYID2)
  }
}
