/*
    COMMENTS
    -   Change AndroidStudio provided code to use InventoryItem
*/

package nz.co.afleet.bit603_a2_johnmcpherson.ui.main;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import nz.co.afleet.bit603_a2_johnmcpherson.inventory_database.InventoryItem;
import nz.co.afleet.bit603_a2_johnmcpherson.placeholder.PlaceholderContent.PlaceholderItem;
import nz.co.afleet.bit603_a2_johnmcpherson.databinding.FragmentInventoryBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class InventoryItemRecyclerViewAdapter extends RecyclerView.Adapter<InventoryItemRecyclerViewAdapter.ViewHolder> {

    private final List<InventoryItem> mValues;

    public InventoryItemRecyclerViewAdapter(List<InventoryItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentInventoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        InventoryItem inventoryItem = mValues.get(position);
        holder.mItem = inventoryItem;
        holder.mIdView.setText(inventoryItem.getIdString());
        holder.mContentView.setText(inventoryItem.getName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public InventoryItem mItem;

        public ViewHolder(FragmentInventoryBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}