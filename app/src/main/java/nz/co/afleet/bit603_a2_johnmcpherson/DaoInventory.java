package nz.co.afleet.bit603_a2_johnmcpherson;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface DaoInventory {
    @Insert
    public void addInventoryItem(InventoryItem inventoryItem);

    @Query("SELECT * FROM InventoryItem")
    public List<InventoryItem> getInventoryItems();
}
