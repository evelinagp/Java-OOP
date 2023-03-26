package ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.models.units;

public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 10;
    private static final int HORSEMAN_DAMAGE = 50;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
