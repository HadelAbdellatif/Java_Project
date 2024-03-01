import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Menu {

	public static void main(String[] args) throws IOException {
         //initalize ArayList and the input and output files
		File infile = new File("inputdata.txt");
		File outfile = new File("outputdata.txt");
		PrintWriter out = new PrintWriter(outfile); // write on the file
		ArrayList<Vehicles> vehiceles = new ArrayList<>();

		try {

			Scanner input = new Scanner(infile);
			System.out.println("Choose the operation you want by entering the operation number : ");
			System.out.println(" 1. Read the data about objects from the the file and store them in Arraylist.\n "
					+ "2. prices of petroleum. \n"
					+ " 3. sort order Vehicles in an ascending order based on cost for 100Km. \n"
					+ " 4. sort order Vehicles in an ascending order based on owner name. \n "
					+ "5. sort order Vehicles in an descending order based on vehicle brand. \n"
					+ " 6. Clone Vehicle without owner, (choice one object for cloning from Arraylist). \r\n"
					+ " 7. Turn air-condition on. \r\n"
					+ " 8. Write Output on the “output.txt” file after sort them. \n" + " 9. Exit from System");
			Scanner in = new Scanner(System.in);
			int H = in.nextInt();
			while (H != 9) {

				if (H == 1) {

					while (input.hasNextLine()) { // read all the lines in the file
						String S = input.nextLine();
						StringBuilder string = new StringBuilder(S); // string builder
						String[] check = string.toString().split(",");

						// fill the file data in array list
						
						if (check[0].compareToIgnoreCase("Car") == 0) { // check the first word and put it in array from type car if it car
							Car car = new Car();
							car.setModelName(check[1]);
							car.setModelNo(check[2]);
							car.setBrand(check[3]);
							car.setEngineType(check[5]);
							car.setTunkSize(Double.parseDouble(check[6]));
							car.setFuel_consumption(Double.parseDouble(check[7]));
							Owner owner = new Owner();
							owner.setName(check[4]);
							car.setOwner(owner);
							car.setNumberOfSeats(Integer.parseInt(check[8].trim()));
							car.isairConditionON();
							vehiceles.add(car); // fill the array list

						} else if (check[0].compareToIgnoreCase("Minivan") == 0) {// check the first word and put it in array from type Minivan if it Minivan
							Minivan minivan = new Minivan();
							minivan.setModelName(check[1]);
							minivan.setModelNo(check[2]);
							minivan.setBrand(check[3]);
							minivan.setEngineType(check[5]);
							minivan.setTunkSize(Double.parseDouble(check[6]));
							minivan.setFuel_consumption(Double.parseDouble(check[7]));
							Owner owner = new Owner();
							owner.setName(check[4]);
							minivan.setOwner(owner);
							minivan.setNumberOfSeats(Integer.parseInt(check[8].trim()));
							minivan.setHasAutoDoors(Boolean.parseBoolean(check[9]));
							minivan.isairConditionON();
							vehiceles.add(minivan); // fill the aray list

						} else if (check[0].compareToIgnoreCase("Truck") == 0) {// check the first word and put it in array from type Truck if it Truck
							Truck truck = new Truck();
							truck.setModelName(check[1]);
							truck.setModelNo(check[2]);
							truck.setBrand(check[3]);
							truck.setEngineType(check[5]);
							truck.setTunkSize(Double.parseDouble(check[6]));
							truck.setFuel_consumption(Double.parseDouble(check[7]));
							Owner owner = new Owner();
							owner.setName(check[4]);
							truck.setOwner(owner);
							truck.setNumberOfSeats(Integer.parseInt(check[8].trim()));
							truck.setPower(Integer.parseInt(check[9].trim()));
							truck.isairConditionON();
							vehiceles.add(truck); //fill the array

						}
					}
                System.out.println("Data read successfuly"); // fill data in array list done 
                
				} else if (H == 2) { // set prices of petroleum
					System.out.println("Plese inter the prices of Gasoline");
					Scanner n = new Scanner(System.in);
					PetroleumType.setGasolinePrice(n.nextDouble());
					System.out.println("Plese inter the prices of Diesel");
					Scanner m = new Scanner(System.in);
					PetroleumType.setDieselPrice(m.nextDouble());
					System.out.println("the price have set successfully");

				} else if (H == 3) { // sort order Vehicles in an ascending order based on cost for 100Km
					Collections.sort(vehiceles);
					for (int z = 0; z < vehiceles.size(); z++) {
						System.out.println(vehiceles.get(z));
					}
					System.out.println("vehiceles have been sorted ");
				} else if (H == 4) { // sort order Vehicles in an ascending order based on owner name

					for (int j = 0; j < vehiceles.size() - 1; j++)
						for (int i = 0; i < vehiceles.size() - 1; i++) {
                           //check the first litter
							char m = vehiceles.get(i).getOwner().getName().charAt(0);
							char n = vehiceles.get(i + 1).getOwner().getName().charAt(0);
							if (vehiceles.get(i).getOwner().getName().compareTo(vehiceles.get(i + 1).getOwner().getName()) > 0) {
								if (vehiceles.get(i) instanceof Car) {
									Vehicles owner_max = new Car();
									owner_max = vehiceles.get(i);
									vehiceles.set(i, vehiceles.get(i + 1));
									vehiceles.set((i + 1), owner_max);

								} else if (vehiceles.get(i) instanceof Minivan) {
									Vehicles owner_max = new Minivan();
									owner_max = vehiceles.get(i);
									vehiceles.set(i, vehiceles.get(i + 1));
									vehiceles.set((i + 1), owner_max);

								} else {
									Vehicles owner_max = new Minivan();
									owner_max = vehiceles.get(i);
									vehiceles.set(i, vehiceles.get(i + 1));
									vehiceles.set((i + 1), owner_max);

								}
							} else if (m == n) { //if the first litter from each word equals then check the secound litter
								m = vehiceles.get(i).getOwner().getName().charAt(1);
								n = vehiceles.get(i + 1).getOwner().getName().charAt(1);
								if (m > n) {
									if (vehiceles.get(i) instanceof Car) {
										Vehicles owner_max = new Car();
										owner_max = vehiceles.get(i);
										vehiceles.set(i, vehiceles.get(i + 1));
										vehiceles.set((i + 1), owner_max);

									} else if (vehiceles.get(i) instanceof Minivan) {
										Vehicles owner_max = new Minivan();
										owner_max = vehiceles.get(i);
										vehiceles.set(i, vehiceles.get(i + 1));
										vehiceles.set((i + 1), owner_max);

									} else {
										Vehicles owner_max = new Minivan();
										owner_max = vehiceles.get(i);
										vehiceles.set(i, vehiceles.get(i + 1));
										vehiceles.set((i + 1), owner_max);

									}
								}

							}
						}
					for (int z = 0; z < vehiceles.size(); z++) {
						System.out.println(vehiceles.get(z));
					}
					 System.out.println("Data sort successfuly"); // sort done
				} else if (H == 5) { // sort order Vehicles in an descending order based on vehicle brand
					for (int j = 0; j < vehiceles.size() - 1; j++)
						for (int i = 0; i < vehiceles.size() - 1; i++) {
							//check the first litter
							char m = vehiceles.get(i).getBrand().charAt(0);
							char n = vehiceles.get(i + 1).getBrand().charAt(0);
							if (m > n) {
								if (vehiceles.get(i) instanceof Car) {
									Vehicles max = new Car();
									max = vehiceles.get(i);
									vehiceles.set(i, vehiceles.get(i + 1));
									vehiceles.set((i + 1), max);

								} else if (vehiceles.get(i) instanceof Minivan) {
									Vehicles max = new Minivan();
									max = vehiceles.get(i);
									vehiceles.set(i, vehiceles.get(i + 1));
									vehiceles.set((i + 1), max);

								} else {
									Vehicles max = new Minivan();
									max = vehiceles.get(i);
									vehiceles.set(i, vehiceles.get(i + 1));
									vehiceles.set((i + 1), max);

								}
							} else if (m == n) {//if the first litter from each word equals then check the secound litter
								m = vehiceles.get(i).getBrand().charAt(1);
								n = vehiceles.get(i + 1).getBrand().charAt(1);
								if (m > n) {
									if (vehiceles.get(i) instanceof Car) {
										Vehicles max = new Car();
										max = vehiceles.get(i);
										vehiceles.set(i, vehiceles.get(i + 1));
										vehiceles.set((i + 1), max);

									} else if (vehiceles.get(i) instanceof Minivan) {
										Vehicles max = new Minivan();
										max = vehiceles.get(i);
										vehiceles.set(i, vehiceles.get(i + 1));
										vehiceles.set((i + 1), max);

									} else {
										Vehicles max = new Minivan();
										max = vehiceles.get(i);
										vehiceles.set(i, vehiceles.get(i + 1));
										vehiceles.set((i + 1), max);

									}
								}
							}
						}
					for (int z = 0; z < vehiceles.size(); z++) {
						System.out.println(vehiceles.get(z));
					}
					 System.out.println("Data sort successfuly"); //sort done

				} else if (H == 6) { // Clone Vehicle without owner, (choice one object for cloning from Arraylist)
					System.out.println("select vehicle to clone: ");
					int index = in.nextInt();
					if (index >= 0 && index < vehiceles.size()) {
						System.out.println(vehiceles.get(index).clone());
					} else
						throw new IllegalArgumentException("The number must be from 0 to " + (vehiceles.size()-1));
					 System.out.println("Data sort successfuly");

				} else if (H == 7) { // Turn air-condition on.

					for (int g = 0; g < vehiceles.size(); g++) {
						if (vehiceles.get(g) instanceof Car)
							((Car) vehiceles.get(g)).setairConditionON(true);
						else if (vehiceles.get(g) instanceof Truck)
							((Truck) vehiceles.get(g)).setairConditionON(true);
						else
							((Minivan) vehiceles.get(g)).setAirConditionON(true);
					}
					 System.out.println("The air condition has been turned on");

				} else if (H == 8) { // Write Output on the “output.txt” file after sort them
					for (int y = 0; y < vehiceles.size(); y++)
						out.println(vehiceles.get(y));
					System.out.println("data wrote to file successfully");
					out.close();
					
				} else if (H == 9) { // Exit from System
					input.close();
					System.exit(0);
				} else {
					input.close();
					throw new IllegalArgumentException("The entered number has no result");
				}
				H = in.nextInt();

			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error : File has something wrong !");
	}
	}
}
