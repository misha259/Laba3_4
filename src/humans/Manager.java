package humans;

import enums.Status;
import exceptions.HumanIsNotInBuilding;
import interfaces.Running;
import locations.AnonymCabinet;
import locations.Cabinet;

public class Manager extends Human implements Running {
    public void run(Cabinet cabinet){
        if(!cabinet.getBuilding().equals(getBuilding())) throw new HumanIsNotInBuilding(this);
        else if(cabinet.equals(getBuilding().getAnonymCabinet())) {
            getBuilding().getSecretaryCabinet().deleteFromRoom(this);
            getBuilding().getCorridor().addInRoom(this);
            setStatus(Status.CRAZY);
            System.out.printf("Из %s выбежал %s. Он был %s.%n", getBuilding().getSecretaryCabinet(), this, getStatus());
            AnonymCabinet anonymCabinet = (AnonymCabinet) cabinet;
            anonymCabinet.addInRoom(this);
            System.out.printf("%s скрылся в %s.%n", this, anonymCabinet);
        }
    }
    @Override
    public String toString(){
        return "Заведующий";
    }
}
