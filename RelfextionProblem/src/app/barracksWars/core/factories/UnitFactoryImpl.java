package app.barracksWars.core.factories;

import app.barracksWars.interfaces.Unit;
import app.barracksWars.interfaces.UnitFactory;
import app.barracksWars.models.units.AbstractUnit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"app.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			Class<?> unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> declaredConstructor = unit.getDeclaredConstructor();
			Object object = declaredConstructor.newInstance();

			if (object instanceof AbstractUnit) {
				return  (Unit)object;
			}
		} catch (ClassNotFoundException | NoSuchMethodException e) {
			e.printStackTrace();
			return  null;
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Provided type is not a Unit");
	}
}
