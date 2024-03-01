import java.util.*;

public class Car extends Vehicles  { // subclass
	// Data Field
	private int NumberOfSeats; // Integer number of seats in a vehicle.
	private boolean airConditionON = false; // Boolean status of air-condition's working: ON/OFF, and has a defult value
											// off

	public Car() { // no-argument construter
		super();
	}

	// constructer & super
	public Car(String modelName, String modelNo, String brand, String engineType, double tunkSize,
			double fuelConsumption, Owner owner, int numberOfSeats, boolean airConditionON) {
		super(modelName, modelNo, brand, engineType, tunkSize, fuelConsumption, owner);
		NumberOfSeats = numberOfSeats;
		this.airConditionON = airConditionON;
	}

	// setters and getters
	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}

	public boolean isairConditionON() {
		return airConditionON;
	}

	public void setairConditionON(boolean airConditionON) {
		this.airConditionON = airConditionON;
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
			} else {
				if (super.getEngineType().equals("Gasoline")) {
					if (!isairConditionON()) { // if the condition off
						return (( 100 /super.getFuel_consumption())*Type.getGasolinePrice());
					} else if (isairConditionON()) { // if the condition on
						return (( 100 /super.getFuel_consumption())*Type.getGasolinePrice()*1.1);
					}
					}
					else if (super.getEngineType().equals("Hybrid")) {
						if (!isairConditionON()) { // if the condition off
							return (( 100 /super.getFuel_consumption())*Type.getGasolinePrice());
						} else if (isairConditionON()) { // if the condition on
							return (( 100 /super.getFuel_consumption())*Type.getGasolinePrice()*1.1);
						}
					}
			}
		} catch (IllegalArgumentException ex) { // Exception : Cars uses only gasoline or hybrid engine
			System.out.println("Cars uses only gasoline or hybrid engine ");
		}
		return 0;
	}
public int compareTo(Car o) { // comparable 
		return this.owner.getName().compareTo(o.owner.getName());
		}
	@Override
	public String toString() { // toString method
		return "Car" +super.toString() + " [NumberOfSeats=" + NumberOfSeats + ", airConditionON=" + airConditionON +", Cost for 100Km = "+ costFor100Km(null) +"]";
	}
	
}
