import Locations.Place;
import Moodings.Moods;
import actionsTypes.Speeches;
import actionsTypes.TypeWalking;
import exception.NameError;
import exception.NoClothesError;
import humans.*;
import humans.Secretary.Face;

public class Main {
    public static void main(String[] args) {
        try {
            Secretary secretary = new Secretary("Анна Ричардовна");
            Accountant buhgalter = new Accountant("Прохор Петрович", "пиджак");
            Courier courier = new Courier("курьерша");
            Manager zaveduyushiy = new Manager("заведующий первым сектором комиссии");
            President president = new President("председатель комиссии");

            Place building = new Place("здание");
            Place hall = new Place("коридор");
            Place chancellery = new Place("канцелярия");
            Place door = new Place("дверь");
            Place Secretary_room = new Place("секретарская");
            Place Chairman_office = new Place("кабинет председателя комиссии");


            buhgalter.payUp();
            buhgalter.replace(building, TypeWalking.Walk);
            buhgalter.replace(hall, TypeWalking.Rush);

            chancellery.setCondition("царила какая-то суматоха");
            System.out.println(chancellery.getCondition());

            courier.replace(door, TypeWalking.Run);

            courier.say("Нету, нету, нету, милые мои! Пиджак и штаны тут, а в пиджаке ничего нету!", Speeches.Shout);
            //сделать звук битья посуды
            zaveduyushiy.runFrom(zaveduyushiy, Secretary_room);
            zaveduyushiy.recognition(courier, false);
            zaveduyushiy.hide("бесследно");
            buhgalter.setMood(Moods.Shocked);
            buhgalter.replace(Secretary_room,TypeWalking.Walk);
            president.setLocation(Chairman_office);
            president.say("...", Speeches.Formidable_voice);
            buhgalter.think("Распекает, что ли, кого?");
            buhgalter.lookDirection("назад");
            //описание комнаты
            secretary.setMood(Moods.Crying);
            Face face = new Face();
            System.out.println(face.getDescription()); // починить вывод описания лица (оно сохраняет описание но выводит null вместо него
            secretary.see(buhgalter);
            secretary.lunge(buhgalter);
            secretary.grab(buhgalter.getClothes());
            secretary.shake(buhgalter);
            secretary.say("Слава богу! Нашелся хоть один храбрый! Все разбежались, все предали! Идемте, идемте к нему, я не знаю, что делать!", Speeches.Shout, buhgalter);
            System.out.println(secretary.getMood());
            secretary.pull(buhgalter, Chairman_office);



        }
        catch (NoClothesError | NameError e){
            System.out.println(e.getMessage());
        }
    }
}