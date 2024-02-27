package things;

import humans.Secretary;

public class Chair {
    private final String material;
    private Secretary secretary;
    public Chair(String material){
        this.material = material;
    }
    public void setSecretary(Secretary secretary){
        this.secretary = secretary;
    }
    @Override
    public String toString(){
        return String.format("%s кресле", material);
    }
}
