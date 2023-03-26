package ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.core.factories;


import ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.Unit;
import ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.UnitFactory;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "ReflectionAndAnnotation7.WorkingWithAbstraction1.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        // TODO: implement for problem 3

        Class unitClass = null;
        try {
            unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> constructor = unitClass.getConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}


