package locations;

import interfaces.CreateSound;
import things.Sound;

public class OfficeCabinet extends Cabinet implements CreateSound {
    OfficeCabinet(Building building){
        super(building);
    }
    public Sound createSound(){
        return new Sound("звуки суматохи");
    }
    @Override
    public String toString(){
        return "канцелярии";
    }
}
