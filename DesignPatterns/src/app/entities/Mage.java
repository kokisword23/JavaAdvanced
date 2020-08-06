package app.entities;

import app.strategies.DefenceStrategy;
import app.strategies.MageDefence;

public class Mage extends BaseHero {
    private DefenceStrategy defenceStrategy;
    public Mage(String name, int level) {
        super(name, level);
        this.defenceStrategy = new MageDefence();
    }

    public void defend() {
        defenceStrategy.defend("BLINK");
    }
}
