package nz.co.afleet.bit603_a2_johnmcpherson.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import nz.co.afleet.bit603_a2_johnmcpherson.R;
import nz.co.afleet.bit603_a2_johnmcpherson.User;
import nz.co.afleet.bit603_a2_johnmcpherson.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    TextView editTextUserName;
    TextView editTextPassword;
    TextView textViewErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewErrorMessage = findViewById(R.id.textErrorMessage);

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(v -> {
            boolean hasUserName = !editTextUserName.getText().toString().isEmpty();
            boolean hasPassword = !editTextPassword.getText().toString().isEmpty();
            boolean loginSuccessful = false; // we have not yet tried to login, so initialise as false

            if (hasUserName && hasPassword) {
                // try to login
                loginSuccessful = User.loginUser(editTextUserName.getText().toString(), editTextPassword.getText().toString());
            }
            // determine the error message and set it. (Even if the login is successful, we want to clear the error message)
            String errorMessage = determineErrorMessage(hasUserName, hasPassword, loginSuccessful);
            textViewErrorMessage.setText(errorMessage);

            // launch the Main Activity (if we have a successful login)
            if (loginSuccessful) {
                 launchMainActivity();
            }

        });
    }

    private String determineErrorMessage(boolean hasUserName, boolean hasPassword, boolean loginSuccessful) {
        if (loginSuccessful) return ""; // clear the error message

        // we don't have a successful login. If we have both user name and password, we must have a bad combination
        if (hasUserName && hasPassword) return getString(R.string.error_incorrect_login);

        // We are missing userName, password, or both
        String errorMessage = getString(R.string.login_error_header) + " ";
        if (hasUserName) {
            // we have a user name. So, it must be just the password that is missing
            errorMessage += (getString(R.string.login_error_password));
        } else {
            // we are missing the user name
            errorMessage += getString(R.string.login_error_user_name);
            // are we also missing the password?
            if (!hasPassword) {
                errorMessage += (" " + getString(R.string.and) + " " + getString(R.string.login_error_password));
            }
        }
        return errorMessage;
    }

    private void launchMainActivity() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }
}