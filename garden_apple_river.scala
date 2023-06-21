object TheSafeStreetsInitiative {

  //State of the Initiative
  var safeStreets: Boolean = false
  
  //1. Establish Initiative Parameters
  // Create an enum of cities that the Initiative applies to
  object Cities extends Enumeration {
	val Chicago, Houston, Miami, Baltimore, StLouis = Value
  }

  // Set Initiative goals
  val goalNumberOfCities: Int = 5
  val goalReducedCrime: Double = 0.25

  //2. Set up data structures
  // Create a map of cities to crime data
  var crimeData = Map[Cities.Value, Double]()

  // Create a list of cities successfully meeting Initiative goals
  var successfulCities: List[Cities.Value] = List()

  //3. Initialize cities with data
  def initialize(city: Cities.Value, data: Double): Unit = {
    crimeData += (city -> data)
  }

  //4. Update crime data
  def update(city: Cities.Value, data: Double): Unit = {
    crimeData += (city -> data)
  }

  //5. Check if city meets Initiative goals
  def checkIfMet(city: Cities.Value): Boolean = {
    crimeData(city) < goalReducedCrime
  }

  //6. Add city to successful list if Initiative goals met
  def addSuccessfulCity(city: Cities.Value): Unit = {
    if(checkIfMet(city))
	  successfulCities = successfulCities :+ city
  }

  //7. Check if Initiative goals have been met
  def checkIfInitiativeMet(): Boolean = {
    successfulCities.length == goalNumberOfCities
  }

  //8. Update state of the Initiative
  def updateStateOfInitiative(): Unit = {
    safeStreets = checkIfInitiativeMet()
  }

  //9. Main function
  def main(args:Array[String]): Unit = {
    initialize(Cities.Chicago, 0.20)
    initialize(Cities.Houston, 0.15)
    initialize(Cities.Miami, 0.22)
    initialize(Cities.Baltimore, 0.24)
    initialize(Cities.StLouis, 0.19)

    addSuccessfulCity(Cities.Chicago)
    addSuccessfulCity(Cities.Houston)
    addSuccessfulCity(Cities.Miami)
    addSuccessfulCity(Cities.Baltimore)
    addSuccessfulCity(Cities.StLouis)

    updateStateOfInitiative()

    println(s"The Initiative is ${if(safeStreets) "succeeding" else "failing"}")
  }

}