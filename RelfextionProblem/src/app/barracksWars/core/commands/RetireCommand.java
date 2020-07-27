package app.barracksWars.core.commands;

import app.barracksWars.interfaces.Repository;
import app.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = "";

        try {
            this.getRepository().removeUnit(getData()[1]);
        } catch (Exception e) {
            output = e.getMessage();
        }

        return output;
    }
}
