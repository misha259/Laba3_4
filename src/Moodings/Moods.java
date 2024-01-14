package Moodings;

public enum Moods
{
    Shocked("потрясенный"),
    Stunned("пораженный"),
    Confused("смятенный"),
    Crying("плачущий"),
    Neutral("нейтральное"),
    Staring_eyes("вытаращенные глаза");
    private final String mood;

    Moods(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}
