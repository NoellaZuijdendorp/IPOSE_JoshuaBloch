import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;

public class Projectile {
    private Entity entity;
    private double sizeScaleX;
    private double sizeScaleY;
    private int damage;
    private int speed;

    public Projectile(Entity entity, double sizeScaleX, double sizeScaleY, int damage, int speed) {
        this.entity = entity;
        this.sizeScaleX = sizeScaleX;
        this.sizeScaleY = sizeScaleY;
        this.damage = damage;
        this.speed = speed;
    }

    public Entity createEntity() { //TODO: VERANDER ALLES IN DEZE FUNCTIE
        entity = FXGL.entityBuilder()
                .at(400, 500)
                .viewWithBBox("")
                .scale(sizeScaleX, sizeScaleY)
                .with(new CollidableComponent(true))
                .type(EntityTypes.PLAYER)
                .buildAndAttach();
        return entity;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }
}
