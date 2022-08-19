package Reflection_barracksWars_TheCommandsStrikeBackEx04.core.factories;


import Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.Unit;
import Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.UnitFactory;
import Reflection_barracksWars_TheCommandsStrikeBackEx04.models.units.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "Reflection_barracksWars_TheCommandsStrikeBackEx04.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        // TODO: implement for problem 3

        Class unitClass = null;
        try {
            unitClass = Class.forName("Reflection_barracksWars_TheCommandsStrikeBackEx04.models.units." + unitType);
            Constructor<Unit> constructor = unitClass.getConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}


