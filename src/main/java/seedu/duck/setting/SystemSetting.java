package seedu.duck.setting;

import seedu.duck.util.Language;

public class SystemSetting {
    private static Language systemLanguage;

    public static void initialise(){
        systemLanguage = Language.ENGLISH;
    }

    public static Language getSystemLanguage() {
        return systemLanguage;
    }

    public static void setSystemLanguage(Language language) {
        systemLanguage = language;
    }
}
