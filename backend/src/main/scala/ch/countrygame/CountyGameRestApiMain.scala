package ch.countrygame

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.{Directives, Route}
import akka.stream.ActorMaterializer
import ch.countrygame.Classes._
import com.typesafe.config.{ConfigFactory, ConfigValueFactory}
import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport
import io.swagger.annotations._
import javax.ws.rs.Path
import scala.concurrent.duration._

import scala.io.StdIn

object WebServer extends App with CorsSupport with SwaggerSite with ErrorAccumulatingCirceSupport {

  override def main(args: Array[String]) {

    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    val swaggerDoc = new SwaggerDoc()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val config = ConfigFactory.load()
      .withValue("akka.remote.netty.tcp.port", ConfigValueFactory.fromAnyRef(2556))
    val countryService = new CountryService(config)
    val countryGameRestApi = new CountryGameRestApi(countryService)
    val routes = corsHandler(countryGameRestApi.route) ~ swaggerDoc.routes ~ swaggerSiteRoute

    system.scheduler.schedule(0.seconds, 10.seconds) {
      countryService.countries.foreach(l => {
        countryService.increaseManpower(l)
      })
    }

    val bindingFuture = Http().bindAndHandle(routes ~ swaggerDoc.routes ~ swaggerSiteRoute, "localhost", 8080)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}

class CountryGameRestApi(service: CountryService) extends Directives with ErrorAccumulatingCirceSupport {

  val route = pathPrefix("api") {
    pathPrefix("country") {
      getCountry ~ createCountry ~ updateCountry ~ createRelation ~ getRelation ~ getRelationByName ~ getCurrency ~ getCurrencies ~ getStats ~ deleteCountry ~ getManpower ~ getModifiersForCountry ~ getModifier ~ updateManpower
    }
  }

  @ApiOperation(value = "getCountry", httpMethod = "GET", notes = "returns a country")
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Country], message = "OK")))
  @Path("country")
  def getCountry = path("getCountry") {
    get {
      complete(service.countries)
    }
  }

  @ApiOperation(value = "getStats", httpMethod = "GET", notes = "returns stats")
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Array[Array[Double]]], message = "OK")))
  @Path("country")
  def getStats = path("getStats") {
    get {
      complete(service.stats)
    }
  }

  @ApiOperation(value = "getModifier", httpMethod = "GET", notes = "returns a modifier")
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Modifier], message = "OK")))
  @Path("country")
  def getModifier = path("getModifier") {
    get {
      complete(service.modifier)
    }
  }

  @ApiOperation(value = "getRelation", httpMethod = "GET", notes = "returns a relation")
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Relation], message = "OK")))
  @Path("country")
  def getRelation = path("getRelation") {
    get {
      complete(service.relations)
    }
  }

  @ApiOperation(value = "", httpMethod = "GET", notes = "returns getRelationByName")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "id", required = true, example = "100", value = "id", paramType = "query")))
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Array[RelationNamed]], message = "OK")))
  @Path("country")
  def getRelationByName = path("getRelationByName") {
    get {
      parameters("id".as[Int] ? 0) { id =>
        complete(service.relationsForCountry(id))
      }
    }
  }

  @ApiOperation(value = "", httpMethod = "GET", notes = "returns getModifiersForCountry")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "id", required = true, example = "100", value = "id", paramType = "query")))
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Array[ModifierForCountry]], message = "OK")))
  @Path("country")
  def getModifiersForCountry = path("getModifiersForCountry") {
    get {
      parameters("id".as[Int] ? 0) { id =>
        complete(service.modifiersForCountry(id))
      }
    }
  }

  @ApiOperation(value = "", httpMethod = "GET", notes = "returns currency")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "id", required = true, example = "100", value = "id", paramType = "query")))
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Array[Currency]], message = "OK")))
  @Path("country")
  def getCurrency = path("getCurrency") {
    get {
      parameters("id".as[Int] ? 0) { id =>
        complete(service.currencyForCountry(id))
      }
    }
  }

  @ApiOperation(value = "getManpower", httpMethod = "GET", notes = "returns manpower")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "id", required = true, example = "100", value = "id", paramType = "query")))
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Array[Manpower]], message = "OK")))
  @Path("country")
  def getManpower = path("getManpower") {
    get {
      parameters("id".as[Int] ? 0) { id =>
        complete(service.manpowerOfCountry(id))
      }
    }
  }

  @ApiOperation(value = "deleteCountry", httpMethod = "DELETE", notes = "deletes country")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "id", required = true, example = "100", value = "id", paramType = "query")))
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Array[Country]], message = "OK")))
  @Path("country")
  def deleteCountry = path("deleteCountry") {
    delete {
      parameters("id".as[Int] ? 0) { id =>
        complete(service.deleteCountry(id))
      }
    }
  }

  @ApiOperation(value = "", httpMethod = "GET", notes = "returns currencies")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "id", required = true, example = "100", value = "id", paramType = "query")))
  @ApiResponses(Array(new ApiResponse(code = 200, response = classOf[Array[Currency]], message = "OK")))
  @Path("country")
  def getCurrencies = path("getCurrencies") {
    get {
      complete(service.currencies)
    }
  }

  @ApiOperation(value = "createCountry", httpMethod = "POST")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "body", required = true, dataTypeClass = classOf[Country], value = "the created country", paramType = "body")))
  @ApiResponses(Array(new ApiResponse(code = 200, message = "OK")))
  @Path("country")
  def createCountry: Route = path("createCountry") {
    post {
      entity(as[Country]) { country =>
        service.newCountry(country)
        complete("OK")
      }
    }
  }

  @ApiOperation(value = "createRelation", httpMethod = "POST")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "body", required = true, dataTypeClass = classOf[Relation], value = "the created relation", paramType = "body")))
  @ApiResponses(Array(new ApiResponse(code = 200, message = "OK")))
  @Path("country")
  def createRelation: Route = path("createRelation") {
    post {
      entity(as[Relation]) { relations =>
        service.newRelation(relations)
        complete("OK")
      }
    }
  }

  @ApiOperation(value = "updateCountry", httpMethod = "POST")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "body", required = true, dataTypeClass = classOf[Country], value = "the updated country", paramType = "body")))
  @ApiResponses(Array(new ApiResponse(code = 200, message = "OK")))
  @Path("country")
  def updateCountry: Route = path("updateCountry") {
    post {
      entity(as[Country]) { country =>
        service.updateCountry(country)
        complete("OK")
      }
    }
  }

  @ApiOperation(value = "updateManpower", httpMethod = "POST")
  @ApiImplicitParams(Array(new ApiImplicitParam(name = "body", required = true, dataTypeClass = classOf[Country], value = "the updated manpower", paramType = "body")))
  @ApiResponses(Array(new ApiResponse(code = 200, message = "OK")))
  @Path("country")
  def updateManpower: Route = path("updateManpower") {
    post {
      entity(as[Country]) { country =>
        service.updateManpower(country)
        complete("OK")
      }
    }
  }
}
