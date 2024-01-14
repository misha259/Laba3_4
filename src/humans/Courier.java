package humans;

public class Courier extends Human {
    private String accessories;

    public Courier(String name) {
        super(name);
    }

    public void setAccessories(String a) {
        this.accessories = a;
    }

    public String getAccessories() {
        return accessories;
    }
}
