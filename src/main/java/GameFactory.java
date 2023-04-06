import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.LiftComponent;
import com.almasb.fxgl.dsl.components.OffscreenCleanComponent;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.dsl.views.ScrollingBackgroundView;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.input.view.KeyView;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.ui.FontType;
import javafx.geometry.Point2D;
import javafx.scene.CacheHint;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import static com.almasb.fxgl.dsl.FXGL.*;


import static com.almasb.fxgl.dsl.FXGL.*;

public class GameFactory implements EntityFactory {

    @Spawns("platform")
    public Entity newPlatform(SpawnData data){
        return entityBuilder(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("background")
    public Entity newBackground(SpawnData data){
        return entityBuilder(data)
                .view(new ScrollingBackgroundView(texture("level1.png").getImage(), getAppWidth(), getAppHeight()))
                .zIndex(-1)
                .with(new IrremovableComponent())
                .build();
    }

    @Spawns("projectile")
    public Entity createProjectile(SpawnData data) {
        return entityBuilder(data)
                .at(350, 50)
                .viewWithBBox("img.png")
                .collidable()
                .with(new ProjectileComponent(new Point2D(0,1), 600).allowRotation(false))
                .with(new CollidableComponent(true))
                .with(new OffscreenCleanComponent())
//                .with("velocity", new Point2D(2, 2))
                .type(EntityTypes.PROJECTILE)
                .buildAndAttach();
    }

    @Spawns("deathScreen")
    public Entity deathScreen(SpawnData data){
        return entityBuilder(data)
                .viewWithBBox("YOUDIED.png")
                .buildAndAttach();
    }

}
