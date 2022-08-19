package CounterStriker.models.guns;

public class Pistol extends GunImpl {


    public final static int PISTOL_FIRED_BULLETS = 1;

    public Pistol(String name, int bulletCount ) {
        super(name, bulletCount);

    }
    @Override
    public int fire() {
        if ( super.getBulletsCount() >= PISTOL_FIRED_BULLETS) {
            super.decreaseBullets(PISTOL_FIRED_BULLETS);
            return PISTOL_FIRED_BULLETS;
        }
        return 0;
    }
}



