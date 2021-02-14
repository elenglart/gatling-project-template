package fr.annex

import org.scalatest.funsuite.AnyFunSuite
import fr.annex.test.util.TestSimulation
import fr.annex.simulation.{SampleSimulation,SampleErrorSimulation}

class AppTestSuite extends AnyFunSuite {

  test("Sample simulation status is success") {
    assert(TestSimulation.launch(classOf[SampleSimulation].getCanonicalName) == 0)
  }

  test("Sample error simulation status is not in success") {
    assert(TestSimulation.launch(classOf[SampleErrorSimulation].getCanonicalName) != 0)
  }

}
