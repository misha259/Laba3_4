package humans;

import enums.Status;
import exceptions.HumanIsNotInBuilding;
import exceptions.NotEnoughMoney;
import interfaces.Running;
import locations.Cabinet;
import locations.OfficeCabinet;
import locations.SecretaryCabinet;
import things.Clothes;
import things.Sound;

public class Accountant extends Human implements Running {
    private int hisMoney;
    private final Clothes clothes;
    public Accountant(){
        hisMoney = 400;
        clothes = new Clothes(0);
    }
    public Clothes getClothes(){
        return clothes;
    }
    public void payUp(){
        Random checkForTaxi = (coefficient) -> (int) (Math.random() * coefficient);
        int check = checkForTaxi.random(1000);
        try{
            if (check>hisMoney) throw new NotEnoughMoney(hisMoney, check);
            else {
                hisMoney -= check;
                System.out.printf("%s заплатил водителю. Его баланс: %s.%n", this, hisMoney);
            }
        }catch(NotEnoughMoney ex){
            System.out.println(ex.getMessage());
            System.out.printf("%s пытается договориться с таксистом о другой цене.%n", this);
            payUp();
        }
    }
    public void run(Cabinet cabinet){
        if(!cabinet.getBuilding().equals(getBuilding())) throw new HumanIsNotInBuilding(this);
        else if(cabinet.equals(getBuilding().getManagerCabinet())) {
            OfficeCabinet officeCabinet = getBuilding().getOfficeCabinet();
            System.out.printf("%s побежал в %s.%n", this, cabinet);
            System.out.printf("В %s были слышны %s.%n", officeCabinet, officeCabinet.createSound());
        }
        else if(cabinet.equals(getBuilding().getSecretaryCabinet())) {
            SecretaryCabinet secretaryCabinet = (SecretaryCabinet) cabinet;
            setStatus(Status.SHOCKED);
            System.out.printf("%s был %s и пошел в %s.%n", this, getStatus(), secretaryCabinet);
            secretaryCabinet.addInRoom(this);
        }
    }
    public void think(Sound sound){
        if(sound.getMessage().equals("грозный голос")) setStatus(Status.CONFUSED);
        System.out.printf("Из-за закрытой двери доносился %s.%n", sound);
        System.out.printf("%s %s подумал: Распекает, что ли, кого?%n", this, getStatus());
    }
    public void see(SecretaryCabinet secretaryCabinet, Secretary secretary){
        if(!secretaryCabinet.getBuilding().equals(getBuilding())) throw new HumanIsNotInBuilding(this);
        System.out.printf("%s увидел, что:%n", this);
        secretary.sit(secretaryCabinet.getChair());
        secretary.cry();
    }
    @Override
    public String toString(){
        return "Бухгалтер";
    }
}
interface Random{
    int random(int coefficient);
}
