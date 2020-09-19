package seedu.duck.setting;

import static seedu.duck.util.Constant.DEFAULT_SYSTEM_LANGUAGE;

public class SystemSetting {
    private static String systemLanguage;


    public static void initialise(){
        systemLanguage = DEFAULT_SYSTEM_LANGUAGE;
    }

    public static String getSystemLanguage() {
        return systemLanguage;
    }

    public static void setSystemLanguage(String language) {
        systemLanguage = language;
    }
}
