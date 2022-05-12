package nz.co.afleet.bit603_a2_johnmcpherson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nz.co.afleet.bit603_a2_johnmcpherson.R;

// getString() has a warning, with root cause that getContext() is nullable. I assumed (and tested) that the context is known by the time
// onCreateView() is called
@SuppressWarnings("ConstantConditions")
public class WelcomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        TextView textViewWelcomeMessage = view.findViewById(R.id.textViewWelcomeMessage);
        String stringWelcomeMessage = getContext().getString(R.string.welcome_message_header);
        textViewWelcomeMessage.setText(stringWelcomeMessage);
        return view;
    }
}
