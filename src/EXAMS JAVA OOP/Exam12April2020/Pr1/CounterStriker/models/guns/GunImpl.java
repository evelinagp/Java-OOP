package CounterStriker.models.guns;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class GunImpl implements Gun {

    private String name;
    private int bulletCount;


    public GunImpl(String name, int bulletCount) {
        this.setName(name);
        this.setBulletCount(bulletCount);

    }

    private void setBulletCount(int bulletCount) {
        if (this.bulletCount < 0) {
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletCount = bulletCount;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void decreaseBullets(int amount) {
        this.bulletCount -= amount;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletCount;

    }
}
