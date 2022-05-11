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
            String stringErrorMessage = determineErrorMessage();
            textViewErrorMessage.setText(stringErrorMessage);
            if (stringErrorMessage.equals("")) {
                launchMainActivity();
            }
        });
    }

    private void launchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private String determineErrorMessage() {
        // TODO split messages, and move to string values
        if (editTextUserName.getText().toString().equals("")) {
            if (editTextPassword.getText().toString().equals("")) {
                return getString(R.string.login_error_header)
                        + " " + getString(R.string.login_error_user_name)
                        + " " + getString(R.string.and)
                        + " " + "Password";
            } else {
                return getString(R.string.login_error_header)
                        + " " + getString(R.string.login_error_user_name);
            }
        } else {
            if (editTextPassword.getText().toString().equals("")) {
                return getString(R.string.login_error_header)
                        + " " + getString(R.string.login_error_password);
            } else {
                return "";
            }
        }
    }
}