package humans;

import interfaces.CreateSound;
import things.Sound;

public class President extends Human implements CreateSound {
    public Sound createSound(){
        return new Sound("грозный голос");
    }
}
