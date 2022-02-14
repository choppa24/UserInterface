package utils;

public class RandomUtility {
    private final static int POSITION = 97;
    private final static int NUMBER_OF_LETTERS = 26;
    private final static String PASSWORD = "1W";


    public static String getRandomString(int length){
        LoggerUtility.info("Random string generation, length: " + length);
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < length; i++){
            s.append(String.valueOf((char)((int) ( POSITION + Math.random()*NUMBER_OF_LETTERS))));
        }
        return  s.toString();
    }
    public static String getRandomPassword(int length){
        LoggerUtility.info("Random password generation, length: " + length);
        StringBuilder s = new StringBuilder(PASSWORD);
        for (int i = 0; i < length; i++){
            s.append(String.valueOf((char)((int) ( POSITION + Math.random()*NUMBER_OF_LETTERS))));
        }
        return  s.toString();
    }

    public static int getRandomInt(int maxValue){
        LoggerUtility.info("Random number generation");
        return  (int) (Math.random()*maxValue);
    }
}
