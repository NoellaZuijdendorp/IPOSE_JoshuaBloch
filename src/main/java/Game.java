import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import java.util.Map;

public class Game extends GameApplication {
    private final int gameWidth = 800;
    private final int gameHeight = 800;
    private final String gameTitle = "HSLEIDENTALE";
    private final String gameVersion = "1.0";
    private Entity player;
    private Player playerCreator = new Player(3, 0.25, 0.25);
    private Entity boss;
    private Boss bossCreator;

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(gameWidth);
        gameSettings.setHeight(gameHeight);
        gameSettings.setTitle(gameTitle);
        gameSettings.setVersion(gameVersion);
    }

    @Override
    protected void initGame(){
        player = playerCreator.createEntity();

        bossCreator = new Boss(0.75, 0.75);
        boss = bossCreator.createEntity();
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
        //TESTING PYPRPOSES
        //TODO: HAAL WEG
        FXGL.onKey(KeyCode.F,() -> {
            System.out.println(playerCreator.getHP().getCurrentHP());
        });
    }

     @Override
     protected void initPhysics(){
        FXGL.getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityTypes.PLAYER, EntityTypes.BOSS) {
            @Override
            protected void onCollision(Entity player, Entity bossProjectile) {
                FXGL.inc("hp", playerCreator.getsDamaged());
                playerCreator.getHP().death(player);
            }
        });
     }

     @Override
     protected void initUI() {
        FXGL.getGameScene().setBackgroundColor(Color.DARKGREY);
        javafx.scene.control.Label textje = new Label("health ding: ");
        textje.setTranslateX(200);
        textje.setTranslateY(200);
        FXGL.getGameScene().addUINode(textje);
        textje.textProperty().bind(FXGL.getWorldProperties().intProperty("hp").asString());
     }

     protected void initGameVars(Map<String, Object> vars){
        vars.put("hp", playerCreator.getHP().getCurrentHP());
     }

    public static void main(String[] args){
        launch(args);
    }
}
