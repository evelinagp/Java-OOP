package ReflectionAndAnnotation7.Ex.Reflection_barracksWars_TheCommandsStrikeBackEx04.models.units;

public class Pikeman extends AbstractUnit {

	private static final int PIKEMAN_HEALTH = 30;
	private static final int PIKEMAN_DAMAGE = 15;

	public Pikeman() {
		super(PIKEMAN_HEALTH, PIKEMAN_DAMAGE);
	}
}
