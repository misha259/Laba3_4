package humans;

import locations.Place;

public class Manager extends Human {

    private String hideStatus;

    public Manager(String name) {
        super(name);
    }

    public void runFrom(Place startPlace, Place finishPlace) {
        this.setLocation(finishPlace);
        System.out.printf(this + " выбежал из " + startPlace + ". ");
    }

    public void recognition(Human humanArgument, Boolean status) {
        humanArgument.setIsRecognition(status);
        if (status) {
            System.out.printf(this + " узнал " + humanArgument + ". ");
        } else {
            System.out.printf(this + " не узнал " + humanArgument + ". ");
        }
    }

    public void setHideStatus(String how) {
        this.hideStatus = how;
    }

    public String hide() {
        return (this + " исчез " + this.hideStatus + ". ");
    }
}
