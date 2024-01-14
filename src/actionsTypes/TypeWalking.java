package actionsTypes;

public enum TypeWalking
{
    Walk("вошёл"),
    Rush("устремился"),
    Run("пробежал");
    private final String name;

    TypeWalking(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
