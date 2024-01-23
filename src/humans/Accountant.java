package humans;

import exception.NoClothesError;

public class Accountant extends Human {
    private boolean payStatus;
    private String direction;

    final Clothes clothes;

    public void setPayStatus(boolean b) {
        this.payStatus = b;
    }

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
        if (payStatus) {
            System.out.printf(this + " расплатился успешно. ");
        } else {
            System.out.printf(this + " расплатился не успешно. ");
        }

    }

    public void lookDirection(String direction) {
        this.direction = direction;
        System.out.printf(this + " посмотрел в направлении " + this.direction + ". ");
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
