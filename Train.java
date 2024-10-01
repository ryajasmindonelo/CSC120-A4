import java.util.ArrayList;

/*
 * Enum for FuelType
 */
enum FuelType {
    ELECTRIC,
    DIESEL,
    GASOLINE
}

/*
 * Engine class
 */
class Engine {
    private final FuelType fuelType;
    private double currentFuel;
    private final double maxFuel;

    /*
     * Constructor
     */
    public Engine(FuelType fuelType, double currentFuel, double maxFuel) {
        this.fuelType = fuelType;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
    }

    /*
     * makes the current fuel to the maximum fuel
     */
    public void refuel() {
        currentFuel = maxFuel;
    }

    /*
     * decreases the fuel level
     */
    public boolean go() {
        if (currentFuel > 0) {
            currentFuel -= 1;
            System.out.println("The remaining fuel level is " + currentFuel);
            return true;
        } else {
            return false;
        }
    }

    /*
     * accessor method for returning fuelType
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /*
     * accessor method for returning currentFuel
     */
    public double getCurrentFuel() {
        return currentFuel;
    }

    /*
     * accessor method for returning maxFuel
     */
    public double getMaxFuel() {
        return maxFuel;
    }
}

/*
 * Passenger class
 */
class Passenger {
    private String name;  

    /*
     * Constructor
    */
    public Passenger(String name) {
        this.name = name;
    }

    /*
     * Getter for the name of the passenger
     */
    public String getName() {
        return name;
    }

    /*
     * methods to board and get off car
     */
    public void boardCar(Car c) {
        c.addPassenger(this);
    }

    public void getOffCar(Car c) {
        c.removePassenger(this);
    }

    /*
     * shows passenger information
     */
    public void displayInfo() {
        System.out.println("Passenger Name: " + name);
    }
}

/*
 * Car class definition
 */
class Car {
    private ArrayList<Passenger> passengers;
    private int capacity; /** indicates the maximum capacity of the car*/

    public Car(int capacity) {
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    /*
     * adds passenger to car
     */
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger); 
            System.out.println(passenger.getName() + " has boarded the car.");
        } else {
            System.out.println("Car is full. Cannot add " + passenger.getName());
        }
    }

    /*
     * removes passenger in car
     */
    public void removePassenger(Passenger passenger) {
        if (passengers.remove(passenger)) {
            System.out.println(passenger.getName() + " has gotten off the car.");
        } else {
            System.out.println("Passenger not found in the car.");
        }
    }

    /*
     * returns capacity of the car
     */
    public int getCapacity() {
        return capacity;
    }

    /*
     * returns remaining seats
     */
    public int seatsRemaining() {
        return capacity - passengers.size();
    }

    /*
     * prints list of passengers
     */
    public void printManifest() {
        System.out.println("Passengers in the car:");
        for (Passenger passenger : passengers) {
            System.out.println("- " + passenger.getName());
        }
    }
}

/*
 * Train class definition
 */
public class Train {
    
    private Engine engine;
    private ArrayList<Car> carAttached = new ArrayList<>();
    private final FuelType fuelType;
    private final double fuelCapacity;
    private final int nCars;  // number of cars
    private final int passengerCapacity; // capacity for a car
    
    /**
     * Constructor that initializes the Engine and Cars and stores them
     * @param fuelType type of fuel
     * @param fuelCapacity capacity of fuel
     * @param nCars cars
     * @param passengerCapacity capacity
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity, passengerCapacity); 
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.nCars = nCars;
        this.passengerCapacity = passengerCapacity;

        for (int i = 0; i < nCars; i++) {
            carAttached.add(new Car(passengerCapacity));  // Add cars with defined capacity
        }
    }
    /*
    * accessors to get engine, to return the "i"th car, to return the maximum capacity of cars, and to return number of remaining unreserved seats
    */

    public Engine getEngine() {
        return engine;
    }

    public Car getCar(int i) {
        return carAttached.get(i);
    }

    public int getMaxCapacity() {
        int maxCap = 0;
        for (Car car : this.carAttached) {
            maxCap += car.getCapacity();
        }
        return maxCap;
    }

    public int seatsRemaining() {
        int seatsLeft = 0;
        for (Car car : this.carAttached) {
            seatsLeft += car.seatsRemaining();
        }
        return seatsLeft;
    }

    /*
     * prints a list of passengers in the car
     */
    public void printManifest() {
        for (Car car : this.carAttached) {
            car.printManifest();
        }
    }
}