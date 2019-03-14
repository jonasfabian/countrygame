/*
 * This file is generated by jOOQ.
 */
package ch.countryname.countrygame.db


import ch.countryname.countrygame.db.tables.Country
import ch.countryname.countrygame.db.tables.FlywaySchemaHistory
import ch.countryname.countrygame.db.tables.Relations
import ch.countryname.countrygame.db.tables.Relationtypes

import org.jooq.Index
import org.jooq.OrderField
import org.jooq.impl.Internal


object Indexes {

  // -------------------------------------------------------------------------
  // INDEX definitions
  // -------------------------------------------------------------------------

  val COUNTRY_PRIMARY = Indexes0.COUNTRY_PRIMARY
  val FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX = Indexes0.FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX
  val FLYWAY_SCHEMA_HISTORY_PRIMARY = Indexes0.FLYWAY_SCHEMA_HISTORY_PRIMARY
  val RELATIONS_COUNTRY1_UNIQUE = Indexes0.RELATIONS_COUNTRY1_UNIQUE
  val RELATIONS_COUNTRYID2 = Indexes0.RELATIONS_COUNTRYID2
  val RELATIONS_PRIMARY = Indexes0.RELATIONS_PRIMARY
  val RELATIONS_RELATIONTYPEID_IDX = Indexes0.RELATIONS_RELATIONTYPEID_IDX
  val RELATIONTYPES_PRIMARY = Indexes0.RELATIONTYPES_PRIMARY

  // -------------------------------------------------------------------------
  // [#1459] distribute members to avoid static initialisers > 64kb
  // -------------------------------------------------------------------------

  private object Indexes0 {
    val COUNTRY_PRIMARY : Index = Internal.createIndex("PRIMARY", Country.COUNTRY, Array[OrderField [_] ](Country.COUNTRY.COUNTRYID), true)
    val FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX : Index = Internal.createIndex("flyway_schema_history_s_idx", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, Array[OrderField [_] ](FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS), false)
    val FLYWAY_SCHEMA_HISTORY_PRIMARY : Index = Internal.createIndex("PRIMARY", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, Array[OrderField [_] ](FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK), true)
    val RELATIONS_COUNTRY1_UNIQUE : Index = Internal.createIndex("country1_UNIQUE", Relations.RELATIONS, Array[OrderField [_] ](Relations.RELATIONS.COUNTRYID1), false)
    val RELATIONS_COUNTRYID2 : Index = Internal.createIndex("countryId2", Relations.RELATIONS, Array[OrderField [_] ](Relations.RELATIONS.COUNTRYID2), false)
    val RELATIONS_PRIMARY : Index = Internal.createIndex("PRIMARY", Relations.RELATIONS, Array[OrderField [_] ](Relations.RELATIONS.RELATIONID), true)
    val RELATIONS_RELATIONTYPEID_IDX : Index = Internal.createIndex("relationTypeId_idx", Relations.RELATIONS, Array[OrderField [_] ](Relations.RELATIONS.RELATIONTYPE), false)
    val RELATIONTYPES_PRIMARY : Index = Internal.createIndex("PRIMARY", Relationtypes.RELATIONTYPES, Array[OrderField [_] ](Relationtypes.RELATIONTYPES.RELATIONTYPEID), true)
  }
}
