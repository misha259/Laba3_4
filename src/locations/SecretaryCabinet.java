package locations;

import things.Chair;

public class SecretaryCabinet extends Cabinet{
    private final Chair chair;
    public SecretaryCabinet(Building building){
        super(building);
        this.chair = new Chair("кожаном");
    }
    public Chair getChair(){
        return chair;
    }
    @Override
    public String toString(){
        return "секретарской комнаты";
    }
}
