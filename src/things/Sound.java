package things;

public class Sound {
    private final String message;
    public Sound(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
    @Override
    public String toString(){
        return message;
    }
}
