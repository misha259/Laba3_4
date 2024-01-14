package actionsTypes;

public enum Speeches
{
    Shout("кричала"),
    Formidable_voice("доносился грозный голос");
    private final String type;

    Speeches(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
