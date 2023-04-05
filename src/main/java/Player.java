import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;

public class Player extends Character {
    private HP hp;
    private long lastHitTime = 0;

    public Player(int maxHP ,double sizeScaleX, double sizeScaleY) {
        this.hp = new HP(maxHP);
        this.sizeScaleX = sizeScaleX;
        this.sizeScaleY = sizeScaleY;
    }

    public Entity createEntity() {
        entity = FXGL.entityBuilder()
                .at(400, 500)
                .viewWithBBox("")
                .scale(sizeScaleX, sizeScaleY)
                .with(new CollidableComponent(true))
                .type(EntityTypes.PLAYER)
                .buildAndAttach();
        return entity;
    }

    public HP getHP() {
        return hp;
    }

    public int getsDamaged(Projectile projectile) {
        long currentTime = System.currentTimeMillis();
        int currentHP = getHP().getCurrentHP();
        int damageValue = projectile.getDamage();

        if (currentTime - lastHitTime > 1000) {
            hp.setCurrentHP(currentHP - 1);
            lastHitTime = currentTime;
            damageValue = -1;
        }
        return damageValue;
    }
}
