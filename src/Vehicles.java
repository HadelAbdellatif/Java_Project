public abstract class Vehicles implements Comparable<Vehicles>, Cloneable { // abstract, comparable and clone class

	// Data Field
	protected String modelName; // Model name of a vehicle
	protected String ModelNo; // Model number of a vehicle
	protected String Brand; // : Company to produce the model
	protected String engineType; // : Type of the engine. Classified by fuel type to be used such as gasoline,
									// diesel, or hybrid
	protected double tunkSize; // Size of fuel tank. Unit is liter
	protected double Fuel_consumption; // : Fuel consumption. Unit is km/liter
	public Owner owner; // : Owner of the vehicle (as object)

	public Vehicles() { // no-element Constructor

	}

	public Vehicles(String modelName, String modelNo, String brand, String engineType, double tunkSize,
			double fuel_consumption, Owner owner) { // Constructor
		super();
		this.modelName = modelName;
		ModelNo = modelNo;
		Brand = brand;
		this.engineType = engineType;
		this.tunkSize = tunkSize;
		Fuel_consumption = fuel_consumption;
		this.owner = owner;
	}

	// getters and setters

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelNo() {
		return ModelNo;
	}

	public void setModelNo(String modelNo) {
		ModelNo = modelNo;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public double getTunkSize() {
		return tunkSize;
	}

	public void setTunkSize(double tunkSize) {
		this.tunkSize = tunkSize;
	}

	public double getFuel_consumption() {
		return Fuel_consumption;
	}

	public void setFuel_consumption(double fuel_consumption) {
		Fuel_consumption = fuel_consumption;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public abstract double costFor100Km(PetroleumType Type); // abstract method /Calculating cost for running 100Kms with the engine type
											// and the petroleum type passed
	// by as parameter. It will be different according to fuel and air-condition's
	// status.
	
	public double Movable_Distance() { // normal method /Getting information of movable distance of a vehicle when the
										// tank of the vehicle is filled fully.
		if (tunkSize < 0) { // Exception : tunk size should be positive
			throw new IllegalArgumentException("The tunk size cannot be negative");
		}
		if (Fuel_consumption < 0) { // Exception : Fuel_consumption should be positive
			throw new IllegalArgumentException("The Fuel_consumption cannot be negative");
		}
		return getFuel_consumption() * getTunkSize();
	}

	public abstract void setAirConditionON(); // abstract method

	public abstract void setAirConditionOff(); // abstract method

	public int compareTo(Vehicles o) { // comparable (cost For 100Km)
		PetroleumType petroleumType = new PetroleumType();
		if (this.costFor100Km(petroleumType) > o.costFor100Km(petroleumType)) {
			return 1;
		} else if (this.costFor100Km(petroleumType) < o.costFor100Km(petroleumType)) {
			return -1;
		} else
			return 0;
	}

	public Object clone() { // deep clone
		try {
			Vehicles vehicles = (Vehicles) super.clone();
			vehicles.owner = null;
			return vehicles;
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	protected Object clone1() throws CloneNotSupportedException{
		Vehicles v = (Vehicles)super.clone();
		v.setModelName(new String(v.modelName));
		v.setModelNo(new String(v.ModelNo));
		v.setBrand(new String(v.Brand));
		v.setEngineType(new String(v.engineType));
		v.setTunkSize(v.tunkSize);
		v.setFuel_consumption(v.Fuel_consumption);
		return v;
	}

	@Override
	public String toString() {
		return "[modelName=" + modelName + ", ModelNo=" + ModelNo + ", Brand=" + Brand + ", engineType="
				+ engineType + ", tunkSize=" + tunkSize + ", Fuel_consumption=" + Fuel_consumption + ", owner=" + owner
				+ ", Movable_Distance()=" + Movable_Distance() + "]";
	}
	
	
}
