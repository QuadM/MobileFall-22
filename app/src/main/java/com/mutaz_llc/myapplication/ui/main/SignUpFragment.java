package com.mutaz_llc.myapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mutaz_llc.myapplication.R;

public class SignUpFragment extends Fragment {

//    private MainViewModel mViewModel;

    EditText username_input_field;
    EditText password_input_field;
    Button login_button;


    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
//        // TODO: Use the ViewModel - No MVVM yet
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getView().findViewById(R.id.sign_up_link).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                LoginFragment loginFragment = new LoginFragment();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right,
                                R.anim.enter_right_to_left,R.anim.exit_right_to_left)
                        .replace(R.id.sign_up_container,loginFragment)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });
    }
}