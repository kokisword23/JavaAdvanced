package app.barracksWars;


import app.barracksWars.core.Engine;
import app.barracksWars.core.factories.UnitFactoryImpl;
import app.barracksWars.data.UnitRepository;
import app.barracksWars.interfaces.Repository;
import app.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
