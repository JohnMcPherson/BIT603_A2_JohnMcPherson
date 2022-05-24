


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


    // !!!!! TESTING SUPPORT ONLY !!!!!
    // The only way (I could find), to get database integration testing to work consistently, was to thoroughly close down the database instance,
    // at the end of every test.
    // We can close() it using the publicly available method. But to null the instance variable, the test suite needs additional access. This access is provided below
    static void tearDown() {
        if (instance != null) {
            if (instance.isOpen()) {
                instance.close();
                instance = null;
            }
        }
    }

    abstract DaoInventory daoInventory();
}
