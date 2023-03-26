package UnitTesting9.UnitTesting_Lab.src.test.java.rpg_lab;

import UnitTesting9.UnitTesting_Lab.src.main.java.rpg_lab.Dummy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 100;
    private static final int ATTACK_POINTS = 10;
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void testDummiesLosesHealthWhenAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        assertEquals(DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyCannotBeAttacked() {
        deadDummy.takeAttack(ATTACK_POINTS);

    }

    @Test
    public void testDeadDummyGivesExperience() {

        assertEquals(DUMMY_EXPERIENCE, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyShouldNotGivesExperience() {
        dummy.giveExperience();
    }
}