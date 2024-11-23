import java.util.ArrayList;

/**
 * Represents a car that carries passengers
 **/
public class Car {
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    /**
     * Initializes a car with a maximum number of passengers it may hold.
     * @param maxCapacity The maximum number of passengers allowed in a car.
     **/
    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<>();
    }

    /**
     * Returns the maximum number of passengers the car may hold.
     * @return Maximum capacity of the car
     **/
    public int getCapacity(){
        return maxCapacity;
    }

    /**
     * Returns the number of seats available in the car.
     * @return The number of remaining seats in the car.
     **/
    public int seatsRemaining(){
        return maxCapacity - passengers.size();
    }

    /**
     * Adds a passenger to the car if there is still space. Otherwise, throws an error if the car is already full.
     * @param passenger The passenger to add in the car.
     * @throws RuntimeException if the car is full.
     **/
    public void addPassenger(Passenger passenger){
        if (seatsRemaining() == 0) {
            throw new RuntimeException("Car is full");
        }
        passengers.add(passenger);
    }

    /**
     * Removes a passenger from the car. Otherwise, throws an error if the passenger is not in the car.
     * @param passenger The passenger to remove in the car.
     * @throws RuntimeException if the passenger is not found in the car.
     **/
    public void removePassenger(Passenger passenger){
        if (!passengers.contains(passenger)) {
            throw new RuntimeException("Passenger not on this car");
        }

        passengers.remove(passenger);
    }

    /**
     * Prints a list of passengers in the car. Otherwise, if there are no passengers, it says the car is empty.
     **/
    public void printManifest(){
        if (passengers.isEmpty()){
            System.out.println("This car is EMPTY.");
        }else{
            System.out.println("Passengers on this car:");
            for (Passenger passenger : passengers) {
                System.out.println("- " + passenger);
            }
        }
    }
    
    public static void main(String[] args){
        Car myCar = new Car(200);
        try {
            while (true) {
                myCar.printManifest();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}