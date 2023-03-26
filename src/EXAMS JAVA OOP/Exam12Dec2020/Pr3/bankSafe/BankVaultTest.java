package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankVaultTest {
    //TODO: Write your tests here
    private BankVault bankVault;
    private Item item;

    public BankVaultTest() throws OperationNotSupportedException {
    }

    @Before
    public void setUp() throws Exception {
        bankVault = new BankVault();
        item = new Item("Peso", "1");
    }

    @Test
    public void testGetVaultCells() {
        Map<String, Item> cells = bankVault.getVaultCells();
        int actualVaultCellsSize = 12;
        Assert.assertEquals(cells.size(), actualVaultCellsSize);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddSuccessfullyItem() {
        Map<String, Item> expectedMap = new LinkedHashMap<>();
        expectedMap.put("A1", null);
        expectedMap.put("A2", null);
        expectedMap.put("A3", null);
        expectedMap.put("A4", null);
        expectedMap.put("B1", null);
        expectedMap.put("B2", null);
        expectedMap.put("B3", null);
        expectedMap.put("B4", null);
        expectedMap.put("C1", null);
        expectedMap.put("C2", null);
        expectedMap.put("C3", null);
        expectedMap.put("C4", null);
        Map<String, Item> actualMap = bankVault.getVaultCells();
        Assert.assertEquals(expectedMap, actualMap);
        this.bankVault.getVaultCells().put("D3", null);
        Assert.assertEquals(expectedMap.size(), actualMap.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldFailCellDoesNotExist() throws OperationNotSupportedException {
        this.bankVault.addItem("C25", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldFailCellAlreadyTaken() throws OperationNotSupportedException {
        Item item2 = new Item("Gosho", "2");
        this.bankVault.addItem("C2", item);
        this.bankVault.addItem("C2", item2);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddSameItemToCellShouldFail() throws OperationNotSupportedException {

        this.bankVault.addItem("C2",null);
        String actual = this.bankVault.addItem("C4", item);
        String expected = "Item is already in cell";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddItemShouldSuccess() throws OperationNotSupportedException {

        String expected = "Item:1 saved successfully!";
        String actual = this.bankVault.addItem("C2", item);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldReturnFalseWhenNoSuchAdded() throws OperationNotSupportedException {
        Item item2 = new Item("Gosho", "2");
        String actual = this.bankVault.removeItem("C1", item2);
        String expected = "Item in that cell doesn't exists!";

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCellShouldReturnFalseWhenNoSuchExist() throws OperationNotSupportedException {
        Item item2 = new Item("Gosho", "2");
//        this.bankVault.addItem("C1", item);
        String actual = this.bankVault.removeItem("C21", item2);
        String expected = "Cell doesn't exists!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveItemShouldReturnTrueWhenSuchAdded() throws OperationNotSupportedException {
        this.bankVault.addItem("C1", item);
        String actual = this.bankVault.removeItem("C1", item);
        String expected = "Remove item:1 successfully!";
        Assert.assertEquals(expected, actual);
        Assert.assertNull(bankVault.getVaultCells().get("C1"));
    }
    public void testAddItem() throws OperationNotSupportedException {
        this.bankVault.addItem("C1", item);
        String actual = this.bankVault.removeItem("C1", item);
        String expected = "Remove item:1 successfully!";
        Assert.assertEquals(expected, actual);
    }
}
