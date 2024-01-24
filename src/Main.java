import locations.Place;
import moodings.Moods;
import action.types.Speeches;
import action.types.TypeWalking;
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
                private final String name;
                boolean isHeard = false;

                public Sound(String name) throws NameError {
                    this.name = name;
                    if (name.isEmpty() || name.charAt(0) == ' ')
                        throw new NameError("Название звука на может начинаться с пробела или отсуствовать!");
                }

                public String getName() {
                    return name;
                }

                public void heard() {
                    this.isHeard = true;
                    System.out.printf("Послышался " + this.getName() + ". ");
                }
            }

            buhgalter.setPayStatus(true);
            buhgalter.payUp();
            buhgalter.replace(building, TypeWalking.WALK);
            buhgalter.replace(hall, TypeWalking.Rush);

            chancellery.setCondition("царила какая-то суматоха");
            System.out.printf(chancellery.getCondition());

            courier.setLocation(hall);
            courier.run();
            courier.setAccessories("сбившийся на затылок платочек");
            System.out.printf(courier.getAccessories());
            courier.setMood(Moods.CRAZYNESS);
            System.out.printf(courier.getMood());

            courier.say("Нету, нету, нету, милые мои! Пиджак и штаны тут, а в пиджаке ничего нету!", Speeches.SHOUT);

            courier.replace(unknown_room, TypeWalking.DISAPPEAR);

            Sound breakingDishes = new Sound("битьё посуды");
            breakingDishes.heard();


            zaveduyushiy.runFrom(secretary_room, hall);
            zaveduyushiy.recognition(buhgalter, false);

            zaveduyushiy.setHideStatus("бесследно");
            System.out.printf(zaveduyushiy.hide());


            buhgalter.setMood(Moods.SHOCKED);
            System.out.printf(buhgalter.getMood());

            buhgalter.replace(secretary_room, TypeWalking.WALK);

            buhgalter.setMood(Moods.STUNNED);
            System.out.printf(buhgalter.getMood());


            president.setLocation(chairman_office);
            president.say("...", Speeches.FORMIDABLEVOICE);
            buhgalter.getAccountantBrain().think("Распекает, что ли, кого?");

            buhgalter.setMood(Moods.CONFUSED);
            System.out.printf(buhgalter.getMood());

            buhgalter.lookDirection(180);

            buhgalter.see();

            secretary.lie("кожаное кресло", "вытянув ноги до середины комнаты");
            secretary.setThing("мокрый платок в руке");
            System.out.printf(secretary.getThing());

            secretary.setMood(Moods.CRYING);
            System.out.printf(secretary.getMood());
            System.out.printf(secretary.getFaceDescription());

            secretary.see("кто-то вошёл");

            secretary.standUp();
            secretary.lunge(buhgalter);
            secretary.grab(buhgalter.getClothes());
            secretary.shake(buhgalter);

            secretary.say("Слава богу! Нашелся хоть один храбрый! Все разбежались, все предали! Идемте, идемте к нему, я не знаю, что делать!", Speeches.SHOUT, buhgalter);
            System.out.printf(secretary.getMood());
            secretary.pull(buhgalter, chairman_office);

        } catch (NoClothesError | NameError e) {
            System.out.println(e.getMessage());
        }
    }
}