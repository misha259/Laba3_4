package humans;

import exception.NoClothesError;

public class Accountant extends Human {
    private boolean payStatus;
    private int direction; //without direction lookDirection is just text
    private final Brain accountantBrain;
    final Clothes clothes;

    public void setPayStatus(boolean b) {
        this.payStatus = b;
    }

    public Accountant(String name, String startClothes) throws NoClothesError {
        super(name);
        accountantBrain = new Brain();
        if (startClothes.isEmpty())
            throw new NoClothesError(this, " не может быть создан без одежды");
        else {
            clothes = new Clothes();
            clothes.setClothes(startClothes);
        }
    }
    public Brain getAccountantBrain() {
        return accountantBrain;
    }
    public void payUp() {
        if (payStatus) {
            System.out.printf(this + " расплатился успешно. ");
        } else {
            System.out.printf(this + " расплатился не успешно. ");
        }

    }

    public void lookDirection(int direction) {
        this.direction = direction;
        System.out.printf(this + " посмотрел в направлении " + this.direction + " градусов. ");
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
