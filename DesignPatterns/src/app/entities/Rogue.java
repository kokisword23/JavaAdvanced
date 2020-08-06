package app.entities;

import app.strategies.DefenceStrategy;
import app.strategies.RogueDefence;

public class Rogue extends BaseHero {
    private DefenceStrategy defenceStrategy;
    public Rogue(String name, int level) {
        super(name, level);
        defenceStrategy = new RogueDefence();
    }

    public void defence() {
        defenceStrategy.defend("RUN");
    }
}
