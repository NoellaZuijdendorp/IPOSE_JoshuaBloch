import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import java.util.Map;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class Game extends GameApplication {
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
//        spawn("platform");
//        setLevelFromMap("level1.tmx");
//        var level = setLevelFromMap("tmx/level2.tmx");
//        var map = new HashMap<String, Integer>();
//        Level level1 =  getAssetLoader().loadLevel("tmx/level1.tmx", new TMXLevelLoader());
//        getGameWorld().setLevel(level1);
//        map.put("h", 1);
//        map.put("kjj", 2);

//        player = null;
//        Viewport viewport = getGameScene().getViewport();
//        viewport.setBounds(-1500, 0, 250*70, getAppHeight());
//        viewport.bindToEntity(player, getAppWidth() / 2, getAppHeight() /2);
//        viewport.setLazy(true);



        player = playerCreator.createEntity();

        bossCreator = new Boss(0.75, 0.75);
        boss = bossCreator.createEntity();
    }

    private void setLevel(int levelNum){
        if (player!=null){
            player.getComponent(PhysicsComponent.class).overwritePosition(new Point2D(50,50));
            player.setZIndex(Integer.MAX_VALUE);
        }

//        Level level = setLevelFromMap("tmx/level" + levelNum + ".tmx");
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
     protected void initPhysics(){ //TODO: VERANDER 'BOSS' NAAR PROJECTILE
        FXGL.getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityTypes.PLAYER, EntityTypes.BOSS) {
            @Override
            protected void onCollision(Entity player, Entity bossProjectile) {
//                FXGL.inc("hp", playerCreator.getsDamaged());
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

//    @Override
//    protected void onUpdate(double tpf) {
//        Point2D velocity = testProjectile.getObject("velocity");
//        testProjectile.translate(velocity);
//
//    }

    public static void main(String[] args){
        launch(args);
    }
}
