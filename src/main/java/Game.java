import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.ui.UI;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import com.almasb.fxgl.core.asset.AssetLoaderService;
import java.awt.*;
import java.util.Map;

public class Game extends GameApplication {
    private Entity player;

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(800);
        gameSettings.setTitle("HSLEIDENTALE");
        gameSettings.setVersion("1.0");

    }

    @Override
    protected void initGame(){
        player = FXGL.entityBuilder()
                .at(400,400)
                .viewWithBBox("Untitled.png")
                .scale(0.05, 0.05)
                .with(new CollidableComponent(true))
                .type(EntityTypes.PLAYER)
                .buildAndAttach();

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
        grid = AStarGrid
        Node node = FXGL.getAssetLoader().loadTexture("whiteRectangle.png");

        Entity whiteRectangle = FXGL.entityBuilder()
                .view("whiteRectangle.png")
                .scale(1.5, 1.5)
                .at(200,450)

                .build();


        FXGL.getGameScene().setBackgroundColor(Color.DARKGREY);
<<<<<<< Updated upstream
        Node node = FXGL.getAssetLoader().loadTexture("Untitled.png");
        Entity entity = FXGL.entityBuilder()
                .view("Untitled.png")
                .build();
=======
        FXGL.getGameWorld().addEntity(whiteRectangle);

>>>>>>> Stashed changes

     }

     protected void initGameVars(Map<String, Object> vars){
//        vars.put();
     }

    public static void main(String[] args){
        launch(args);
    }
}
