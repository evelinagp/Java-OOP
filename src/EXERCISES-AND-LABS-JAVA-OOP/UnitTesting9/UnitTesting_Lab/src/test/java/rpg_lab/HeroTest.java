package UnitTesting9.UnitTesting_Lab.src.test.java.rpg_lab;

import UnitTesting9.UnitTesting_Lab.src.main.java.rpg_lab.Hero;
import UnitTesting9.UnitTesting_Lab.src.main.java.rpg_lab.Target;
import UnitTesting9.UnitTesting_Lab.src.main.java.rpg_lab.Weapon;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void heroGainsExperienceWhenTargetDies() {
        Weapon weapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 0;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };
        Hero hero = new Hero("Java", weapon);
        Target target = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 100;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        hero.attack(target);
        assertEquals(100, hero.getExperience());
    }
}