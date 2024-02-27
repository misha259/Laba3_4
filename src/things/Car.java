package things;

import humans.Accountant;
import interfaces.CanDrive;

public class Car {
    private final CanDrive driver;
    private Accountant passenger;
    public Car(CanDrive driver, Accountant passenger){
        this.driver = driver;
        this.passenger = passenger;
    }
    public Accountant getPassenger(){
        return passenger;
    }
    public void clear(){
        passenger = null;
    }
}

