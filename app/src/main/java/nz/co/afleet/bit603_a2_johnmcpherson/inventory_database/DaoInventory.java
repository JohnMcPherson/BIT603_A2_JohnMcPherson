package nz.co.afleet.bit603_a2_johnmcpherson.inventory_database;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// this interface and its methods are limited to default visibility so that only InventoryItem can use it

@androidx.room.Dao
interface DaoInventory {
    @Insert
    void addInventoryItem(InventoryItem inventoryItem);

    @Query("SELECT * FROM InventoryItem")
    List<InventoryItem> getInventoryItems();
}
