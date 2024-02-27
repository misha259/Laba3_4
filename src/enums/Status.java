package enums;

public enum Status {
    NORMAL("обычный"),
    SHOCKED("в шоке"),
    CRAZY("не в себе"),
    CONFUSED("смятенный"),
    CRYING("рыдала"),
    SHAKING("трясущийся");
    private final String description;
    Status(String description){
         this.description = description;
    }
    @Override
    public String toString(){
        return description;
    }
}
