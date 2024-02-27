package humans;

import enums.Status;
import interfaces.CreateSound;
import things.Chair;
import things.Clothes;
import things.Platok;
import things.Sound;

public class Secretary extends Human implements CreateSound {
    private final Face face;
    private final Hand hand;
    public Secretary() {
        this.face = new Face();
        this.hand = new Hand();
    }
    private class Face{
        private String description;
        public void setDescription(String description){
            this.description = description;
        }
    }
    private class Hand{
        private final Platok platok;
        public Hand(){
            this.platok = new Platok();
        }
        public void grabClothes(Clothes clothes){
            clothes.setCaught(true);
            System.out.printf("%s вцепилась в лацканы пиджака.%n", Secretary.this);
        }
    }
    public void sit(Chair chair){
        chair.setSecretary(this);
        System.out.printf("%s сидела на %s.%n", this, chair);
    }
    public void cry(){
        setStatus(Status.CRYING);
        hand.platok.getWet();
        face.setDescription("весь подбородок был вымазан губной помадой, по персиковым щекам ползли с ресниц потоки раскисшей краски");
        System.out.printf("%s %s. В руках был %s. Лицо было таким: %s.%n", this, getStatus(), hand.platok, face.description);
    }
    public void see(Accountant accountant){
        hand.grabClothes(accountant.getClothes());
        shake(accountant);
        System.out.printf("%s закричала: %s", this, createSound());
    }
    public Sound createSound(){
        return new Sound("Слава богу! Нашелся хоть один храбрый! Все разбежались, все предали! Идемте, идемте к нему, я не знаю, что делать!");
    }
    public void shake(Accountant accountant){
        if(accountant.getClothes().getCaught()) {
            accountant.setStatus(Status.SHAKING);
            System.out.printf("%s стала трясти %s.%n", this, accountant);
        }
    }
    @Override
    public String toString(){
        return "Анна Ричардовна";
    }
}
