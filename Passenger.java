/**
 * Represents a passenger with a name who may board or get off the car.
 **/
public class Passenger {

    private String name;

    /**
     * Creates a passenger with a particular name.
     * @param name Passenger name.
     **/
    public Passenger(String name){
        this.name = name;
    }

    /**
     * Gets the name of the passenger.
     * @return Passenger's name.
     **/
    public String getName(){
        return name;
    }

    /**
     * Boards the specified car. Otherwise, if the car is full, an error message will be printed.
     * @param car The car to board.
     **/
    public void boardCar(Car car){
        try {
            car.addPassenger(this);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets off the specified car. Otherwise, if the passenger is not in the car, an error message will be printed.
     * @param car The car to get off from.
     **/
    public void getOffCar(Car car){
        try {
            car.removePassenger(this);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the passenger's name as a string.
     * @return The name of the passenger.
     **/
    public String toString(){
        return name;
    }

    public static void main(String[] args){
        Passenger passenger = new Passenger("Vicky");
        try{
            while (true) {
                passenger.toString();
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}