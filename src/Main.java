import humans.*;
import interfaces.CanDrive;
import locations.Building;
import things.Car;

public class Main {
    public static void main(String[] args) {
        Accountant accountant = new Accountant();
        Courier courier = new Courier();
        Manager manager = new Manager();
        Secretary secretary = new Secretary();
        President president = new President();
        CanDrive driver = new CanDrive(){
            public void driveToBuilding(Car car, Building building){
                System.out.printf("%s приехал в %s.%n", car.getPassenger(),building);
                car.getPassenger().payUp();
                car.getPassenger().setBuilding(building);
                car.clear();
            }
        };

        Building building = new Building(courier, manager, president, secretary);
        Car car = new Car(driver, accountant);
        driver.driveToBuilding(car, building);
        building.getCorridor().addInRoom(accountant);

        accountant.run(building.getManagerCabinet());
        courier.run(building.getAnonymCabinet());
        manager.run(building.getAnonymCabinet());
        accountant.run(building.getSecretaryCabinet());

        accountant.think(president.createSound());
        accountant.see(building.getSecretaryCabinet(), secretary);
        secretary.see(accountant);
    }
}