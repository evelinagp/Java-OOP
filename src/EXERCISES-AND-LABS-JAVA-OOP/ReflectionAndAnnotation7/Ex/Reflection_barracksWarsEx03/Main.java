package ReflectionAndAnnotation7.Ex.Reflection_barracksWarsEx03;

import ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.core.Engine;
import ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.data.UnitRepository;
import ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.Repository;
import ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.Runnable;
import ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}

