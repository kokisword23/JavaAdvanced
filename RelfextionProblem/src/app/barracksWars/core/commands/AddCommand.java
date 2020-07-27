package app.barracksWars.core.commands;

import app.barracksWars.interfaces.Repository;
import app.barracksWars.interfaces.Unit;
import app.barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {
    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
