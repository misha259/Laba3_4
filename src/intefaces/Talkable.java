package intefaces;
import actionsTypes.*;
import humans.*;
public interface Talkable {
    public void say(String message, Speeches speech, Human h);
    public void say(String message, Speeches speech);
}
