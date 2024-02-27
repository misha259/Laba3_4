package locations;

import humans.*;

import java.util.ArrayList;
import java.util.Objects;

public class Building {
    private final ArrayList<Human> peopleInBuilding;
    private final Corridor corridor;
    private final SecretaryCabinet secretaryCabinet;
    private final ManagerCabinet managerCabinet;
    private final OfficeCabinet officeCabinet;
    private final AnonymCabinet anonymCabinet;
    public Building(Courier courier, Manager manager, President president, Secretary secretary){
        this.peopleInBuilding = new ArrayList<>();
        this.corridor = new Corridor(this);
        this.secretaryCabinet = new SecretaryCabinet(this);
        this.managerCabinet = new ManagerCabinet(this);
        this.officeCabinet = new OfficeCabinet(this);
        this.anonymCabinet = new AnonymCabinet(this);
        addHuman(courier);
        addHuman(manager);
        addHuman(president);
        addHuman(secretary);
        corridor.addInRoom(courier);
        corridor.addInRoom(manager);
        corridor.addInRoom(president);
        corridor.addInRoom(secretary);
        secretaryCabinet.addInRoom(manager);
        secretaryCabinet.addInRoom(president);
        secretaryCabinet.addInRoom(secretary);
    }
    public Corridor getCorridor(){
        return corridor;
    }
    public OfficeCabinet getOfficeCabinet(){
        return officeCabinet;
    }
    public SecretaryCabinet getSecretaryCabinet(){
        return secretaryCabinet;
    }
    public ManagerCabinet getManagerCabinet(){
        return managerCabinet;
    }
    public AnonymCabinet getAnonymCabinet(){
        return anonymCabinet;
    }
    public void addHuman(Human human){
        peopleInBuilding.add(human);
        human.setBuilding(this);
    }
    @Override
    public int hashCode(){
        return Objects.hash(peopleInBuilding, corridor, secretaryCabinet, managerCabinet, officeCabinet, anonymCabinet);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null||obj.getClass()!=getClass()) return false;
        Building that = (Building) obj;
        return peopleInBuilding.equals(that.peopleInBuilding)&&corridor.equals(that.corridor)&& secretaryCabinet.equals(that.secretaryCabinet)&& managerCabinet.equals(that.managerCabinet)&&officeCabinet.equals(that.officeCabinet)&& anonymCabinet.equals(that.anonymCabinet);
    }
    @Override
    public String toString(){
        return "здание";
    }
}
