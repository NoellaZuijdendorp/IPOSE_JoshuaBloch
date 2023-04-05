import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class login extends Application {

        public void start(Stage login) throws FileNotFoundException {
            login.setTitle("HSLEIDENTALE");

            ///Button New Game
            Image imageNewGame = new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\newGame.png"));
            ImageView imageViewNewGame = new ImageView(imageNewGame);
            imageViewNewGame.setFitHeight(100);
            imageViewNewGame.setFitWidth(600);

            Button buttonLogin_newgame = new Button();
            buttonLogin_newgame.setGraphic(imageViewNewGame);
            buttonLogin_newgame.setStyle("-fx-background-color: black");
            buttonLogin_newgame.setScaleX(0.2);
            buttonLogin_newgame.setScaleY(0.2);

            buttonLogin_newgame.setTranslateX(200);
            buttonLogin_newgame.setTranslateY(150);

                ///Event newGame handler
            EventHandler<MouseEvent> eventHandlerNewGame =
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            System.out.println("Knop newGame gedrukt");
                            //launch pagina NewGame
                        }
                    };
            buttonLogin_newgame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerNewGame);

            ///Button Highscore
            Image imageHigscore= new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\highscore.png"));
            ImageView imageViewHighscore = new ImageView(imageHigscore);
            imageViewHighscore.setFitHeight(100);
            imageViewHighscore.setFitWidth(600);

            Button buttonLogin_highscore = new Button();
            buttonLogin_highscore.setGraphic(imageViewHighscore);
            buttonLogin_highscore.setStyle("-fx-background-color: black");
            buttonLogin_highscore.setScaleX(0.2);
            buttonLogin_highscore.setScaleY(0.2);

            buttonLogin_highscore.setTranslateX(20);
            buttonLogin_highscore.setTranslateY(150);

                ///button highscore event handler
            EventHandler<MouseEvent> eventHandlerHighscore =
                    new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    System.out.println("Knop highscore gedrukt");
                    //launch pagina highscore
                }
            };
            buttonLogin_highscore.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerHighscore);

            ///Scherm
            GridPane schermLogin = new GridPane();

            schermLogin.setHgap(3);
            schermLogin.setVgap(5);
            schermLogin.setStyle("-fx-background-color: black;");

            schermLogin.getChildren().add(buttonLogin_highscore);
            schermLogin.getChildren().add(buttonLogin_newgame);

            ///Image HSLEIDENTALE
            Image image = new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\HSLEIDENTALE_white.png"));
            ImageView imageView = new ImageView(image);

            imageView.setTranslateX(170);
            imageView.setTranslateY(350);
            imageView.setFitHeight(455);
            imageView.setFitWidth(500);
            schermLogin.getChildren().add(imageView);

            imageView.setPreserveRatio(true);

            Scene sc = new Scene(schermLogin, 800, 500);

            login.setScene(sc);
            login.show();

        }


    public static void main(String[] args)
    {
        launch(args);
    }

}
