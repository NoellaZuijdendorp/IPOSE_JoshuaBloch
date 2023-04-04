import com.almasb.fxgl.dsl.FXGL;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class login extends Application {

        public void start(Stage login) throws FileNotFoundException {
            FileInputStream inputstream = new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\HSLEIDENTALE.png");
            Image image = new Image(inputstream);
            login.setTitle("HSLEIDENTALE");

            Button buttonLogin = new Button("New Game");
            StackPane schermLogin = new StackPane();

            schermLogin.getChildren().add(buttonLogin);
            Scene sc = new Scene(schermLogin, 200, 200);

            login.setScene(sc);
            login.show();

        }

        public static void main(String args[])
        {
            // launch the application
            launch(args);
        }
    }
