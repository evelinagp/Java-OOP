package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private Gun gun;
    private boolean isAlive;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
//The takeDamage() method decreases the Player's armor and health. First you need to reduce the armor.
// If the armor reaches 0, transfer the damage to health points.
// If the health points are less than or equal to zero, the player is dead.

    @Override
    public void takeDamage(int points) {
        int directDamage = points > this.armor ? points - this.armor : 0;
        this.setArmor(Math.max(this.armor - points, 0));
        this.setHealth(Math.max(this.health - directDamage, 0));

//        Does not work!
//               int damage = points;
//        if (damage >= this.getArmor()) {
//            damage -= this.getArmor();
//            this.armor = 0;
//            this.health -= damage;
//        } else {
//            this.armor -= damage;
//        }

    }

    //"{player type}: {player username}
//--Health: {player health}
//--Armor: {player armor}
//--Gun: {player gun name}"
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + ": " + getUsername()).append(System.lineSeparator())
                .append("--Health: " + getHealth()).append(System.lineSeparator())
                .append("--Armor: " + getArmor()).append(System.lineSeparator())
                .append("--Gun: " + getGun().getName()).append(System.lineSeparator());

        return sb.toString().trim();
    }
}

