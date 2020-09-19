package seedu.duck.setting;

import seedu.duck.util.Language;

public class SystemSetting {
    private static Language systemLanguage;

    /**
     * Initialises the system setting
     * Currently only the language is implemented
     * Sets the system language to English
     */
    public static void initialise(){
        systemLanguage = Language.ENGLISH;
    }

    /**
     * Returns the current system language
     * @return the current system language
     */
    public static Language getSystemLanguage() {
        return systemLanguage;
    }

    /**
     * Sets the system language to a specific language
     * @param language a specific language
     */
    public static void setSystemLanguage(Language language) {
        systemLanguage = language;
    }
}
