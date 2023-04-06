import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Login extends Application implements Runnable{

    private static String[] names = new String[]{};


    public void start(Stage login) throws FileNotFoundException {
        login.setTitle("Login");

        Image imageUserName = new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\enterUserName.png"));
        ImageView imageViewUserName = new ImageView(imageUserName);
        imageViewUserName.setFitHeight(90);
        imageViewUserName.setFitWidth(550);

        Label label_userName = new Label();
        label_userName.setGraphic(imageViewUserName);
        label_userName.setTranslateX(20);
        label_userName.setTranslateY(-30);

        Image imageLogin = new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\submit.png"));
        ImageView imageViewLogin = new ImageView(imageLogin);
        imageViewLogin.setFitHeight(90);
        imageViewLogin.setFitWidth(400);

        Button submitButton = new Button();
        submitButton.setGraphic(imageViewLogin);

        submitButton.setStyle("-fx-background-color: black");
        submitButton.setScaleX(0.2);
        submitButton.setScaleY(0.2);

        submitButton.setTranslateX(70);
        submitButton.setTranslateY(80);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        usernameField.setTranslateX(20);
        usernameField.setTranslateY(20);

        GridPane schermLogin = new GridPane();

        schermLogin.setVgap(5);
        schermLogin.setHgap(5);
        schermLogin.setAlignment(Pos.CENTER);

        schermLogin.add(usernameField, 0, 2);
        schermLogin.add(submitButton, 0, 2);
        schermLogin.add(label_userName, 0, 2);

        schermLogin.setStyle("-fx-background-color: black");


        Scene scLogin = new Scene(schermLogin, 800, 500);

        login.setScene(scLogin);
        login.show();

        EventHandler<MouseEvent> eventHandlerEnterUserName =
                new EventHandler<MouseEvent>() {
                    ArrayList<String> names = new ArrayList<>();
                    @Override
                    public void handle(MouseEvent e) {
                        System.out.println("Knop submit gedrukt");
                        names.add(usernameField.getText());
                        for (String i : names){
                            System.out.println(i);
                        }
                        usernameField.clear();
                        Game game = new Game();
                        game.run();
                    }
                };

        submitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerEnterUserName);
    }

//    public static void main(String[] args)
//    {
//        launch(args);
//    }

    public static String[] getNames() {
        return names;
    }

    @Override
    public void run() {
        Platform.runLater(this);
    }
}
