package training_day4.HW;

public class TestHW {
    public static void main(String[] args){
        Car car = new Car(1000, 200);
        SportCar spCar = new SportCar(5000, 3000);
        RaceMotorcycle motor = new RaceMotorcycle(3100, 210);

        for (int i = 0; i < 1000; i += 10){
            car.driveVehicle(i);
            spCar.driveVehicle(i);
            motor.driveVehicle(i);
        }
    }
}
