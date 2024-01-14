package humans;

import Locations.Place;
import exception.NameError;
import intefaces.Talkable;
import Moodings.Moods;
import actionsTypes.*;

public abstract class Human implements Talkable {
    private final String name;
    private Place location;
    private Moods mood;
    private String thoughts;
    public boolean shake_status;

    private Boolean isRecognition;

    public Human(String name) throws NameError {
        this.name = name;
        if(name.isEmpty())
            throw new NameError("Персонаж не может быть создан без имени!");
    }

    public String getName() {
        return name;
    }

    public void setLocation(Place p) {
        this.location = p;
    }

    public Place getLocation() {
        return this.location;
    }

    public void setMood(Moods m) {
        this.mood = m;
        System.out.println(this.getName() +" смена состояния на:"+ this.mood.getMood());
    }

    public String getMood() {
        return this.getName() + " находится в состоянии:" +this.mood.getMood();
    }
    public void think(String about){
        this.thoughts = about;
        System.out.println(this.thoughts + " подумал " + this.getName());
    }

    public void say(String message, Speeches speech, Human h) {
        System.out.println("\"" + message + "\" - " + speech.getType() + " " + this.getName() + " " + h);
    }

    public void say(String message, Speeches speech) {
        System.out.println("\"" + message + "\" - " + speech.getType() + " " + this.getName());
    }

    public void replace(Place p, TypeWalking t) {
        if (this.getLocation() != null) {
            this.getLocation().removePeople(this);
        }
        p.addPeople(this);
        this.setLocation(p);
        System.out.println(this.getName() + " " + t.getName() + " в локацию: " + p.getName());
    }

    public void see(Human h) {

    }

    public void setIsRecognition(Boolean status) {
        this.isRecognition = status;
    }

    public Boolean getIsRecognition() {
        return this.isRecognition;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "персонаж " + this.getName();
    }

}
