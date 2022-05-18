package nz.co.afleet.bit603_a2_johnmcpherson;

import android.app.Application;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTestDatabase {
    private Application application;
    InventoryDatabase inventoryDatabase;
    DaoInventory daoInventory;

    private final String SUGAR = "Sugar";
    private final double SUGAR_QUANTITY = 4;
    private final String FLOUR = "Flour";
    private final double FLOUR_QUANTITY = 6.6;



    @Before
    public void initialiseApplicationInstance() {
        Application application = ApplicationProvider.getApplicationContext();
        inventoryDatabase = InventoryDatabase.getInstance(application);
        daoInventory = inventoryDatabase.daoInventory();
    }

    @Test
    public void testCreateInventoryItem() {
        InventoryItem sugarInventory = new InventoryItem();
        sugarInventory.setName(SUGAR);
        sugarInventory.setQuantity(SUGAR_QUANTITY);

        assertEquals(sugarInventory.getName(), SUGAR);
        // test with whole number
        assertEquals(sugarInventory.getQuantity(), SUGAR_QUANTITY, 0);

        InventoryItem flourInventory = new InventoryItem();
        flourInventory.setName(FLOUR);
        flourInventory.setQuantity(FLOUR_QUANTITY);

        assertEquals(flourInventory.getName(), FLOUR);
        // test with decimal number
        assertEquals(flourInventory.getQuantity(), FLOUR_QUANTITY, 0);
    }
}
