package things;

public class Clothes {
    private final int amountOfThings;
    private boolean isCaught;
    public Clothes(int amountOfThings){
        this.amountOfThings = amountOfThings;
    }
    public void setCaught(boolean b){
        isCaught = b;
    }
    public boolean getCaught(){
        return isCaught;
    }
    public int getAmountOfThings(){
        return amountOfThings;
    }
}
