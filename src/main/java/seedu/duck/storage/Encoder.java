package seedu.duck.storage;

public class Encoder {
    public static String encode(String username, String password){
        return username +
                "\n" +
                password;
    }
}
