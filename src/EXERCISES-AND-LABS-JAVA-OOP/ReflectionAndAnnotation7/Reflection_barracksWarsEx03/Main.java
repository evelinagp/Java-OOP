package Reflection_barracksWarsEx03;

import Reflection_barracksWarsEx03.interfaces.Repository;
import Reflection_barracksWarsEx03.interfaces.Runnable;
import Reflection_barracksWarsEx03.interfaces.UnitFactory;
import Reflection_barracksWarsEx03.core.Engine;
import Reflection_barracksWarsEx03.core.factories.UnitFactoryImpl;
import Reflection_barracksWarsEx03.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
