package nz.co.afleet.bit603_a2_johnmcpherson;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {InventoryItem.class}, version = 1)
public  abstract  class InventoryDatabase extends RoomDatabase {
    private static InventoryDatabase instance;

    public static InventoryDatabase getInstance(Context context) {
        if (instance == null) { // initialise if not already initialised
            instance = Room.databaseBuilder(context, InventoryDatabase.class, "inventorydb").allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract DaoInventory daoInventory();
}
