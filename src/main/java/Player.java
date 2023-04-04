import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;

public class Player extends Entity {
    private Entity entityBuilder;
    private HP hp;
    private double sizeScaleX;
    private double sizeScaleY;

    public Player(int maxHP ,double sizeScaleX, double sizeScaleY) {
        this.hp = new HP(maxHP);
        this.sizeScaleX = sizeScaleX;
        this.sizeScaleY = sizeScaleY;
    }

    public Entity createPlayer() {
        entityBuilder = FXGL.entityBuilder()
                .at(400, 500)
                .viewWithBBox("")
                .scale(sizeScaleX, sizeScaleY)
                .with(new CollidableComponent(true))
                .type(EntityTypes.PLAYER)
                .buildAndAttach();
        return entityBuilder;
    }

    public HP getHP() {
        return hp;
    }
}
