package Reflection_barracksWars_TheCommandsStrikeBackEx04;

import Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.Repository;
import Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.Runnable;
import Reflection_barracksWars_TheCommandsStrikeBackEx04.interfaces.UnitFactory;
import Reflection_barracksWars_TheCommandsStrikeBackEx04.core.Engine;
import Reflection_barracksWars_TheCommandsStrikeBackEx04.core.factories.UnitFactoryImpl;
import Reflection_barracksWars_TheCommandsStrikeBackEx04.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
