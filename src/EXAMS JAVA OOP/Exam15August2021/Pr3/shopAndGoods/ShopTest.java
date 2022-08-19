package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {
    //TODO: Write your tests here
    private Shop shop;
    private Goods goods;

    @Before
    public void setUp() throws Exception {
        shop = new Shop();
        goods = new Goods("Toys", "1");
    }

    @Test
    public void testGetVaultCells() {
        Map<String, Goods> cells = shop.getShelves();
        int actualVaultCellsSize = 12;
        Assert.assertEquals(cells.size(), actualVaultCellsSize);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesAndUnmodifiableMap() {
        Map<String, Goods> expectedMap = new LinkedHashMap<>();
        expectedMap.put("Shelves1", null);
        expectedMap.put("Shelves2", null);
        expectedMap.put("Shelves3", null);
        expectedMap.put("Shelves4", null);
        expectedMap.put("Shelves5", null);
        expectedMap.put("Shelves6", null);
        expectedMap.put("Shelves7", null);
        expectedMap.put("Shelves8", null);
        expectedMap.put("Shelves9", null);
        expectedMap.put("Shelves10", null);
        expectedMap.put("Shelves11", null);
        expectedMap.put("Shelves12", null);

        Map<String, Goods> actualMap = shop.getShelves();
        Assert.assertEquals(expectedMap, actualMap);
        this.shop.getShelves().put("Shelves11", null);
        Assert.assertEquals(expectedMap.size(), actualMap.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailShelvesDoesNotExist() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves14", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailShelvesAlreadyTaken() throws OperationNotSupportedException {
        Goods goods2 = new Goods("Books", "2");
        this.shop.addGoods("Shelves2", goods);
        this.shop.addGoods("Shelves2", goods2);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddSameGoodsToShelvesShouldFail() throws OperationNotSupportedException {

        this.shop.addGoods("Shelves2",null);
        String actual = this.shop.addGoods("Shelves4", goods);
        String expected = "The shelf is already taken!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddGoodsShouldSuccess() throws OperationNotSupportedException {

        String expected = "Goods: 1 is placed successfully!";
        String actual = this.shop.addGoods("Shelves2", goods);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldReturnFalseWhenNoSuchAdded() throws OperationNotSupportedException {
        Goods goods2 = new Goods("Books", "2");
        String actual = this.shop.removeGoods("Shelves2", goods2);
        String expected = "Goods in that shelf doesn't exists!";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldReturnFalseWhenNoSuchExist() throws OperationNotSupportedException {
        Goods goods2 = new Goods("Books", "2");
        String actual = this.shop.removeGoods("Shelves22", goods2);
        String expected = "The shelf doesn't exist!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveGoodsShouldReturnTrueWhenSuchAdded() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves2", goods);
        String actual = this.shop.removeGoods("Shelves2", goods);
        String expected = "Goods: 1 is removed successfully!";
        Assert.assertEquals(expected, actual);
        Assert.assertNull(shop.getShelves().get("Shelves2"));
    }

}
