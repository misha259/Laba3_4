package humans;

import enums.Status;
import exceptions.HumanIsNotInBuilding;
import interfaces.CreateSound;
import interfaces.Running;
import locations.AnonymCabinet;
import locations.Cabinet;
import things.Clothes;
import things.Sound;

public class Courier extends Human implements Running, CreateSound {
    private final Clothes clothes;
    public Courier(){
        clothes = new Clothes(0);
    }
    public void run(Cabinet cabinet){
        if(!cabinet.getBuilding().equals(getBuilding())) throw new HumanIsNotInBuilding(this);
        else if (cabinet.equals(getBuilding().getAnonymCabinet())){
            AnonymCabinet anonymCabinet = (AnonymCabinet) cabinet;
            setStatus(Status.SHOCKED);
            System.out.printf("Мимо бухгалтера пробежала %s.%n", this);
            System.out.printf("%s %s закричала: %s", this, getStatus(), createSound());
            cabinet.addInRoom(this);
            System.out.printf("%s скрылась в %s.%n", this, anonymCabinet);
            System.out.printf("Раздались %s.%n", anonymCabinet.createSound());
        }
    }
    public Sound createSound(){
        return new Sound(String.format("Нету, нету, нету милые мои! Пиджак и штаны тут, в пиджаке %s вещей!%n", clothes.getAmountOfThings()));
    }
    @Override
    public String toString(){
        return "Курьерша";
    }
}
