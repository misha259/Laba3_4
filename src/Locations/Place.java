package locations;

import exception.NameError;
import humans.Human;

import java.util.ArrayList;

public class Place {
    private String name;
    private ArrayList<Human> peopleList = new ArrayList<Human>();
    private String condition;
    public Place(String name) throws NameError {
        this.name = name;
        if(name.isEmpty() || name.charAt(0) == ' ')
            throw new NameError("Название места на может начинаться с пробела или отсуствовать!");
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
        return peopleList.toString().replace('[',' ').replace(']',' ');
    }
    public void setCondition(String condition){this.condition = condition;}
    public String getCondition(){
        return "В " + this.getName() + " " + this.condition + ". ";
    }


    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Place place = (Place) obj;
        return place.name.equals(name) && place.condition.equals(condition) && place.peopleList.equals(peopleList);
    }

    @Override
    public String toString() {
        return "(место) " + this.getName();
    }
}
