import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class Game extends GameApplication implements Runnable{
    private final int gameWidth = 800;
    private final int gameHeight = 800;
    private final String gameTitle = "HSLEIDENTALE";
    private final String gameVersion = "1.0";
    private MediaPlayer mediaPlayer;
    private Entity player;
    private Player playerCreator = new Player(3, 0.25, 0.25);
    private Entity boss;
    private Boss bossCreator;
    private Entity testProjectile;
    private Projectile testProjectileCreator;

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(gameWidth);
        gameSettings.setHeight(gameHeight);
        gameSettings.setTitle(gameTitle);
        gameSettings.setVersion(gameVersion);
    }

    @Override
    protected void initGame(){
        getGameWorld().addEntityFactory(new GameFactory());
        player = null;
        spawn("background");
        testProjectileCreator = new Projectile(1, 1, 1, 2, 2);
        testProjectile = testProjectileCreator.createEntity();


        FXGL.getGameTimer().runAtInterval(() -> {
            int randomPos = ThreadLocalRandom.current().nextInt(80, FXGL.getGameScene().getAppWidth() - 80);
            FXGL.entityBuilder()
                    .at(randomPos, 0-800)
                    .viewWithBBox("img.png")
                    .with(new CollidableComponent(true))
                    .with(new ProjectileComponent(new Point2D(0,1), 400).allowRotation(false))
                    .collidable()
                    .type(EntityTypes.PROJECTILE)
                    .buildAndAttach();
        }, Duration.millis(100));


        player = playerCreator.createEntity();

        bossCreator = new Boss(0.75, 0.75);
        boss = bossCreator.createEntity();
    }

    private void setLevel(int levelNum){
        if (player!=null){
            player.getComponent(PhysicsComponent.class).overwritePosition(new Point2D(50,50));
            player.setZIndex(Integer.MAX_VALUE);
        }

    }
    @Override
    protected void initInput(){
        FXGL.onKey(KeyCode.D,() -> {
            player.translateX(10);
        });
        FXGL.onKey(KeyCode.A,() -> {
            player.translateX(-10);
        });
        FXGL.onKey(KeyCode.W,() -> {
            player.translateY(-10);
        });
        FXGL.onKey(KeyCode.S,() -> {
            player.translateY(10);
        });
        //TESTING PYPRPOSES
        //TODO: HAAL WEG
        FXGL.onKey(KeyCode.F,() -> {
            System.out.println(playerCreator.getHP().getCurrentHP());
        });
    }

     @Override
     protected void initPhysics(){ //TODO: VERANDER 'BOSS' NAAR PROJECTILE

         FXGL.onCollision(EntityTypes.PLAYER, EntityTypes.PROJECTILE, (player, PROJECTILE) -> {
             FXGL.inc("hp", playerCreator.getsDamaged(testProjectileCreator));
             playerCreator.getHP().death(player);
        });
     }

     @Override
     protected void initUI() {
        FXGL.getGameScene().setBackgroundColor(Color.WHITE);
        javafx.scene.control.Label textje = new Label("health ding: ");
        textje.setTranslateX(200);
        textje.setTranslateY(200);
        FXGL.getGameScene().addUINode(textje);
        textje.textProperty().bind(FXGL.getWorldProperties().intProperty("hp").asString());
     }

     protected void initGameVars(Map<String, Object> vars){
        vars.put("hp", playerCreator.getHP().getCurrentHP());
     }

//    @Override
//    protected void onUpdate(double tpf) {
//        Point2D velocity = testProjectile.getObject("velocity");
//        testProjectile.translate(velocity);
//
//    }

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void run() {
        Platform.runLater(this);
    }
}
