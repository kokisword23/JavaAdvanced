package app.strategies;

public class MageDefence implements DefenceStrategy {
    @Override
    public void defend(String type) {
        System.out.println("Activating fire shield" + type);
    }
}
