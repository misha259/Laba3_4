package locations;

import interfaces.CreateSound;
import things.Sound;

public class AnonymCabinet extends Cabinet implements CreateSound {
    AnonymCabinet(Building building){
        super(building);
    }
    public Sound createSound(){
        return new Sound("звуки битья посуды");
    }
    @Override
    public String toString(){
        return "неизвестном кабинете";
    }
}
