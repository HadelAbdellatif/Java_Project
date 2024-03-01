
public class PetroleumType {
	// Data Filed
	public static final int DIESEL = 1;
	public static final int GASOLINE = 2;
	private static double gasolinePrice = 5.23; // get price from console NIS/liter , for instance 5.23 NIS/liter, defult value 5.23
	private static double dieselPrice = 4.02 ; // get price from console NIS/liter , for instance 4.02 NIS/liter,  defult value 4.02

	// constructor with defult value
	public PetroleumType() {
		
	}

	// constructor & super
	public PetroleumType(double gasolinePrice, double dieselPrice) {
		super();
		PetroleumType.gasolinePrice = gasolinePrice;
		PetroleumType.dieselPrice = dieselPrice;
	}

	// getters and setters
	public static double getGasolinePrice() {
		return gasolinePrice;
	}

	public static void setGasolinePrice(double gasolinePrice) {
		if (gasolinePrice < 0) {  //Exception : price should be positive
			throw new IllegalArgumentException("The Price cannot be negative");
		}
		PetroleumType.gasolinePrice = gasolinePrice;
	}

	public static double getDieselPrice() {
		return dieselPrice;
		
	}

	public static void setDieselPrice(double dieselPrice) {
		if (dieselPrice < 0) {  //Exception : price should be positive
			throw new IllegalArgumentException("The Price cannot be negative");
		}
		PetroleumType.dieselPrice = dieselPrice;
	}

	public static int getDiesel() {
		return DIESEL;
	}

	public static int getGasoline() {
		return GASOLINE;
	}

	@Override
	public String toString() { // toString method
		return "PetroleumType [gasolinePrice=" + gasolinePrice + ", dieselPrice=" + dieselPrice + "]";
	}
}