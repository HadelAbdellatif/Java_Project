
public class Minivan extends Vehicles { // subclass
	// Data Field
	private int NumberOfSeats; // Integer number of seats in a vehicle.
	private boolean airConditionON = false;// Boolean status of air-condition's working: ON/OFF, and has a defult value
											// off
	private boolean hasAutoDoors; // Boolean status of a vehicle's having auto door.
	// no-argument construter

	public Minivan() {
		super();
	}

	// constructer & super
	public Minivan(String modelName, String modelNo, String brand, String engineType, double tunkSize,
			double fuelConsumption, Owner owner, int numberOfSeats, boolean airConditionON, boolean hasAutoDoors) {
		super(modelName, modelNo, brand, engineType, tunkSize, fuelConsumption, owner);
		NumberOfSeats = numberOfSeats;
		this.airConditionON = airConditionON;
		this.hasAutoDoors = hasAutoDoors;
	}

	// getters and setters

	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}

	public boolean isairConditionON() {
		return airConditionON;
	}


	public void setAirConditionON(boolean airConditionON) {
		this.airConditionON = airConditionON;
	}

	public boolean isHasAutoDoors() {
		return hasAutoDoors;
	}

	public void setHasAutoDoors(boolean hasAutoDoors) {
		this.hasAutoDoors = hasAutoDoors;
	}

	public void setAirConditionOff() { // concrete method - turn off the condition
		this.airConditionON = false;
	}

	public void setAirConditionON() { // concrete method - turn on the condition
		this.airConditionON = true;
	}

	public double costFor100Km(PetroleumType Type) { // abstract method /Calculating cost for running 100Kms with the engine type and
									// the petroleum type passed
		// by as parameter. It will be different according to fuel and air-condition's
		// status.
		try {
			if (Type.getGasolinePrice() < 0) { // Exception : price should be positive
				throw new IllegalArgumentException("The Price cannot be negative");
			} else if (Type.getDieselPrice() < 0) { // Exception : price should be positive
				throw new IllegalArgumentException("The Price cannot be negative");
			} else  {
				if (super.getEngineType().equals("Diesel")) { // if the minivan move by diesel
					if (!isairConditionON()) { // if the condition is off
						return (( 100 /super.getFuel_consumption()) * Type.getDieselPrice());
					} else if (isairConditionON()) { // if the condition is on
						return (( 100 /super.getFuel_consumption())* Type.getDieselPrice()*1.2);
					}
				} else if (super.getEngineType().equals("Gasoline")) { // if the minivan move by gesoline
					if (!isairConditionON()) { // if the condition is off
						return (( 100 /super.getFuel_consumption())* Type.getGasolinePrice());
					} else if (isairConditionON()) { // if the condition is on
						return (( 100 /super.getFuel_consumption())* Type.getGasolinePrice()*1.2);
					}
				}
				else if (super.getEngineType().equals("Hybrid")) {
					if (!isairConditionON()) { // if the condition is off
						return (( 100 /super.getFuel_consumption()) * Type.getDieselPrice());
					} else if (isairConditionON()) { // if the condition is on
						return (( 100 /super.getFuel_consumption())* Type.getDieselPrice()*1.2);
					}
				}
			}
		} catch (IllegalArgumentException ex) { // Exception : Minivan uses only Diesel or Gasoline or hybrid engine
			System.out.println("Minivan uses only Diesel or Gasoline or hybrid engine");
		}
		return 0;
	}
	
	
	@Override
	public String toString() { // toString method
		return "Minivan" +super.toString() + " [NumberOfSeats=" + NumberOfSeats + ", airConditionON=" + airConditionON
				+ ", hasAutoDoors=" + hasAutoDoors +", Cost for 100Km = "+ costFor100Km(null) + "]";
	}

}
