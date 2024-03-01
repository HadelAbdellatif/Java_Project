public class Truck extends Vehicles  { // subclass
	// Data Field
	private boolean airConditionON = false; // Boolean status of air-condition's working: ON/OFF, and has a defult value
											// off
	private int power; // Horse Power of a vehicle's engine
	private int NumberOfSeats; // Integer number of seats in a vehicle.
	// no-argument construter

	public Truck() {
		super();
	}

	// constructer & super
	public Truck(String modelName, String modelNo, String brand, String engineType, double tunkSize,
			double fuelConsumption, Owner owner, boolean airConditionON, int power, int numberOfSeats) {
		super(modelName, modelNo, brand, engineType, tunkSize, fuelConsumption, owner);
		this.airConditionON = airConditionON;
		this.power = power;
		NumberOfSeats = numberOfSeats;
	}

	// getters and setters
	public boolean isairConditionON() {
		return airConditionON;
	}

	public void setairConditionON(boolean airConditionON) {
		this.airConditionON = airConditionON;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
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
			if (Type.getDieselPrice() < 0) { // Exception : price should be positive
				throw new IllegalArgumentException("The Price cannot be negative");
			} else {
				if (super.getEngineType().equals("Diesel")) {
					if (!isairConditionON()) { // if the condition off
						return (( 100 /super.getFuel_consumption())*Type.getDieselPrice());
					} else if (isairConditionON()) { // if the condition on
						return (( 100 /super.getFuel_consumption())* Type.getDieselPrice()*1.2);
					}
				}
			}
		} catch (IllegalArgumentException ex) { // Exeption : Truck uses only Diesel engine
			System.out.println("Truck uses only Diesel engine");
		}
		return 0;
	}
	


	@Override
	public String toString() {
		return "Truck" + super.toString() + "[airConditionON=" + airConditionON + ", power=" + power + ", NumberOfSeats="
				+ NumberOfSeats +", Cost for 100Km = "+ costFor100Km(null) + "]";
	}
	public int compareTo(Truck o) { // comparable 
		return this.owner.getName().compareTo(o.owner.getName());
	}


}
