package humans;

import enums.Status;
import locations.Building;

public abstract class Human {
    private Building building;
    private Status status = Status.NORMAL;
    public void setBuilding(Building building){
        this.building = building;
    }
    public Building getBuilding(){
        return building;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return status;
    }
}
