import java.util.ArrayList;

/**
 * Represents a train consisting of an engine and cars.
 **/
public class Train{
    private final Engine engine;
    private ArrayList<Car> cars;

    /**
     * Creates a train with a particular engine, number of cars, and each car's passenger capacity.
     * @param fuelType The type of fuel the train's engine is using.
     * @param fuelCapacity The maximum fuel capacity of the engine of the train.
     * @param nCars The number of cars in the train.
     * @param passengerCapacity The maximum number of passengers each car holds.
     **/
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++) {
            Car car = new Car(passengerCapacity);
            cars.add(car);
        }
    }

    /**
     * Gets the train's engine.
     * @return Train engine.
     **/
    public Engine getEngine(){
        return engine;
    }

    /**
     * Gets a specific car from the train.
     * @param i The index of the car to get.
     * @return The car at the particular index.
     **/
    public Car getCar(int i){
        return cars.get(i);
    }

    /**
     * Calculates the total maximum passenger capacity of the train.
     * @return The total maximum number of passengers the train may hold.
     **/
    public int getMaxCapacity(){
        int maxCapacity = 0;
        for (Car car : cars) {
            maxCapacity += car.getCapacity();
        }
        return maxCapacity;
    }

    /**
     * Calculates the total number of seats still available across all cars in the train.
     * @return The total number of empty seats in the train.
     **/
    public int seatsRemaining(){
        int totalSeats = 0;
        for (Car car : cars) {
            totalSeats += car.seatsRemaining();
        }
        return totalSeats;
    }

    /**
     * Prints the train's manifest which shows the passengers in each car.
     **/
    public void printManifest() {
        System.out.println("Train manifest:");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + (i+1) + ":");
            cars.get(i).printManifest();
        }
    }
    
    /**
     * Removes a specific car from the train and reconfigures the train's cars.
     * @param i The index of the car being removed.
     * @param train The train which is being modified.
     **/
    public void removeCar(int i, Train train){
    	cars.remove(i);
    	train = new Train(train.getEngine().getFuelType(),
                          train.getEngine().getCurrentFuelLevel(),
                          cars.size(),
                          train.getMaxCapacity()/cars.size());
    }

    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 200, 3, 50);
    
        Passenger iris = new Passenger("Iris");
        Passenger mique = new Passenger("Mique");
        Passenger izzy = new Passenger("Izzy");
        Passenger david = new Passenger("David");
        iris.boardCar(myTrain.getCar(0));
        mique.boardCar(myTrain.getCar(0));
        izzy.boardCar(myTrain.getCar(1));
        myTrain.printManifest();
        myTrain.removeCar(1,myTrain);
        david.boardCar(myTrain.getCar(0));
        myTrain.printManifest();
    }
}