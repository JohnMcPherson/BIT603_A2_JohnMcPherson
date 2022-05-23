package nz.co.afleet.bit603_a2_johnmcpherson.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import nz.co.afleet.bit603_a2_johnmcpherson.R;
import nz.co.afleet.bit603_a2_johnmcpherson.databinding.ActivityAddInventoryBinding;
import nz.co.afleet.bit603_a2_johnmcpherson.inventory_database.InventoryItem;

public class AddInventoryActivity extends AppCompatActivity {

    private ActivityAddInventoryBinding binding;
    private EditText editTextItemName;
    private EditText editTextQuantity;
    private Button buttonAdd;
    private TextView textViewErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // use View Binding to set the root view
        binding = ActivityAddInventoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // show the "Home" menu item (to return us to the calling screen)
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // use binding to find and initialise the required views
        editTextItemName = binding.editTextItemName;
        editTextQuantity = binding.editTextQuantity;
        textViewErrorMessage = binding.textErrorMessageAdd;
        buttonAdd = binding.buttonAdd;

        buttonAdd.setOnClickListener(v -> {
            String stringItemName = editTextItemName.getText().toString();
            String stringQuantity = editTextQuantity.getText().toString();
            boolean hasItemName = !stringItemName.isEmpty();
            boolean hasPassword = !stringQuantity.isEmpty();
            boolean additionSuccessful = false; // we have not yet tried to add the item, so initialise as false

            if (hasItemName && hasPassword) {
                if (!InventoryItem.isDuplicateOfInventoryItem(getApplication(), stringItemName)) {
                   InventoryItem.addInventoryItemToDatabase(getApplication(), stringItemName, stringQuantity);
                   additionSuccessful = true;
                }
            }
            // determine the error message and set it. (Even if the login is successful, we want to clear the error message)
            String errorMessage = determineErrorMessage(hasItemName, hasPassword, additionSuccessful);
            textViewErrorMessage.setText(errorMessage);

            // launch the Main Activity (if we have a successful login)
            if (additionSuccessful) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // act on the "Home" menu item
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String determineErrorMessage(boolean hasItemName, boolean hasQuantity, boolean additionSuccessful) {
        if (additionSuccessful) return ""; // clear the error message

        // addition successful still false. If we have both item name and quantity, we must have a duplicate
        // (for now) that is the only reason tested for not adding the item
        if (hasItemName && hasQuantity) return getString(R.string.duplicate_inventory_item);

        // We are missing itemName, quantity, or both
        String errorMessage = getString(R.string.missing_inventory_details_header) + " ";
        if (hasItemName) {
            // we have an item name. So, it must be just the quantity that is missing
            errorMessage += (getString(R.string.missing_inventory_item_quantity));
        } else {
            // we are missing the item name
            errorMessage += getString(R.string.missing_inventory_item_name);
            // are we also missing the quantity?
            if (!hasQuantity) {
                errorMessage += (" " + getString(R.string.and) + " " + getString(R.string.missing_inventory_item_quantity));
            }
        }
        return errorMessage;
    }


}
