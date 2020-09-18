package seedu.duck.gui;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MusicStage extends Stage{

    public MusicStage() {
        Stage stage = new Stage();
        MediaView bgmView = getBackgroundMusic();
        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().add(bgmView);
        stage.setScene(new Scene(mainLayout));
        stage.show();
    }


    private MediaView getBackgroundMusic() {
        Media backgroundMusic = new Media(getClass().getResource("/music/windbgm1.mp3").toExternalForm());
        MediaPlayer backgroundMusicPlayer = new MediaPlayer(backgroundMusic);
        setBackgroundMusic(backgroundMusicPlayer);
        //***************** loop (repeat) the music  ******************
        backgroundMusicPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                backgroundMusicPlayer.seek(Duration.ZERO);
            }
        });
        return new MediaView(backgroundMusicPlayer);
    }

    private void setBackgroundMusic(MediaPlayer backgroundMusicPlayer) {
        backgroundMusicPlayer.setAutoPlay(true);
        backgroundMusicPlayer.setVolume(0.9);
    }
}
