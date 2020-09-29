package seedu.duck.setting;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import seedu.duck.gui.MainStage;
import seedu.duck.storage.IOManager;
import seedu.duck.util.Language;

import java.io.IOException;

import static seedu.duck.util.Constant.DEFAULT_PASSWORD;
import static seedu.duck.util.Constant.DEFAULT_SYSTEM_MUSIC;
import static seedu.duck.util.Constant.DEFAULT_USERNAME;

public class SystemSetting {
    private static Language systemLanguage;
    private static MediaView backgroundMusicView;
    private static boolean isDuplicatedAllowed;
    private static String username;
    private static String password;

    /**
     * Initialises the system setting
     * Currently only the language is implemented
     * Sets the system language to English
     */
    public static void initialise(){
        systemLanguage = Language.ENGLISH;
        isDuplicatedAllowed = true;
        setBackgroundMediaView(DEFAULT_SYSTEM_MUSIC, 0.1, true);
        MainStage.setBgmView(backgroundMusicView);
        try {
            IOManager.loadUserInfo();
        } catch (IOException ioe){
            SystemSetting.setUsername(DEFAULT_USERNAME);
            SystemSetting.setPassword(DEFAULT_PASSWORD);
        }
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

    /**
     * Returns the background music generated
     *
     * @return background music generated
     */
    public static void setBackgroundMediaView(String bgm, double volume, boolean autoplay) {
        Media backgroundMusic = new Media(MainStage.class.getResource(bgm).toExternalForm());
        MediaPlayer backgroundMusicPlayer = new MediaPlayer(backgroundMusic);
        setBackgroundMusic(backgroundMusicPlayer, volume, autoplay);
        //***************** loop (repeat) the music  ******************
        backgroundMusicPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                backgroundMusicPlayer.seek(Duration.ZERO);
            }
        });
        backgroundMusicView = new MediaView(backgroundMusicPlayer);
        MainStage.setBgmView(backgroundMusicView);
    }

    /**
     * Sets the property of the background music
     * @param backgroundMusicPlayer the background music
     */
    private static void setBackgroundMusic(MediaPlayer backgroundMusicPlayer, double volume, boolean autoplay) {
        backgroundMusicPlayer.setAutoPlay(autoplay);
        backgroundMusicPlayer.setVolume(volume);
    }

    public static MediaView getBackgroundMusicView() {
        return backgroundMusicView;
    }

    public static boolean isDuplicatedAllowed() {
        return !isDuplicatedAllowed;
    }

    public static void setIsDuplicatedAllowed(boolean duplicatedIsAllowed) {
        SystemSetting.isDuplicatedAllowed = duplicatedIsAllowed;
    }

    public static String getBackgroundMusicViewInString() {
        return DEFAULT_SYSTEM_MUSIC;
    }

    public static String getIsDuplicatedTaskAllowedInString() {
        if (isDuplicatedAllowed){
            return "Allowed";
        } else {
            return "Not Allowed";
        }
    }

    public static String getSystemLanguageInString() {
        if (systemLanguage == Language.ENGLISH){
            return "English";
        } else {
            return "Chinese";
        }
    }

    public static String getBackgroundMusicViewInStringInChinese() {
        return DEFAULT_SYSTEM_MUSIC;
    }

    public static String getIsDuplicatedTaskAllowedInStringInChinese() {
        if (isDuplicatedAllowed){
            return "允许";
        } else {
            return "不允许";
        }
    }

    public static String getSystemLanguageInStringInChinese() {
        if (systemLanguage == Language.ENGLISH){
            return "英文";
        } else {
            return "中文";
        }
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setUsername(String username) {
        SystemSetting.username = username;
    }

    public static void setPassword(String password) {
        SystemSetting.password = password;
    }
}
