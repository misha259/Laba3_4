package humans;

import exception.NoClothesError;

public class Accountant extends Human {
    private boolean pay_status;
    String direction;

    final Clothes clothes;

    public Accountant(String name, String startClothes) throws NoClothesError {
        super(name);
        if (startClothes.isEmpty())
            throw new NoClothesError(this, " не может быть создан без одежды");
        else {
            clothes = new Clothes();
            clothes.setClothes(startClothes);
        }
    }

    public void payUp() {
        pay_status = true;
        if (pay_status) {
            System.out.println(this.getName() + " расплатился успешно");
        } else {
            System.out.println(this.getName() + " расплатился не успешно");
        }

    }

    public void think(String about) {

    }

    public void lookDirection(String direction) {
        this.direction = direction;
    }

    private static class Clothes {
        String clothes;

        public void setClothes(String clothes) {
            this.clothes = clothes;
        }

        public String getClothes() {
            return clothes;
        }

    }

    public String getClothes() {
        return clothes.getClothes();
    }

}
