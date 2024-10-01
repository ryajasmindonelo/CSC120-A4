public class Engine {

    /*
     * the final is the field initialized and can't be changed after Construction
     */
    private final FuelType fuelType;
    private double maxFuel;
    private double currentFuel;

    /**
     * constructor takes initial values and sets them
     *
     * @param fuelType type of fuel the engine uses
     * @param currentFuel current amount of fuel in engine
     * @param maxFuel maximum fuel capacity of engine
     */
    public Engine(FuelType fuelType, double currentFuel, double maxFuel) {
        this.fuelType = fuelType; 
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
    }

    /**
     * makes the current fuel level tothe maximum fuel
     */
    public void refuel() {
        this.currentFuel = maxFuel;
        System.out.println("Refueled to: " + maxFuel);
    }

    /**
     * decreases the fuel level, prints remaining fuel, and returns true or false
     */
    public boolean go() {
        if (currentFuel > 0) {
            currentFuel -= 1;
            System.out.println("Current fuel level: " + currentFuel + "/" + maxFuel);
            return true;
        } else {
            System.out.println("No fuel left.");
                return false;
        }
    }

    /**
     * Getter for maxFuel
     */
    public double getMaxFuel() {
        return maxFuel;
    }

    /**
     * Getter for fuelType
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * main method
     */
    public static void main(String[] args) {
        // creates a new engine with the particular fuel type, current fuel, and maximum fuel
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 150.0);

        // calls refuel method to reset current fuel to max
        myEngine.refuel();

        // runs the engine running until it is out of fuel
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
}

enum FuelType {
    DIESEL, ELECTRIC, STEAM;
}
