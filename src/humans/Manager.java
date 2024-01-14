package humans;

import Locations.Place;

public class Manager extends Human {

    private String hide_status;
    public Manager(String name) {
        super(name);
    }

    public void runFrom(Human h, Place p){
        p.removePeople(h);
        System.out.println(this.getName() + " выбежал из " + p.getName());
    }
    public void recognition(Human h, Boolean status) {
        h.setIsRecognition(status);
        if (status) {
            System.out.println(this.getName() + " узнал " + h);
        } else {
            System.out.println(this.getName() + " не узнал " + h.getName());
        }

    }

    public void hide(String how) {
        this.hide_status = how;
        System.out.println(this.getName() + " исчез " + this.hide_status);
    }
}
