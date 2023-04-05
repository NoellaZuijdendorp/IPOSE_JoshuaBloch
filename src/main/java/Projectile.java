import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.geometry.Point2D;

public class Projectile {
    private Entity entity;
    private double sizeScaleX;
    private double sizeScaleY;
    private int damage;
    private int speedX;
    private int speedY;

    public Projectile(double sizeScaleX, double sizeScaleY, int damage, int speedX, int speedY) {
        this.sizeScaleX = sizeScaleX;
        this.sizeScaleY = sizeScaleY;
        this.damage = damage;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public Entity createEntity() { //TODO: VERANDER ALLES IN DEZE FUNCTIE
        entity = FXGL.entityBuilder()
                .at(150, 320)
                .viewWithBBox("")
                .scale(sizeScaleX, sizeScaleY)
                .with(new CollidableComponent(true))
                .with("velocity", new Point2D(speedX, speedY))
                .type(EntityTypes.PROJECTILE)
                .buildAndAttach();
        return entity;
    }

    public int getDamage() {
        return damage;
    }
}
