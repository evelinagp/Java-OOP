package UnitTesting9.UnitTesting_Lab.src.main.java.rpg_lab;

public interface Target {
    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();
}
