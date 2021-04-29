package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {

    private int hitPoints;
    private int damage;
    private boolean armor;

    public MilitaryUnit(int hitPoints, int damage, boolean armor) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.armor = armor;
    }

    public int doDamage() {
        return damage;
    }

    public void sufferDamage(int damage) {
        int realDamage = damage;
        if (armor) {
            realDamage = damage / 2;
        }
        hitPoints -= realDamage;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
