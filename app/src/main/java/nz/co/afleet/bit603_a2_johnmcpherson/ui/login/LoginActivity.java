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
            if (hasUserName && hasPassword) {
                boolean loginSuccessful = User.loginUser(editTextUserName.getText().toString(), editTextPassword.getText().toString());
                if (loginSuccessful) {
                    textViewErrorMessage.setText("");
                    launchMainActivity();
                } else {
                    textViewErrorMessage.setText(R.string.error_incorrect_login) ;
                }
            } else {
                String stringErrorMessage = determineErrorMessage(hasUserName, hasPassword);
                textViewErrorMessage.setText(stringErrorMessage);
            }
        });
    }

    private void launchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private String determineErrorMessage(boolean hasUserName, boolean hasPassword) {
        String errorMessage = getString(R.string.login_error_header) + " ";
        if (!hasUserName) {
            errorMessage += getString(R.string.login_error_user_name);
            if (!hasPassword) {
                errorMessage += (" " + getString(R.string.and) + " " + getString(R.string.login_error_password));
            }
        } else {
            // For this path, we don't need to check hasPassword. The method should not have been called if userName and Password are both empty
            errorMessage += (getString(R.string.login_error_password));
        }
        return errorMessage;
    }
}