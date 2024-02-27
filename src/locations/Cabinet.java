package locations;

import exceptions.HumanIsNotInCorridor;
import humans.Human;

public abstract class Cabinet extends Room{
    public Cabinet(Building building){
        super(building);
    }
    @Override
    public void addInRoom(Human human){
        if(!getBuilding().getCorridor().getPeopleInRoom().contains(human)) throw new HumanIsNotInCorridor(human);
        super.addInRoom(human);
        getBuilding().getCorridor().deleteFromRoom(human);
    }
}
