/*
    ASSUMPTIONS
    - The inventory id is not to be displayed

    COMMENTS
    -   Changed AndroidStudio provided code to use InventoryItem
*/

package nz.co.afleet.bit603_a2_johnmcpherson.ui.main;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import nz.co.afleet.bit603_a2_johnmcpherson.inventory_database.InventoryItem;
import nz.co.afleet.bit603_a2_johnmcpherson.databinding.FragmentInventoryBinding;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * {@link RecyclerView.Adapter} that can display an {@link InventoryItem}.
 */
public class InventoryItemRecyclerViewAdapter extends RecyclerView.Adapter<InventoryItemRecyclerViewAdapter.ViewHolder> {

    // TODO use iterator with LinkedHashMap

    // Using LinkedHashMap because it has a more reliable definition of position than HashMap. [onBindViewHolder() uses position]
    private final LinkedHashMap<String, Double> inventoryHashMap;

    public InventoryItemRecyclerViewAdapter(LinkedHashMap<String, Double> items) {
        inventoryHashMap = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentInventoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Object key = inventoryHashMap.keySet().toArray()[position];
        if (key.getClass() == String.class) { // protect from crash
            String itemName = (String) key; // now we are sure we got a String, as expected
            Double doubleQuantity = inventoryHashMap.get(key);
            String stringValue = String.valueOf(doubleQuantity);
            holder.mContentView.setText(itemName);
            holder.mQuantity.setText(stringValue);
        }
    }

    @Override
    public int getItemCount() {
        return inventoryHashMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView mQuantity;
        public InventoryItem mItem;

        // TODO use "text" in naming
        public ViewHolder(FragmentInventoryBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemIdentifier;
            mContentView = binding.name;
            mQuantity = binding.quantity;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}