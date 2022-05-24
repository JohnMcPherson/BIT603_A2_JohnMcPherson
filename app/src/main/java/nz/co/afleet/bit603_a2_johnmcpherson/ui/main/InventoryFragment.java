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

import java.util.ArrayList;
import java.util.List;

import nz.co.afleet.bit603_a2_johnmcpherson.R;
import nz.co.afleet.bit603_a2_johnmcpherson.inventory_database.InventoryItem;
import nz.co.afleet.bit603_a2_johnmcpherson.ui.AddInventoryActivity;

/**
 * A fragment representing a list of Items.
 */
public class InventoryFragment extends Fragment {

    // TODO Check for larger devices (including landscape). Consider multiple columns
    // TODO Test visibility of items in list
    // TODO Test "Add" button is visible and works
    // TODO Test can scroll list and view items below
    // TODO Change theme to match Kiwi Cookies and Cakes (black)
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private final List<InventoryItem> inventoryList = new ArrayList<>();
    private InventoryItemRecyclerViewAdapter inventoryItemRecyclerViewAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InventoryFragment() {
    }

    // TODO: Customize parameter initialization
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
        inventoryList.clear();
        inventoryList.addAll(InventoryItem.getInventoryItems(requireActivity().getApplication()));
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
            inventoryItemRecyclerViewAdapter = new InventoryItemRecyclerViewAdapter(inventoryList);
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