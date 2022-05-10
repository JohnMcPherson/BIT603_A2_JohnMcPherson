package nz.co.afleet.bit603_a2_johnmcpherson;

import androidx.appcompat.app.AppCompatActivity;

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
            String requiredErrorMessage = determineErrorMessage();
            textViewErrorMessage.setText(requiredErrorMessage);
        });
    }

    private String determineErrorMessage() {
        if (editTextUserName.getText().toString().equals("")) {
            if (editTextPassword.getText().toString().equals("")) {
                return "Please enter your User Name and Password";
            } else {
                return "Please enter your User Name";
            }
        } else {
            if (editTextPassword.getText().toString().equals("")) {
                return "Please enter your Password";
            } else {
                return "";
            }
        }
    }
}