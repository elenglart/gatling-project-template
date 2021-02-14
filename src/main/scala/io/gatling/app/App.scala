package io.gatling.app

import io.gatling.core.config.GatlingPropertiesBuilder
import io.gatling.core.scenario.Simulation

import fr.annex.simulation.SampleSimulation

/*
This purpose is to launch gatling simulation avoiding the scan of classpath (since we do not want our test classes to
be instanciated => gatling will try to load every classes in classloader).
We need to be in io.gatling.app package to be able to used the Gatling.start method which allows us to directly pass
our simulation clazz as argument.
 */
object App {
  def main(args: Array[String]): Unit = {
    val props = new GatlingPropertiesBuilder
    val simClass = classOf[SampleSimulation].asInstanceOf[Class[Simulation]]
    Gatling.start(props.build, Some(simClass))
  }
}
