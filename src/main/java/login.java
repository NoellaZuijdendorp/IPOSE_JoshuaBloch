import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class login extends Application {

        public void start(Stage login)
        {
            login.setTitle("HSLEIDENTALE");

            Button button = new Button("button");

            StackPane scherm = new StackPane();

            scherm.getChildren().add(button);

            Scene sc = new Scene(button, 200, 200);

            // set the scene
            login.setScene(sc);

            login.show();
        }

        public static void main(String args[])
        {
            // launch the application
            launch(args);
        }
    }
