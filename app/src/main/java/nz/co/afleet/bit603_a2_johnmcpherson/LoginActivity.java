package nz.co.afleet.bit603_a2_johnmcpherson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
                textViewErrorMessage.setText("");
                launchMainActivity();
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
            // we don't need to check hasPassword. The method should not have been called if userName and Password are both empty
            errorMessage += (getString(R.string.login_error_password));
        }
        return errorMessage;
    }
}