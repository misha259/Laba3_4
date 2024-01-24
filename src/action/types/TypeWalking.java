package action.types;

public enum TypeWalking {
    WALK("вошёл"),
    DISAPPEAR("скрылся за дверью"),
    Rush("устремился");
    private final String name;

    TypeWalking(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
