package intefaces;

import action.types.Speeches;
import humans.*;

public interface Talkable {
    void say(String message, Speeches speech, Human h);

    void say(String message, Speeches speech);
}
