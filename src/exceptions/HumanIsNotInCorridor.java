package exceptions;

import humans.Human;

public class HumanIsNotInCorridor extends RuntimeException{
    public HumanIsNotInCorridor(Human human){
        super(String.format("%s не находится в коридоре и не может оказаться в комнате", human));
    }
}
