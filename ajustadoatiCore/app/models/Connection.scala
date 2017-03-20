package models.connection


import org.anormcypher._

trait Connection{
	implicit val connection = Neo4jREST("localhost", 7474, "/db/data/", "neo4j", "Dexter876.")
}