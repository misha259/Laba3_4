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

    public void lunge(Human humanArgument) {
        System.out.printf(this + " кинулся к " + humanArgument + ". ");
    }

    public void grab(String clothes) {
        System.out.printf(this + " вцепился в " + clothes + ". ");
    }

    public void shake(Human humanArgument) {
        humanArgument.shakeStatus = true;
        System.out.printf(this + " потрясла " + humanArgument + ". ");
    }

    public void pull(Human humanArgument, Place placeArgument) {
        humanArgument.setLocation(placeArgument);
        this.setLocation(placeArgument);
        System.out.printf(this.getName() + " потащила " + humanArgument + " в " + placeArgument + ". ");
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
