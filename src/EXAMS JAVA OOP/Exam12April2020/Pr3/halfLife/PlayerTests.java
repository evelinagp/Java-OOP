package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player
    private Player player;

    @Before
    public void setUp() {
        player = new Player("First", 10);
    }

    @Test
    public void testConstructorCreateInstance() {
        Assert.assertNotNull(player);
    }

    @Test
    public void testGetUserName() {
        String actualName = player.getUsername();
        String expectedName = "First";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        new Player(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        new Player("  ", 10);
    }

    @Test
    public void testGetHealth() {
        int actualHealth = player.getHealth();
        int expectedHealth = 10;
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthShouldFailWhenBelowZero() {
        new Player("Player", -100);
    }

    @Test
    public void testGetGuns() {
        int actualGunSize = player.getGuns().size();
        int expectedGunSize = 0;
        Assert.assertEquals(expectedGunSize, actualGunSize);
    }


//    @Test(expected = IllegalArgumentException.class)
//    public void testPlayerCannotTakeDamageWhenHealthBelowZero() {
//        player = new Player("First", 10);
//        player.takeDamage(20);
//    }

    @Test
    public void testPlayerTakeDamageWhenHealthDecreasedWithDamageIsAboveZero() {
        player.takeDamage(5);
        int actualHealth = player.getHealth();
        int expectedHealth = 5;
        Assert.assertEquals(expectedHealth, actualHealth);

    }

    @Test(expected = NullPointerException.class)
    public void testAddGunShouldFailWhenNull() {
        player.addGun(null);
    }
    @Test
    public void testAddValidGun() {
        Gun gun = new Gun("rifle", 20);
        player.addGun(gun);
        Gun actualGun = gun;
        Gun expectedGun = player.getGun(gun.getName());
        Assert.assertEquals(expectedGun, actualGun);
    }

    @Test
    public void testGetGunsCountShouldReturnThreeWhenThreeAdded() {
        player.addGun(new Gun("Makarov", 12));
        player.addGun(new Gun("Remington ", 50));
        player.addGun(new Gun("Glock ", 10));
        Assert.assertEquals(3, player.getGuns().size());
    }

    @Test
    public void testGetGunWhenExist() {
        Gun gun = new Gun("First", 100);
        player.addGun(gun);
        Gun actual = gun;
        Gun expected = player.getGun(gun.getName()) ;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetGunWhenDoesNotExist() {
        Gun gun = new Gun("First", 100);
        player.addGun(gun);
        Gun actual = gun;
        Gun expected = player.getGun("pistol") ;
        Assert.assertNotEquals(expected, actual);
    }


    @Test
    public void testRemoveGunShouldReturnFalseWhenNoSuchAdded() {
        this.player.addGun(new Gun("First", 100));
        Assert.assertFalse(this.player.removeGun(new Gun("Other", 100)));
    }

    @Test
    public void testRemoveGunShouldReturnTrueWhenSuchAdded() {
        Gun gun = new Gun("First", 100);
        this.player.addGun(gun);
        Assert.assertTrue(this.player.removeGun(gun));
    }

}
