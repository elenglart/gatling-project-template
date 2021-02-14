package fr.annex.test.util

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object TestSimulation {

  def launch(simulation: String): Int = {
    try {
      val props = new GatlingPropertiesBuilder
      props.simulationClass(simulation)
      props.resultsDirectory("target/gatling-results")
      Gatling.fromMap(props.build)
    }
    catch {
      case e: Exception => {
        e.printStackTrace()
        throw (e)
      }
    }
  }

}
