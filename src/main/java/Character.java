import com.almasb.fxgl.entity.Entity;

public abstract class Character {
    protected Entity entity;
    protected double sizeScaleX;
    protected double sizeScaleY;

    public abstract Entity createEntity();
}
