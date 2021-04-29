package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<MilitaryUnit> militaryUnits;

    public Army() {
        this.militaryUnits = new ArrayList<>();
    }

    public int getArmySize() {
        return militaryUnits.size();
    }

    public void addUnit(MilitaryUnit militaryUnit) {
        militaryUnits.add(militaryUnit);
    }

    public int getArmyDamage() {
        return militaryUnits.stream().mapToInt(MilitaryUnit::doDamage).sum();
    }

    public void damageAll(int damage) {
        for (MilitaryUnit item:militaryUnits) {
            item.sufferDamage(damage);
        }
        militaryUnits.removeIf(it -> it.getHitPoints() < 25);
    }
}
