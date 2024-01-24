package humans;

import locations.Place;

public class Secretary extends Human {

    private final Face face;
    private String lyingPlace;
    private String lieDescription;
    private String thing;

    public Secretary(String name) {
        super(name);
        face = new Face();
        face.setDescription("весь подбородок был вымазан губной помадой", "по персиковым щекам ползли с ресниц потоки раскисшей краски");
    }

    public class Face { //no static because we cant create face without secretary
        String description_chin;
        String description_cheeks;

        public void setDescription(String chin, String cheeks) {
            this.description_chin = chin;
            this.description_cheeks = cheeks;
        }

        public String getDescription() {
            return description_chin + ", " + description_cheeks;
        }
    }

    public void lunge(Human h) {
        System.out.printf(this + " кинулся к " + h + ". ");
    }

    public void grab(String clothes) {
        System.out.printf(this + " вцепился в " + clothes + ". ");
    }

    public void shake(Human h) {
        h.shakeStatus = true;
        System.out.printf(this + " потрясла " + h + ". ");
    }

    public void pull(Human h, Place p) {
        h.setLocation(p);
        this.setLocation(p);
        System.out.printf(this.getName() + " потащила " + h + " в " + p + ". ");
    }

    public void lie(String furniture, String how) {
        this.lyingPlace = furniture;
        this.lieDescription = how;
        System.out.printf(this + " лежит на " + this.lyingPlace + " " + this.lieDescription + ". ");
    }

    public void standUp() {
        this.lyingPlace = "";
        this.lieDescription = "";
        System.out.printf(this + " встала. ");
    }

    public String getFaceDescription() {
        return "У " + this.getName() + " " + this.face.getDescription() + ". ";
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getThing() {
        return this + " держит " + this.thing + ". ";
    }
}
