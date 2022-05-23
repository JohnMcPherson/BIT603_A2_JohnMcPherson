package nz.co.afleet.bit603_a2_johnmcpherson.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import nz.co.afleet.bit603_a2_johnmcpherson.R;
import nz.co.afleet.bit603_a2_johnmcpherson.User;
import nz.co.afleet.bit603_a2_johnmcpherson.databinding.ActivityAddInventoryBinding;
import nz.co.afleet.bit603_a2_johnmcpherson.databinding.ActivityMainBinding;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        editTextItemName = binding.editTextItemName;
        editTextQuantity = binding.editTextQuantity;
        textViewErrorMessage = binding.textErrorMessageAdd;

        buttonAdd = binding.buttonAdd;
        buttonAdd.setOnClickListener(v -> {
            boolean hasItemName = !editTextItemName.getText().toString().isEmpty();
            boolean hasPassword = !editTextQuantity.getText().toString().isEmpty();
            boolean loginSuccessful = false; // we have not yet tried to login, so initialise as false

            if (hasItemName && hasPassword) {
                // try to login
                // loginSuccessful = User.loginUser(editTextItemName.getText().toString(), editTextQuantity.getText().toString());
            }
            // determine the error message and set it. (Even if the login is successful, we want to clear the error message)
            String errorMessage = determineErrorMessage(hasItemName, hasPassword, loginSuccessful);
            textViewErrorMessage.setText(errorMessage);

            // launch the Main Activity (if we have a successful login)
            if (loginSuccessful) {
                // launchMainActivity();
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

    private String determineErrorMessage(boolean hasItemName, boolean hasQuantity, boolean notDuplicate) {
        if (notDuplicate) return ""; // clear the error message

        // notDuplicate has still false. If we have both item name and quantity, we must have a duplicate
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
