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
}
