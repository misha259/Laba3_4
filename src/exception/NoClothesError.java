package exception;

import humans.Human;

public class NoClothesError extends Exception{
    private Human human;
    private String message;

    public NoClothesError(Human human, String message){
        super(human + message);
        this.human = human;
        this.message = message;
    }

    @Override
    public String getMessage(){
        return human + message;
    }
}
