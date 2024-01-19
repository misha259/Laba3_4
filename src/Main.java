import locations.Place;
import moodings.Moods;
import actionsTypes.Speeches;
import actionsTypes.TypeWalking;
import exception.NameError;
import exception.NoClothesError;
import humans.*;

public class Main {
    public static void main(String[] args) {
        try {
            Secretary secretary = new Secretary("Анна Ричардовна");
            Accountant buhgalter = new Accountant("Бухгалтер", "пиджак");
            Courier courier = new Courier("Курьерша");
            Manager zaveduyushiy = new Manager("Заведующий первым сектором комиссии");
            President president = new President("Председатель комиссии Прохор Петрович");

            Place building = new Place("здание");
            Place hall = new Place("коридор");
            Place chancellery = new Place("канцелярия");
            Place secretary_room = new Place("секретарская");
            Place chairman_office = new Place("кабинет председателя комиссии");
            Place unknown_room = new Place("неизвестная комната");
            class Sound {
                private String name;

                private boolean isHeard = false;
                public Sound(String name) throws NameError {
                    this.name = name;
                    if(name.isEmpty() || name.charAt(0) == ' ')
                        throw new NameError("Название звука на может начинаться с пробела или отсуствовать!");
                }
                public String getName() {
                    return name;
                }
                public void heard(){
                    this.isHeard = true;
                    System.out.printf("Послышался " + this + ". ");
                }
            }

            buhgalter.payUp();
            buhgalter.replace(building, TypeWalking.Walk);
            buhgalter.replace(hall, TypeWalking.Rush);

            chancellery.setCondition("царила какая-то суматоха");
            System.out.printf(chancellery.getCondition());

            courier.setLocation(hall);
            courier.run();
            courier.setAccessories("сбившийся на затылок платочек");
            System.out.printf(courier.getAccessories());
            courier.setMood(Moods.StaringEyes);
            System.out.printf(courier.getMood());

            courier.say("Нету, нету, нету, милые мои! Пиджак и штаны тут, а в пиджаке ничего нету!", Speeches.Shout);

            courier.replace(unknown_room, TypeWalking.Disappear);

            Sound breakingDishes = new Sound("битьё посуды");
            breakingDishes.heard();

            zaveduyushiy.runFrom(secretary_room, hall);
            zaveduyushiy.recognition(buhgalter, false);

            zaveduyushiy.setHideStatus("бесследно");
            System.out.printf(zaveduyushiy.hide());


            buhgalter.setMood(Moods.Shocked);
            System.out.printf(buhgalter.getMood());

            buhgalter.replace(secretary_room,TypeWalking.Walk);

            buhgalter.setMood(Moods.Stunned);
            System.out.printf(buhgalter.getMood());


            president.setLocation(chairman_office);
            president.say("...", Speeches.FormidableVoice);
            buhgalter.think("Распекает, что ли, кого?");

            buhgalter.setMood(Moods.Confused);
            System.out.printf(buhgalter.getMood());

            buhgalter.lookDirection("назад");

            buhgalter.see();

            secretary.lie("кожаное кресло", "вытянув ноги до середины комнаты");
            secretary.setThing("мокрый платок в руке");
            System.out.printf(secretary.getThing());

            secretary.setMood(Moods.Crying);
            System.out.printf(secretary.getMood());
            System.out.printf(secretary.getFaceDescription());

            secretary.see("кто-то вошёл");

            secretary.standUp();
            secretary.lunge(buhgalter);
            secretary.grab(buhgalter.getClothes());
            secretary.shake(buhgalter);

            secretary.say("Слава богу! Нашелся хоть один храбрый! Все разбежались, все предали! Идемте, идемте к нему, я не знаю, что делать!", Speeches.Shout, buhgalter);
            System.out.printf(secretary.getMood());
            secretary.pull(buhgalter, chairman_office);

        }
        catch (NoClothesError | NameError e){
            System.out.println(e.getMessage());
        }
    }
}