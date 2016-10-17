package org.kurochan

import akka.actor._
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext.Implicits.global

object ScalaBadApi extends App {

  implicit val actorSystem = ActorSystem("my-system")
  implicit val flowMaterializer = ActorMaterializer()

  val route = get {
    pathEndOrSingleSlash {
      handleWith((request: HttpRequest) => "API is ready.")
    }
  } ~ path("echo-text") {
    get {
      parameter('text.?) { text =>
        complete(text.get)
      }
    }
  } ~ path("echo-number") {
      get {
        parameter('number) { numberString =>
          val number = numberString.toInt
          complete(number.toString)
      }
    }
  }

 val serverBinding = Http(actorSystem)
   .bindAndHandle(route, interface = "0.0.0.0", port = 8888)
}

