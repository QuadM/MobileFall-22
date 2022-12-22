package com.mutaz_llc.myapplication.ui.main;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import com.mutaz_llc.myapplication.R;
import com.mutaz_llc.myapplication.RestaurantFragment;

public class LoginFragment extends Fragment {

//    private MainViewModel mViewModel;

    EditText username_input_field;
    EditText password_input_field;
    TextView test;
    Button login_button;
    TextView sign_up;


    public static LoginFragment newInstance() {
        return new LoginFragment();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login_button = view.findViewById(R.id.login_button);
        sign_up = view.findViewById(R.id.sign_up_link);
        test = view.findViewById(R.id.test);

        view.findViewById(R.id.sign_up_link).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // replace fragment to sign up fragment
            }
        });
        login_button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                test.setText("clicked");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                RestaurantFragment restaurantFragment = new RestaurantFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.login_container,restaurantFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });
    }
}