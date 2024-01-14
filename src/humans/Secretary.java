package humans;

import Locations.Place;

public class Secretary extends Human{

    final Face face;

    public Secretary(String name) {
        super(name);
        face = new Face();
        face.setDescription("Весь подбородок был вымазан губной помадой", "по персиковым щекам ползли с ресниц потоки раскисшей краски");
    }

    public static class Face {
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
        System.out.println(this.getName() + " кинулся к " + h.getName());
    }
    public void grab(String clothes){
        System.out.println(this.getName() + " вцепилась в " + clothes);
    }
    public void shake(Human h){
        h.shake_status = true;
        System.out.println(this.getName() + " потрясла " + h.getName());
    }
    public void pull (Human h, Place p){
        h.setLocation(p);
        setLocation(p);
    }
}
