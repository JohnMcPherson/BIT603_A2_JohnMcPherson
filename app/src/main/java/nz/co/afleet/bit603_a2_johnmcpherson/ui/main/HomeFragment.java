package nz.co.afleet.bit603_a2_johnmcpherson.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nz.co.afleet.bit603_a2_johnmcpherson.R;
import nz.co.afleet.bit603_a2_johnmcpherson.User;

// getString() has a warning, with root cause that getContext() is nullable. I assumed (and tested) that the context is known by the time
// onCreateView() is called
@SuppressWarnings("ConstantConditions")
public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        if (User.getLoggedInUser() != null) { // We shouldn't be here without a logged in user, but just in case
            TextView textViewWelcomeMessage = view.findViewById(R.id.textViewWelcomeMessage);
            String stringWelcomeMessage = getContext().getString(R.string.welcome_message_header) + " " + User.getLoggedInUser().getUserName();
            textViewWelcomeMessage.setText(stringWelcomeMessage);
        }
        return view;
    }
}
