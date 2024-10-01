import java.util.ArrayList;

/**
 * represents a train car's maximum capacity and the number of passengers it is now carrying
 */
public class Car {
    /*
     * passengers on board (currently)
     */
    private final ArrayList<Passenger> passengersOnBoard = new ArrayList<>();
    /*
     *  maximum capacity of the car
     */
    private final int maxCapacity;

    /**
     * constructor which initializes car with maximum capacity
     * @param maxCapacity is the maximum capacity of the car
     */
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * returns the maximum capacity of the car
     * @return maximum capacity
     */
    public int getCapacity() {
        return maxCapacity;
    }

    /**
     * returns the number of seats remaining
     * @return remaining number of seats
     */
    public int seatsRemaining() {
        return (maxCapacity - passengersOnBoard.size());
    }

    /**
     * adds a passenger to car
     * @param p passenger to add
     * @return true (removed successfully), false (not removed succesfully)
     */
    public boolean addPassenger(Passenger p) {
        if (seatsRemaining() > 0 && !passengersOnBoard.contains(p)) {
            passengersOnBoard.add(p);
            return true;
        }
        return false;
    }

    /**
     * removes passenger from car
     * @param p passenger to remove
     * @return true (removed successfully), false (not removed succesfully)
     */
    public boolean removePassenger(Passenger p) {
        return passengersOnBoard.remove(p);
    }

    /**
     * prints a list of passengers in the car
     */
    public void printManifest() {
        if (seatsRemaining() == maxCapacity) {
            System.out.println("This car is EMPTY");
        } else {
            System.out.println("Passengers on board:");
            for (Passenger p : passengersOnBoard) {
                System.out.print(p.getName() + " ");
            }
            System.out.println();
        }
    }
}
