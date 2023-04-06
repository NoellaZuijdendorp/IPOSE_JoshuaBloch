import com.almasb.fxgl.entity.Entity;

import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class HP {
    private int currentHP;
    private int maxHP;

    public HP(int maxHP) {
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
        if (this.currentHP > this.maxHP) {
            this.currentHP = this.maxHP;
        }
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void death(Entity character) {
        if (currentHP <= 0) {
            character.removeFromWorld();
            spawn("deathScreen");
            System.out.println("YOURE DEAD, no big suprise");
        }
    }
}
