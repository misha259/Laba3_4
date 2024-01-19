package actionsTypes;

public enum Speeches
{
    Shout("кричал"),
    FormidableVoice("доносился грозный голос");
    private final String type;

    Speeches(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
