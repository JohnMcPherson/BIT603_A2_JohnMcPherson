


package nz.co.afleet.bit603_a2_johnmcpherson.inventory_database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// this class and its methods are limited to default visibility so that only InventoryItem can use it

@Database(entities = {InventoryItem.class}, version = 1)
abstract  class InventoryDatabase extends RoomDatabase {
    private static InventoryDatabase instance;

    static InventoryDatabase getInstance(Context context) {
        if (instance == null) { // initialise if not already initialised
            instance = Room.databaseBuilder(context, InventoryDatabase.class, "inventorydb").allowMainThreadQueries().build();
        }
        return instance;
    }

    abstract DaoInventory daoInventory();
}
