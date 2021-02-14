# gatling-project-template
The purpose of this project is to provide a development layout that allows developers to write reliable gatling simulation.
To achieve these goals, the project has the following characteristics : 
- Simulation can be run directly from IDE using the App main class
- Simulation can be unitary tested through the use of ScalaTest

It also provided differents ways of packaging simulation to be delivered later on runtime environment.

This project relies on :
- gatling 3.5.1
- scala 2.13.4
- scalatest 3.2.2
- maven-shade-plugin 3.2.4
  
## Test
> mvn clean test

## Build
Different ways of packaging are provided :
- Simulation can be packaged as a traditional jar (containing simulation file only) that may be later imported into a bundled gatling structure
- Simulation can be packaged as an uber jar by shading : only a java 8+ jre will be then needed to run the simulation.
> mvn clean install

## Additional notes
In order to restrain gatling framework from loading all classes located at current user location, the class io.gatling.app.App is defined.
The only purpose of this class is to start gatling simulation by providing explicitly the simulation class that needs to be used. It has to be done from inside io.gatling.app package since the Gatling.start method is package private (and is the only one allowing us to directly specify the simulation class)

## TODO
- Add a gatling bundle packaging (as light as it could be, without recorder) embedding simulation jar
- Add a gatling bundle packaging embedding simulation sources and compiling them at runtime (with zync thus)
- Add a docker image bundle packaging
- Providing this project template as a maven archetype