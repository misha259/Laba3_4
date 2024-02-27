package locations;

import exceptions.HumanIsNotInBuilding;
import humans.Human;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Room{
    private final ArrayList<Human> peopleInRoom;
    private final Building building;
    Room(Building building){
        this.building = building;
        peopleInRoom = new ArrayList<>();
    }
    public ArrayList<Human> getPeopleInRoom(){
        return peopleInRoom;
    }
    public void addInRoom(Human human){
        if(human.getBuilding()==null||!human.getBuilding().equals(getBuilding())) throw new HumanIsNotInBuilding(human);
        else peopleInRoom.add(human);
    }
    public void deleteFromRoom(Human human){
        peopleInRoom.remove(human);
    }
    public Building getBuilding(){
        return building;
    }
    @Override
    public int hashCode(){
        return Objects.hash(peopleInRoom);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null||obj.getClass()!=getClass()) return false;
        Room that = (Room) obj;
        return peopleInRoom.equals(that.peopleInRoom);
    }
}
