package moodings;

public enum Moods {
    SHOCKED("потрясенный"),
    STUNNED("пораженный"),
    CONFUSED("смятенный"),
    CRYING("плачущий"),
    NEUTRAL("нейтральное"),
    STARINGEYES("вытаращенные глаза");
    private final String mood;

    Moods(String mood) {
        this.mood = mood;
    }

    public String getName() {
        return mood;
    }
}
