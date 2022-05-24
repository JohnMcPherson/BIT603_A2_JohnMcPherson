package nz.co.afleet.bit603_a2_johnmcpherson.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nz.co.afleet.bit603_a2_johnmcpherson.R;
import nz.co.afleet.bit603_a2_johnmcpherson.User;
import nz.co.afleet.bit603_a2_johnmcpherson.ui.login.LoginActivity;

// getString() has a warning, with root cause that getContext() is nullable. I assumed (and tested) that the context is known by the time
// onCreateView() is called
// TODO Make Welcome bigger
// TODO check for larger devices
@SuppressWarnings("ConstantConditions")
public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        User loggedInUser = User.getLoggedInUser();
        if (loggedInUser != null) { // We shouldn't be here without a logged in user, but just in case
            TextView textViewWelcomeMessage = view.findViewById(R.id.textViewWelcomeMessage);

            // set the welcome message text
            String stringWelcomeMessage = getContext().getString(R.string.welcome_message_header) + " " + loggedInUser.getUserName();
            textViewWelcomeMessage.setText(stringWelcomeMessage);

            // set the welcome message colour
            int colourCodeWelcomeMessage = loggedInUser.getColourCode();
            textViewWelcomeMessage.setTextColor(colourCodeWelcomeMessage);
        }

        Button buttonLogout = view.findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(v -> {
            // create Intent (the intended new activity)
            Activity currentActivity = getActivity();
            Intent loginActivityIntent = new Intent(getActivity(), LoginActivity.class);

            // return to LoginActivity, by using the intent
            startActivity(loginActivityIntent);
        });
        return view;
    }
}
