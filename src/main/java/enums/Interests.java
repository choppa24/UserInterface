package enums;

public enum Interests {
    UNSELECT_ALL("Unselect all"),
    PONIES("Ponies"),
    POLO("Polo"),
    DOUGH("Dough");

    private final String type;

    Interests(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
