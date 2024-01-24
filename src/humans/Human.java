package humans;

import action.types.Speeches;
import action.types.TypeWalking;
import locations.Place;
import exception.NameError;
import intefaces.Talkable;
import intefaces.Seen;
import moodings.Moods;

import java.util.Objects;

public abstract class Human implements Talkable, Seen {
    private final String name;
    private Place location;
    private Moods mood = Moods.NEUTRAL;
    private String thoughts;
    protected boolean shakeStatus = false;


    private boolean isRecognition;

    public Human(String name) throws NameError {
        this.name = name;
        if (name.isEmpty() || name.charAt(0) == ' ')
            throw new NameError("Имя персонажа никак не может начинаться с пробела или отсутствовать!");
    }

    public String getName() {
        return name;
    }

    public void setLocation(Place p) {
        if (this.getLocation() != null) {
            this.getLocation().removePeople(this);
        }
        p.addPeople(this);
        this.location = p;
    }

    public Place getLocation() {
        return this.location;
    }

    public void setMood(Moods m) {
        this.mood = m;
    }

    public String getMood() {
        return this + " находится в состоянии: " + this.mood.getName() + ". ";
    }

    public void think(String about) {
        this.thoughts = about;
        System.out.printf("\"" + this.thoughts + "\"" + " - подумал " + this + ". ");
    }

    public void say(String message, Speeches speech, Human h) {
        if (Objects.equals(message, "..."))
            System.out.printf(speech.getType() + " " + this + " " + h + ". ");
        else System.out.printf("\"" + message + "\" - " + speech.getType() + " " + this + " " + h + ". ");
    }

    public void say(String message, Speeches speech) {
        if (Objects.equals(message, "..."))
            System.out.printf(speech.getType() + " " + this + ". ");
        else System.out.printf("\"" + message + "\" - " + speech.getType() + " " + this + ". ");
    }

    public void replace(Place p, TypeWalking t) {
        this.setLocation(p);
        System.out.printf(this + " " + t.getName() + " в локацию: " + p.getName() + ". ");
    }

    @Override
    public void see() {
        System.out.printf(this + " видит" + this.getLocation().getPeople() + ". ");
    }

    @Override
    public void see(String what) {
        System.out.printf(this + " видит, что " + what + ". ");
    }

    public void setIsRecognition(Boolean status) {
        this.isRecognition = status;
    }


    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode() + this.thoughts.hashCode() + this.mood.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Human human = (Human) obj;
        return human.name.equals(name) && human.thoughts.equals(thoughts) && human.location.equals(location) && human.mood.equals(mood) && human.isRecognition == isRecognition;
    }

    @Override
    public String toString() {
        return "(персонаж) " + this.getName();
    }

}
