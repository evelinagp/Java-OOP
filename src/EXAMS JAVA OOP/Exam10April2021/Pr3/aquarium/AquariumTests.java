package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium

    private Aquarium aquarium;

    @Before
    public void setUp() {
        aquarium = new Aquarium("First", 10);
    }

    @Test
    public void testConstructorCreateInstance() {
        Assert.assertNotNull(aquarium);
    }

    @Test
    public void testGetName() {
        String actualName = aquarium.getName();
        String expectedName = "First";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        new Aquarium("  ", 10);
    }

    @Test
    public void testGetCapacity() {
        int actualHealth = aquarium.getCapacity();
        int expectedHealth = 10;
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenBelowZero() {
        new Aquarium("Player", -100);
    }

    @Test
    public void testGetCount() {
        aquarium.add(new Fish("Nemo"));
        aquarium.add(new Fish("Golden"));

        Assert.assertEquals(2, aquarium.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishShouldFailWhenTankIsFull() {
        aquarium = new Aquarium("First", 2);
        Fish fish1 = new Fish("Nemo");
        Fish fish2 = new Fish("Fish");
        Fish fish3 = new Fish("Golden");
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
    }

    @Test
    public void testAddValidFish() {
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFishShouldReturnFalseWhenNoSuchAdded() {
        this.aquarium.add(new Fish("First"));
        this.aquarium.remove("Other");
    }

    @Test
    public void testRemoveFishShouldReturnTrueWhenSuchAdded() {
        Fish fish = new Fish("First");
        this.aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
        this.aquarium.remove("First");
        Assert.assertEquals(0, aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldReturnFalseWhenNoSuchAdded() {
        this.aquarium.add(new Fish("First"));
        this.aquarium.sellFish("Other");

    }
    @Test
    public void testSellFishShouldReturnTrueWhenSuchAdded() {
        Fish fish = new Fish("First");
        this.aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
        Assert.assertEquals("First", fish.getName());
        this.aquarium.sellFish(fish.getName());
        Assert.assertFalse(fish.isAvailable());
    }
    @Test
    public void testReportCollectionOfFish(){
        Fish fish1 = new Fish("Nemo");
        Fish fish2 = new Fish("Golden");
        this.aquarium.add(fish1);
        this.aquarium.add(fish1);
        Assert.assertEquals(2, aquarium.getCount());
        Assert.assertEquals("Nemo", fish1.getName());
        Assert.assertEquals("Golden", fish2.getName());
        Assert.assertEquals("First", aquarium.getName());
        this.aquarium.report();
    }
}

