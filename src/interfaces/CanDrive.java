package interfaces;

import locations.Building;
import things.Car;

public interface CanDrive {
    void driveToBuilding(Car car, Building building);
}
