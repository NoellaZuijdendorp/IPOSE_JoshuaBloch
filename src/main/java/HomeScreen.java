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

public class HomeScreen extends Application {

        public void start(Stage homeScreen) throws FileNotFoundException {
            homeScreen.setTitle("HSLEIDENTALE");

            ///Button New Game
            Image imageNewGame = new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\newGame.png"));
            ImageView imageViewNewGame = new ImageView(imageNewGame);
            imageViewNewGame.setFitHeight(100);
            imageViewNewGame.setFitWidth(600);

            Button buttonHomeScreen_newgame = new Button();
            buttonHomeScreen_newgame.setGraphic(imageViewNewGame);
            buttonHomeScreen_newgame.setStyle("-fx-background-color: black");
            buttonHomeScreen_newgame.setScaleX(0.2);
            buttonHomeScreen_newgame.setScaleY(0.2);

            buttonHomeScreen_newgame.setTranslateX(200);
            buttonHomeScreen_newgame.setTranslateY(150);

                ///Event newGame handler
            EventHandler<MouseEvent> eventHandlerNewGame =
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            System.out.println("Knop newGame gedrukt");
                            //launch pagina NewGame
                        }
                    };
            buttonHomeScreen_newgame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerNewGame);

            ///Button Highscore
            Image imageHigscore= new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\highscore.png"));
            ImageView imageViewHighscore = new ImageView(imageHigscore);
            imageViewHighscore.setFitHeight(100);
            imageViewHighscore.setFitWidth(600);

            Button buttonHomeScreen_highscore = new Button();
            buttonHomeScreen_highscore.setGraphic(imageViewHighscore);
            buttonHomeScreen_highscore.setStyle("-fx-background-color: black");
            buttonHomeScreen_highscore.setScaleX(0.2);
            buttonHomeScreen_highscore.setScaleY(0.2);

            buttonHomeScreen_highscore.setTranslateX(20);
            buttonHomeScreen_highscore.setTranslateY(150);

                ///button highscore event handler
            EventHandler<MouseEvent> eventHandlerHighscore =
                    new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    System.out.println("Knop highscore gedrukt");
                    //launch pagina highscore
                }
            };
            buttonHomeScreen_highscore.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerHighscore);

            ///Scherm
            GridPane schermHomeScreen = new GridPane();

            schermHomeScreen.setHgap(3);
            schermHomeScreen.setVgap(5);
            schermHomeScreen.setStyle("-fx-background-color: black;");

            schermHomeScreen.getChildren().add(buttonHomeScreen_highscore);
            schermHomeScreen.getChildren().add(buttonHomeScreen_newgame);

            ///Image HSLEIDENTALE
            Image image = new Image(new FileInputStream("C:\\Users\\nozu2\\OneDrive - Hogeschool Leiden\\Leerjaar 1\\Periode 3\\IPOSE\\HSLEIDENTALE_white.png"));
            ImageView imageView = new ImageView(image);

            imageView.setTranslateX(170);
            imageView.setTranslateY(350);
            imageView.setFitHeight(455);
            imageView.setFitWidth(500);
            schermHomeScreen.getChildren().add(imageView);

            imageView.setPreserveRatio(true);

            Scene sc = new Scene(schermHomeScreen, 800, 500);

            homeScreen.setScene(sc);
            homeScreen.show();

        }


    public static void main(String[] args)
    {
        launch(args);
    }

}
