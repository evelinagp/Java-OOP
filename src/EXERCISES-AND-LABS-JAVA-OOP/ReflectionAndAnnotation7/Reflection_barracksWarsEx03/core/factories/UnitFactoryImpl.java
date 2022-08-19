package Reflection_barracksWarsEx03.core.factories;


import Reflection_barracksWarsEx03.interfaces.Unit;
import Reflection_barracksWarsEx03.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        // TODO: implement for problem 3

        Class unitClass = null;
        try {
            unitClass = Class.forName("barracksWars.models.units." + unitType);
            Constructor<Unit> constructor = unitClass.getConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}


