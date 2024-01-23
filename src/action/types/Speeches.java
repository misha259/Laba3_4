package action.types;

public enum Speeches
{
    SHOUT("кричал"),
    FORMIDABLEVOICE("доносился грозный голос");
    private final String type;

    Speeches(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
