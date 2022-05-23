/*
ASSUMPTIONS
    - we need decimals (double) to record quantities. this will allow recording of both:
        - integer quantities
        - measurement in parts (e.g. kg)
    - the unit of measure (items, packets, kg) is not required. There is no mention of them
        in the requirements. In the real world, we would check

ABOUT InventoryItem
    -   InventoryItem is the UI facing interface to the inventory database.
        Activities (and other UI components) should use InventoryItem for all database facing (inventory) services.
        This:
        -   makes it simpler to build UI components
        -   protects the database from illegal calls (such as adding duplicate items, which would cause a crash)
*/


        package nz.co.afleet.bit603_a2_johnmcpherson;

import android.app.Application;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.List;

// This is a room database entity. Make the Name unique by indexing and annotating as unique
// TODO We need to enforce this at a higher level in the app, or we risk a crash
@Entity(indices = {@Index(value = {"Name"},
                    unique = true)})
public class InventoryItem {

    // Make it quicker and less error prone to create a new inventory item
    public static InventoryItem create(String name, double quantity) {
        InventoryItem item = new InventoryItem();
        item.setName(name);
        item.setQuantity(quantity);
        return item;
    }

/*
    // Using a string for quantity, so we can provide a service directly to the UI, without the UI having to know
    // how the quantity is stored
    public static boolean addInventoryItemToDatabase(Application application, String name, double quantity) {
        // initial check on data
        if (name == null) return false;

    }

*/
    private static DaoInventory getDaoInventory(Application application) {
        InventoryDatabase inventoryDatabase = InventoryDatabase.getInstance(application);
        return inventoryDatabase.daoInventory();
    }

    public static boolean isDuplicateOfInventoryItem(Application application, String candidateName) {
        // List<InventoryItem> currentInventoryItems = getDaoInventory(application).getInventoryItems();
        return false;
    }

    // Good practice to add an ID, although we do not expect to need it (yet)
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;

    @ColumnInfo(name = "Name")
    private String Name;

    @ColumnInfo(name = "Quantity")
    private double quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
