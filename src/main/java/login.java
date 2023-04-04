import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class login extends Application {

        public void start(Stage login) throws FileNotFoundException {
            login.setTitle("HSLEIDENTALE");

            Button buttonLogin_newgame = new Button("New Game");
            Button buttonLogin_highscore = new Button("Highscore");
            GridPane schermLogin = new GridPane();

            schermLogin.setHgap(5);
            schermLogin.setVgap(5);
            schermLogin.add(buttonLogin_highscore, 0, 3);
            schermLogin.add(buttonLogin_newgame, 0, 2);

            Scene sc = new Scene(schermLogin, 800, 500);

            Image img = new Image("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\HSLEIDENTALE_white.png");
            schermLogin.setStyle("-fx-background-image: " + img);
//            schermLogin.setStyle("-fx-background-color: black;");


            login.setScene(sc);
            login.show();

        }

    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }

}
