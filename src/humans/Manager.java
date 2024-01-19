package humans;

import Locations.Place;

public class Manager extends Human {

    private String hideStatus;
    public Manager(String name) {
        super(name);
    }

    public void runFrom(Place startP, Place finishP){
        this.setLocation(finishP);
        System.out.printf(this + " выбежал из " + startP + ". ");
    }
    public void recognition(Human h, Boolean status) {
        h.setIsRecognition(status);
        if (status) {
            System.out.printf(this + " узнал " + h + ". ");
        } else {
            System.out.printf(this+ " не узнал " + h + ". ");
        }

    }

    public void setHide(String how) {
        this.hideStatus = how;
    }
    public String hide(){
        return (this + " исчез " + this.hideStatus + ". ");
    }
}
