package exceptions;

import humans.Human;

public class HumanIsNotInBuilding extends RuntimeException{
    public HumanIsNotInBuilding(Human human){
        super(String.format("%s не в здании и не может быть в комнате", human));
    }

}

