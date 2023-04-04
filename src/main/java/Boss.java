import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Boss {
    private Entity entityBuilder;
    private HP hp;
    private double sizeScaleX;
    private double sizeScaleY;

    public Boss(int maxHP ,double sizeScaleX, double sizeScaleY) {
        this.hp = new HP(maxHP);
        this.sizeScaleX = sizeScaleX;
        this.sizeScaleY = sizeScaleY;
    }

    public Entity createBoss() {
        entityBuilder = FXGL.entityBuilder()
                .at(400, 200)
                .viewWithBBox(new Circle(5, Color.BLACK))
                .with(new CollidableComponent(true))
                .type(EntityTypes.BOSS)
                .buildAndAttach();
        return entityBuilder;
    }

    public HP getHP() {
        return hp;
    }
}
