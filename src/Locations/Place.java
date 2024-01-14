package Locations;

import exception.NameError;
import humans.Accountant;
import humans.Human;

import java.util.ArrayList;

public class Place {
    private String name;
    private ArrayList<Human> peopleList = new ArrayList<>();
    private String condition;
    public Place(String name) throws NameError {
        this.name = name;
        if(name.isEmpty())
            throw new NameError("Место не может быть создан без имени!");
    }
    public String getName() {
        return name;
    }
    public void addPeople(Human h) {
        this.peopleList.add(h);
    }
    public void removePeople(Human h) {
        this.peopleList.remove(h);
    }
    public String getPeople(){
        String peopleInString = "В " + this.getName() + " находятся: ";
        for (int i = 0; i < peopleList.size(); i++) {
            if (i == peopleList.size() - 1) {
                peopleInString += peopleList.get(i) + " ";
            } else {
                peopleInString += peopleList.get(i) + ", ";
            }
        }
        return peopleInString;
    }
    public void setCondition(String condition){this.condition = condition;}
    public String getCondition(){
        return "В " + this.getName() + " " + this.condition;
    }
}
