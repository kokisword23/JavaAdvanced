package app.strategies;

public class RogueDefence implements DefenceStrategy {
    @Override
    public void defend(String type) {
        System.out.println("Entering stealth" + type);
    }
}
