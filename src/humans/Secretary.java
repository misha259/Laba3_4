package humans;

import Locations.Place;

public class Secretary extends Human{

    final Face face;

    public Secretary(String name) {
        super(name);
        face = new Face();
        face.setDescription("весь подбородок был вымазан губной помадой", "по персиковым щекам ползли с ресниц потоки раскисшей краски");
    }

    public class Face {
        String description_chin;
        String description_cheeks;
        public void setDescription(String chin, String cheeks){
            this.description_chin = chin;
            this.description_cheeks = cheeks;
        }
        public String getDescription(){
            String message = description_chin + ", " + description_cheeks;
            return message;
        }
    }

    public void lunge(Human h){
        System.out.printf(this + " кинулся к " + h + ". ");
    }
    public void grab(String clothes){
        System.out.printf(this + " вцепился в " + clothes + ". ");
    }

    public void shake(Human h){
        h.shakeStatus = true;
        System.out.printf(this + " потрясла " + h + ". ");
    }

    public void pull (Human h, Place p){
        h.setLocation(p);
        this.setLocation(p);
        System.out.printf(this.getName() + " потащила " + h + " в " + p + ". ");
    }

    public String getFaceDescription(){
        return "У " + this.getName()+ " " + this.face.getDescription() + ". ";
    }
}
