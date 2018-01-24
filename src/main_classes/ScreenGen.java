package main_classes;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;

class ScreenGen {

    static ErrorHandler e = new ErrorHandler();

    static Pane getMenu(Group extGroup) {

        Group group = new Group();
        String soundFile = "files/sounds/Half - Life 2 Soundtrack- Intro.mp3";
        Scene menuScene = new Scene(group, 1000, 562, Color.FORESTGREEN);
        GridPane menuPane = new GridPane();
        menuPane.setId("menu-pane");
        menuPane.setStyle("-fx-background-size: 1000 562;");
        menuScene.getStylesheets().add("files/stylesheet.css");
        try {
            Media media = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mp = new MediaPlayer(media);
        } catch (Exception ex) {
            e.exception(ex);
        }
        VBox vb = new VBox();
        vb.setPrefWidth(1000);
        vb.setPrefHeight(562);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);
        /*Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2),
                       new KeyValue(mp.volumeProperty(), 0)));*/
        Button butt = new Button("Play");
        Button butt2 = new Button("test");
        butt.setOnAction((ActionEvent) -> {
            e.explain();
            //      timeline.play();
        });
        butt2.setOnAction((ActionEvent) -> {
            Transition.screenChange(menuPane, getSettingScreen(), extGroup, 1000, 562);
        });
        vb.getChildren().addAll(butt, butt2);


        //  mp.setAutoPlay(true);
        // mp.setCycleCount(MediaPlayer.INDEFINITE);
        //MediaView mv = new MediaView(mp);
        menuPane.getChildren().addAll(vb);
        return menuPane;
    }

    private static Pane getSettingScreen() {
        return new Pane();
    }

}