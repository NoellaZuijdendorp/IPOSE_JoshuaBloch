import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.CollisionHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.Map;

public class Game extends GameApplication {
    private final int gameWidth = 800;
    private final int gameHeight = 800;
    private final String gameTitle = "HSLEIDENTALE";
    private final String gameVersion = "1.0";
    private Entity player;
    private Player playerCreator;

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(gameWidth);
        gameSettings.setHeight(gameHeight);
        gameSettings.setTitle(gameTitle);
        gameSettings.setVersion(gameVersion);
    }

    @Override
    protected void initGame(){
        playerCreator = new Player(100, 0.25, 0.25);
        player = playerCreator.createPlayer();

        FXGL.entityBuilder()
                .at(200, 200)
                .viewWithBBox(new Circle(5, Color.BLACK))
                .with(new CollidableComponent(true))
                .type(EntityTypes.STAR)
                .buildAndAttach();
    }

    @Override
    protected void initInput(){
        FXGL.onKey(KeyCode.D,() -> {
            player.translateX(5);
        });
        FXGL.onKey(KeyCode.A,() -> {
            player.translateX(-5);
        });
        FXGL.onKey(KeyCode.W,() -> {
            player.translateY(-5);
        });
        FXGL.onKey(KeyCode.S,() -> {
            player.translateY(5);
        });
    }

     @Override
     protected void initPhysics(){
        FXGL.getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityTypes.PLAYER, EntityTypes.STAR) {
            @Override
            protected void onCollision(Entity player, Entity star) {
                star.removeFromWorld();
            }
        });
     }

     @Override
     protected void initUI() {
        FXGL.getGameScene().setBackgroundColor(Color.DARKGREY);
     }

     protected void initGameVars(Map<String, Object> vars){
//        vars.put();
     }

    public static void main(String[] args){
        launch(args);
    }
}
