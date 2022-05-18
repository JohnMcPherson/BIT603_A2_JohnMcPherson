package nz.co.afleet.bit603_a2_johnmcpherson;

import android.app.Application;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTestDatabase {
    private Application application;
    InventoryDatabase inventoryDatabase;

    @Before
    public void initialiseApplicationInstance() {
        Application application = ApplicationProvider.getApplicationContext();
        inventoryDatabase = InventoryDatabase.getInstance(application);
    }

    @Test
    public void testCanGetDatabaseInstance() {
        assertNotNull(inventoryDatabase);
     }

}
