package nz.co.afleet.bit603_a2_johnmcpherson.inventory;

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

    @Query ("DELETE FROM InventoryItem")
    public void FOR_TEST_USE_ONLY_deleteAllInventoryItems();
}
