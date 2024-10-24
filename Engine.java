public class Engine {
    private FuelType fuelType;
    private double currentFuelLevel;
    private double maxFuelLevel;

    public Engine(FuelType fuelType, double maxFuelLevel){
        this.fuelType = fuelType;
        this.currentFuelLevel = maxFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    public FuelType getFuelType(){
        return fuelType;
    }

    public double getCurrentFuelLevel(){
        return currentFuelLevel;
    }

    public double getMaxFuelLevel(){
        return maxFuelLevel;
    }

    public void refuel(){
        currentFuelLevel = maxFuelLevel;
    }

    public void go(){
        if (currentFuelLevel <= 0){
            throw new RuntimeException("Out of fuel");
        }
        currentFuelLevel -= 1.0;
        System.out.println("Remaining fuel level: " + currentFuelLevel);
    }
    
    public static void main(String[] args){
        Engine myEngine = new Engine(FuelType.ELECTRIC, 200.0);
        try{
            while (true){
                myEngine.go();
            }
        }catch(Exception e){
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}