import java.util.ArrayList;

public class Train{
    private final Engine engine;
    private ArrayList<Car> cars;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++){
            Car car = new Car(passengerCapacity);
            cars.add(car);
        }
    }

    public Engine getEngine(){
        return engine;
    }

    public Car getCar(int i){
        return cars.get(i);
    }

    public int getMaxCapacity(){
        int maxCapacity = 0;
        for (Car car : cars){
            maxCapacity += car.getCapacity();
        }
        return maxCapacity;
    }

    public int seatsRemaining(){
        int totalSeats = 0;
        for (Car car : cars){
            totalSeats += car.seatsRemaining();
        }
        return totalSeats;
    }

    public void printManifest(){
        System.out.println("Train manifest:");
        for (int i = 0; i < cars.size(); i++){
            System.out.println("Car " + (i+1) + ":");
            cars.get(i).printManifest();
        }
    }
    
    public void removeCar(int i, Train train){
    	cars.remove(i);
    	train = new Train(train.getEngine().getFuelType(),
                          train.getEngine().getCurrentFuelLevel(),
                          cars.size(),
                          train.getMaxCapacity()/cars.size());
    }
    public static void main(String[] args){
        Train myTrain = new Train(FuelType.ELECTRIC, 200, 3, 100);
    
        Passenger iris = new Passenger("Iris");
        Passenger mique = new Passenger("Mique");
        Passenger izzy = new Passenger("Izzy");
        Passenger joanne = new Passenger("Joanne");
        Passenger anna = new Passenger("Anna");
        iris.boardCar(myTrain.getCar(0));
        mique.boardCar(myTrain.getCar(0));
        anna.boardCar(myTrain.getCar(0));
        izzy.boardCar(myTrain.getCar(1));
        joanne.boardCar(myTrain.getCar(0));
        myTrain.removeCar(1,myTrain);
        myTrain.printManifest();
    }
}
