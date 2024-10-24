public class Passenger {

    private String name;

    public Passenger(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void boardCar(Car car){
        try{
            car.addPassenger(this);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void getOffCar(Car car){
        try{
            car.removePassenger(this);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString(){
        return name;
    }

    public static void main(String[] args){
        Passenger passenger = new Passenger("James");
        try {
            while (true) {
                passenger.toString();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
