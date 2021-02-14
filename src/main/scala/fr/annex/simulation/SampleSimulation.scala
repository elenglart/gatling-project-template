package fr.annex.simulation

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SampleSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://www.google.fr")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("BasicSimulation")
    .exec(http("request_1")
      .get("/")
      .check(status.is(200)))

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpProtocol)
    .assertions(global.successfulRequests.count.gte(1))

}
