import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Highscore extends Application implements Runnable {
    @Override
    public void start(Stage highscore) throws FileNotFoundException {
        highscore.setTitle("Highscore");

        GridPane schermHighscore = new GridPane();
        Pane pane = new Pane();

        Text text = new Text("--------------------------------------------------------------------------");


        text.setTranslateY(60);
        text.setTranslateX(210);

        String filename = "Leaderbord.txt";
        for (int i =0; i < filename.length(); i++){
            Text names = new Text(filename.indent(i));
            pane.getChildren().add(names);
            schermHighscore.add(names, 0, 2);
            names.setFill(Color.WHITE);
            names.setTranslateX(210);
//
//            for(int m = 0; m < i; i++){
//                names.setTranslateY(i + 70);
//            }
        }

        pane.getChildren().add(text);

        schermHighscore.add(text, 0, 2);
        text.setFill(Color.WHITE);


        Image imageHigscore= new Image(new FileInputStream("target\\classes\\assets\\textures\\highscore.png"));
        ImageView imageViewHighscore = new ImageView(imageHigscore);
        imageViewHighscore.setFitHeight(100);
        imageViewHighscore.setFitWidth(600);

        Label label_highscore_image = new Label();

        label_highscore_image.setGraphic(imageViewHighscore);
        label_highscore_image.setStyle("-fx-background-color: black");
        label_highscore_image.setTranslateX(100);
        label_highscore_image.setTranslateY(10);


        schermHighscore.setStyle("-fx-background-color: black");
        schermHighscore.add(label_highscore_image, 0, 2);

        Scene scLogin = new Scene(schermHighscore, 800, 500);
        highscore.setScene(scLogin);
        highscore.show();
    }

    @Override
    public void run() {

        Platform.runLater(this);
    }

}