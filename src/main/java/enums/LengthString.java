package enums;

public enum LengthString {
    LEN_5(5),
    LEN_15(15);

    private final int length;

    LengthString(int length){
        this.length = length;
    }

    public int toInteger(){
        return length;
    }

}
