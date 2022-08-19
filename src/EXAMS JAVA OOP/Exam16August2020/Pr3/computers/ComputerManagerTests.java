package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    // TODO: Test ComputerManager

    Computer computer;
    ComputerManager computerManager;

    @Before
    public void setUp() {

        computer = new Computer("Intel", "0", 1000);
        computerManager = new ComputerManager();
    }


    @Test
    public void testGetComputersUnmodifiableList() {
        computerManager.addComputer(computer);
        Computer actual = computer;
        Computer expected = computerManager.getComputer("Intel", "0");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCount() {
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameComputer() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer);

    }

    @Test
    public void testRemoveComputerShouldReturnTrueWhenSuchAdded() throws OperationNotSupportedException {
        this.computerManager.addComputer(computer);
        Computer expected = this.computerManager.removeComputer("Intel", "0");
        Computer actual = computer;
        Assert.assertEquals(expected, actual);
//        Assert.assertNull(computerManager.getComputers().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldReturnFalseIsNull() {
        Computer computer = new Computer(null, null, 0);
        Computer expected = this.computerManager.getComputer(null, null);
        Computer actual = computer;
        Assert.assertEquals(null, "There is no computer with this manufacturer and model.");
//
    }
    @Test
    public void testGetComputerGetComputersByManufacturer () {
        this.computerManager.addComputer(computer);
        Computer expected = this.computerManager.getComputersByManufacturer("Intel").get(0);
        Computer actual = computerManager.getComputer("Intel","0");
        Assert.assertEquals(expected, actual);
//
    }

}