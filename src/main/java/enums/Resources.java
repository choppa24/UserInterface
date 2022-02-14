package enums;

public enum Resources {
    CONFIG("config.properties"),
    TEST("test.properties");

    private final String type;

    Resources(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}