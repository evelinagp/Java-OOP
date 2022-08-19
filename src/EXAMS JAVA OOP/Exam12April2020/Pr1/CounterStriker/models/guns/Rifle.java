package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    public final static int RIFLE_FIRED_BULLETS = 10;

    public Rifle(String name, int bulletCount) {
        super(name, bulletCount);
    }


    @Override
    public int fire() {
        if (super.getBulletsCount() >= RIFLE_FIRED_BULLETS) {
            super.decreaseBullets(RIFLE_FIRED_BULLETS);
            return RIFLE_FIRED_BULLETS;
        }
        return 0;
    }
}


