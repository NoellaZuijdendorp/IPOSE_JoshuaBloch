import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Highscore extends Application {
    @Override
    public void start(Stage highscore) throws FileNotFoundException {
        highscore.setTitle("Highscore");

        GridPane schermHighscore = new GridPane();

        Login highscores = new Login();
        for (String i : highscores.getNames()){
                Label label_highscore = new Label();
                Label label_layout = new Label("------------------------------------");
                label_highscore.setText(i);

                label_highscore.setTranslateX(100);
                label_layout.setTranslateX(100);

                int x_highscore = 150;
                int x_layout = 160;

                for (int m = 0; m < i.length(); m++) {
                    label_highscore.setTranslateY(x_highscore + 10);
                    label_layout.setTranslateY(x_layout + 10);
                }

                schermHighscore.add(label_highscore, 0, 2);
                schermHighscore.add(label_layout, 0, 2);
            }

        Image imageHigscore= new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\highscore.png"));
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

    public static void main(String[] args)
    {
        launch(args);
    }

}
