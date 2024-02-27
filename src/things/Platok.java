package things;

public class Platok {
    private boolean isWet;
    public void getWet(){
        isWet = true;
    }
    @Override
    public String toString(){
        return isWet? "мокрый платок": "платок";
    }
}
