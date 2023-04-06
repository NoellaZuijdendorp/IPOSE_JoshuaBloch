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
                .scale(0.3, 0.3)
                .viewWithBBox("8-bit_blauw.png")
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
        int damageValue = 0;

        if (currentTime - lastHitTime > 1000) {
            hp.setCurrentHP(currentHP - projectile.getDamage());
            damageValue = -projectile.getDamage();
            lastHitTime = currentTime;
        }
        return damageValue;
    }
}
