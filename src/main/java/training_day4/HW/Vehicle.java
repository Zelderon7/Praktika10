package training_day4.HW;

import java.lang.reflect.Field;

public abstract class Vehicle {
    public final double DEFAULT_FUEL_CONSUMPTION;
    private double fuelConsumption;
    private int horsePower;
    private double fuel;

    public Vehicle(double fuel, int horsePower, double DEFAULT_FUEL_CONSUMPTION){
        this.DEFAULT_FUEL_CONSUMPTION = DEFAULT_FUEL_CONSUMPTION;
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = this.DEFAULT_FUEL_CONSUMPTION;
    }

    public Vehicle(double fuel, int horsePower){
        this.DEFAULT_FUEL_CONSUMPTION = 1.25;
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = this.DEFAULT_FUEL_CONSUMPTION;
    }


    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        if (fuelConsumption >= 0) {
            this.fuelConsumption = fuelConsumption;
        } else {
            System.out.println("Invalid fuel consumption value. Fuel consumption must be non-negative.");
        }
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        if (horsePower >= 0) {
            this.horsePower = horsePower;
        } else {
            System.out.println("Invalid horse power value. Horse power must be non-negative.");
        }
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        if (fuel >= 0) {
            this.fuel = fuel;
        } else {
            System.out.println("Invalid fuel value. Fuel must be non-negative.");
        }
    }


    public void Drive(double kilometers){
        if(this.horsePower < 1)
            System.out.println("0hp how poor are u? \uD83D\uDE01 \uD83D\uDE01");
        else if(this.fuel < kilometers*this.fuelConsumption){
            System.out.println("U only have " + fuel + " fuel, but u need " + kilometers*this.fuelConsumption + " for the trip");
        }
        else{
            fuel -= kilometers*this.fuelConsumption;
            System.out.println("Driving...");
            System.out.println("You arrived at your destination with " + fuel + " fuel left\uD83D\uDE01 \uD83D\uDE01");
        }
    }

}
