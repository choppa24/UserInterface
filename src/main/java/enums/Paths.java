package enums;

public enum Paths {
    RESOURCES("src/main/resources/");

    private final String type;

    Paths(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
