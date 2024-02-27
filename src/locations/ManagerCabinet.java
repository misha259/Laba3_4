package locations;

public class ManagerCabinet extends Cabinet{
    ManagerCabinet(Building building){
        super(building);
    }
    @Override
    public String toString(){
        return "кабинет заведующего";
    }
}
