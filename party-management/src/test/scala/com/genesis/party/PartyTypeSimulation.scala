package com.genesis.party

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import java.util.concurrent.TimeUnit

/**
 * @author palmurugan
 */
class PartyTypeSimulation extends Simulation {

  val scn = scenario("PartyType-Scenarios").repeat(5, "n") {
        exec(
          http("GetPartyType-API")
            .get("http://192.168.0.28:8080/partytype/15")
            .check(status.is(200))
        )
  }
 
  setUp(scn.inject(atOnceUsers(1))).maxDuration(FiniteDuration.apply(10, "minutes"))
 
}