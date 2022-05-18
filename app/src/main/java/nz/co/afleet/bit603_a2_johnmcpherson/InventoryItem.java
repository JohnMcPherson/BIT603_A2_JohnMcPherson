/*
ASSUMPTIONS
    - we need decimals (double) to record quantities. this will allow recording of both:
        - integer quantities
        - measurement in parts (e.g. kg)
    - the unit of measure (items, packets, kg) is not required. There is no mention of them
        in the requirements. In the real world, we would check
*/


        package nz.co.afleet.bit603_a2_johnmcpherson;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

// This is a room database entity. Make the Name unique by indexing and annotating as unique
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
