package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship

    private Spaceship spaceship;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("test_name", 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        new Spaceship("  ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenBelowZero() {
        new Spaceship("Spaceship", -1);
    }

    @Test
    public void testGetAstronautsCountShouldReturnZeroWhenEmpty() {
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test
    public void testGetAstronautsCountShouldReturnThreeWhenThreeAdded() {
        spaceship.add(new Astronaut("First", 100));
        spaceship.add(new Astronaut("Second", 90));
        spaceship.add(new Astronaut("Third", 80));
        Assert.assertEquals(3, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameAstronautTwiceShouldFail() {
        spaceship.add(new Astronaut("First", 100));
        spaceship.add(new Astronaut("First", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenCapacityFullShouldFail() {
        Spaceship spaceship = new Spaceship("Spaceship", 1);
        spaceship.add(new Astronaut("First", 100));
        spaceship.add(new Astronaut("Second", 90));
    }

    @Test
    public void testRemoveAstronautShouldReturnFalseWhenNoSuchAdded() {
        this.spaceship.add(new Astronaut("First", 100));
        Assert.assertFalse(this.spaceship.remove("Someone else"));
    }

    @Test
    public void testRemoveAstronautShouldReturnTrueWhenSuchAdded() {
        this.spaceship.add(new Astronaut("First", 100));
        Assert.assertTrue(this.spaceship.remove("First"));
    }
}

