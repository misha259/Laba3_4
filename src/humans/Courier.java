package humans;

public class Courier extends Human {
    private String accessories;

    public Courier(String name) {
        super(name);
    }

    public void setAccessories(String accessory) {
        this.accessories = accessory;
    }

    public String getAccessories() {
        return this + " имел " + accessories + ". ";
    }

    public void run() {
        System.out.printf(this + " бежит по локации " + this.getLocation() + ". ");
    }
}
