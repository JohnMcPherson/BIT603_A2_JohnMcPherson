/*
ASSUMPTIONS
    -   Integration testing is not a requirement of the Assessment.
        But one of the course videos mentioned Robolectric. I wanted to give it a try, and keep it as a reference
*/

package nz.co.afleet.bit603_a2_johnmcpherson;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import nz.co.afleet.bit603_a2_johnmcpherson.ui.inventory_item.AddInventoryActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTest_AddInventoryItem {
    private AddInventoryActivity addInventoryActivity;
    private TextView errorMessage;
    Button buttonCancel;
    Button buttonAdd;
    EditText editTextItemName;
    EditText editTextQuantity;


    @Before
    public void setupLoginActivity() {
        addInventoryActivity = Robolectric.setupActivity(AddInventoryActivity.class);
        errorMessage = addInventoryActivity.findViewById(R.id.textErrorMessageAdd);
        buttonCancel = addInventoryActivity.findViewById(R.id.buttonCancel);
        buttonAdd = addInventoryActivity.findViewById(R.id.buttonAdd);
        editTextItemName = addInventoryActivity.findViewById(R.id.editTextItemName);
        editTextQuantity = addInventoryActivity.findViewById(R.id.editTextQuantity);
   }

    @Test
    public void checkInitialErrorMessage() {
        assertEquals(getErrorMessage(), "");
    }

    @Test
    public void checkErrorMessageForNoDetailsEntered() {
        // try to add an item with no details entered
        buttonAdd.performClick();
        assertEquals(getErrorMessage(),"Please enter Item Name and Quantity");
    }

    @Test
    public void checkErrorMessageForNoQuantity() {
        // try to add an item with only the item name entered
        editTextItemName.setText("Eggs");
        buttonAdd.performClick();
        assertEquals(getErrorMessage(),"Please enter Quantity");
    }

    @Test
    public void checkErrorMessageForNoItemName() {
        // try to add an item with only the item name entered
        editTextQuantity.setText("36");
        buttonAdd.performClick();
        assertEquals(getErrorMessage(),"Please enter Item Name");
    }

    private String getErrorMessage() {
        return errorMessage.getText().toString();
    }
}
