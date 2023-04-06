import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Boss extends Character {

    public Boss(double sizeScaleX, double sizeScaleY) {
        this.sizeScaleX = sizeScaleX;
        this.sizeScaleY = sizeScaleY;
    }

    public Entity createEntity() {
        entity = FXGL.entityBuilder()
                .at(275, 30)
                .scale(0.5, 0.5)
                .viewWithBBox("8-bit_rood.png")
                .with(new CollidableComponent(true))
                .type(EntityTypes.BOSS)
                .buildAndAttach();
        return entity;
    }
}
