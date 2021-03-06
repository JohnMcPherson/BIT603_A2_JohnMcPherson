package nz.co.afleet.bit603_a2_johnmcpherson.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.LinkedHashMap;

import nz.co.afleet.bit603_a2_johnmcpherson.R;
import nz.co.afleet.bit603_a2_johnmcpherson.inventory.InventoryItem;
import nz.co.afleet.bit603_a2_johnmcpherson.ui.inventory_item.AddInventoryActivity;

/**
 * A fragment representing a list of Items.
 */
public class InventoryFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    private final LinkedHashMap<String, Double> inventoryMap = new LinkedHashMap<>();
    private InventoryRecyclerViewAdapter inventoryItemRecyclerViewAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InventoryFragment() {
    }

    // TODO: Customize parameter initialization (IGNORE for now)
    @SuppressWarnings("unused")
    public static InventoryFragment newInstance(int columnCount) {
        InventoryFragment fragment = new InventoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // refresh the inventory list (that the adapter has access to)
        refreshInventoryList();
        // and tell the adapter that the list has changed
        inventoryItemRecyclerViewAdapter.notifyDataSetChanged();
        // If performance became a problem we could
        //  -  only update when an inventory item is added (using startActivityForResult, and onActivityResult)
        //  -  use inventoryItemRecyclerViewAdapter.notifyItemInserted(insertIndex)
        // performance is not a problem. So, no need to do the above yet
    }

    private void refreshInventoryList() {
        inventoryMap.clear();
        HashMap<String, Double> inventoryHashMap = InventoryItem.getInventoryItems(requireActivity().getApplication());
        inventoryMap.putAll(inventoryHashMap);
        // we can't directly use inventoryHashMap. inventoryMap is directly pointed to by the InventoryItemRecyclerViewAdapter
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory_list, container, false);
        View listView = view.findViewById(R.id.list);

        // Set the adapter
        if (listView instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) listView;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // create adapter with reference to a list that we will periodically update
            inventoryItemRecyclerViewAdapter = new InventoryRecyclerViewAdapter(inventoryMap);
            // add the adapter to the recycler view
            recyclerView.setAdapter(inventoryItemRecyclerViewAdapter);
        }

        FloatingActionButton buttonAddInventory = view.findViewById(R.id.fabAddInventoryItem);
        buttonAddInventory.setOnClickListener(v -> {
            Intent addItemIntent = new Intent(view.getContext(), AddInventoryActivity.class);
            startActivity(addItemIntent);
        });

        return view;
    }
}