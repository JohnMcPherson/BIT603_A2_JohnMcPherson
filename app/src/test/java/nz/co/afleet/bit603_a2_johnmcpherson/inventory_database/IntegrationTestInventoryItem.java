package nz.co.afleet.bit603_a2_johnmcpherson.inventory_database;

import android.app.Application;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTestInventoryItem {
    private Application application;
    InventoryDatabase inventoryDatabase;
    DaoInventory daoInventory;

    private final String SUGAR = "Sugar";
    private final double SUGAR_QUANTITY_DOUBLE = 4;
    private final String SUGAR_QUANTITY_STRING = "4";

    @Before
    public void initialiseApplicationAndDatabase() {
        Application application = ApplicationProvider.getApplicationContext();
        inventoryDatabase = InventoryDatabase.getInstance(application);
        daoInventory = inventoryDatabase.daoInventory();
    }


    @Test
    public void testAddInventoryItemsToDatabaseViaInventoryItem() {
        // confirm that item with junk quantity will not be added to the database
        InventoryItem.addInventoryItemToDatabase(application, "Item with junk quantity", "Junk quantity");
        // confirm item not added to database the database
        List<InventoryItem> inventoryItems = daoInventory.getInventoryItems();
        assertEquals(inventoryItems.size(), 0);

        // confirm that item with negative quantity will not be added to the database
        InventoryItem.addInventoryItemToDatabase(application, "Item with negative quantity", "-6.0");
        // confirm item not added to database the database
        inventoryItems = daoInventory.getInventoryItems();
        assertEquals(inventoryItems.size(), 0);

        // confirm addition of Sugar
        InventoryItem.addInventoryItemToDatabase(application, SUGAR, SUGAR_QUANTITY_STRING);

        // confirm the number of items in the database
        inventoryItems = daoInventory.getInventoryItems();
        assertEquals(inventoryItems.size(), 1);
        // and the contents
        testInventoryItemContent(inventoryItems.get(0), SUGAR, SUGAR_QUANTITY_DOUBLE);
    }

    private void testInventoryItemContent(InventoryItem item, String expectedName, double expectedQuantity) {
        assertEquals(item.getName(), expectedName);
        assertEquals(item.getQuantity(), expectedQuantity, 0);
    }
}
