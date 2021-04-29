package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit{
    private int countOfDamage;
    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        if (countOfDamage == 0) {
            countOfDamage++;
            return super.doDamage() * 3;
        }else {
            return super.doDamage();
        }
    }
}
