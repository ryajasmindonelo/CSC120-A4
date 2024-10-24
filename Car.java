import java.util.ArrayList;

public class Car{
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<>();
    }

    public int getCapacity(){
        return maxCapacity;
    }

    public int seatsRemaining(){
        return maxCapacity - passengers.size();
    }

    public void addPassenger(Passenger passenger){
        if (seatsRemaining()==0) {
            throw new RuntimeException("Car is full");
        }
        passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger){
        if (!passengers.contains(passenger)) {
            throw new RuntimeException("Passenger not on this car");
        }
        passengers.remove(passenger);
    }

    public void printManifest(){
        if (passengers.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println("Passengers on this car:");
            for (Passenger passenger : passengers) {
                System.out.println("- " + passenger);
            }
        }
    }
    public static void main(String[] args){
        Car myCar = new Car(100);
        try{
            while (true){
                myCar.printManifest();
            }
        }catch (Exception e){
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}