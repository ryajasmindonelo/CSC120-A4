/**
 * identifies a named passenger who is able to enter or exit the car
 */
public class Passenger {
    /*
     * name of the passenger
     */
    private final String name;

    /**
     * constructor which initializes the name of the passenger
     * @param name the name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * gets the name of the passenger
     * @return is the name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * calls a passenger to get in the car
     * @param c is the car to board
     */
    public void boardCar(Car c) {
        c.addPassenger(this);
    }

    /**
     * calls a passenger to get off a the car
     * @param c is the car to get off
     */
    public void getOffCar(Car c) {
        c.removePassenger(this);
    }
}
