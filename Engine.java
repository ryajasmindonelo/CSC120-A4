/**
 * Represents an engine with a particular fuel type and capacity.
 **/
public class Engine {
    private FuelType fuelType;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Generates an engine with a particular fuel type and maximum fuel level.
     * @param fuelType The type of fuel this engine uses.
     * @param maxFuelLevel The maximum amount of fuel the engine can hold.
     **/
    public Engine(FuelType fuelType, double maxFuelLevel){
        this.fuelType = fuelType;
        this.currentFuelLevel = maxFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * Gets the fuel type of the engine.
     * @return The type of fuel the engine is using.
     **/
    public FuelType getFuelType(){
        return fuelType;
    }

    /**
     * Gets the current fuel level of the engine.
     * @return The amount of fuel currently in engine.
     **/
    public double getCurrentFuelLevel(){
        return currentFuelLevel;
    }

    /**
     * Gets the maximum fuel level of engine.
     * @return The maximum fuel capacity of engine.
     **/
    public double getMaxFuelLevel(){
        return maxFuelLevel;
    }

    /**
     * Refills the engine's fuel to its maximum level.
     **/
    public void refuel(){
        currentFuelLevel = maxFuelLevel;
    }

    /**
     * Simulates the engine consuming fuel. Otherwise, throws an error when there is no fuel left.
     * @throws RuntimeException if the engine is out of fuel.
     **/
    public void go() {
        if (currentFuelLevel <= 0){
            throw new RuntimeException("Out of fuel");
        }

        currentFuelLevel -= 1.0;
        System.out.println("Remaining fuel level: " + currentFuelLevel);
    }
    public static void main(String[] args){
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try{
            while (true) {
                myEngine.go();
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}