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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mutaz_llc.myapplication.R;
import com.mutaz_llc.myapplication.RestaurantFragment;

public class LoginFragment extends Fragment {

//    private MainViewModel mViewModel;


    FirebaseAuth mAuth;

    EditText password_input_field;
    EditText email_input_field;
    Button login_button;
    TextView sign_up_link;


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
        mAuth = FirebaseAuth.getInstance();

        login_button = view.findViewById(R.id.login_button);
        sign_up_link = view.findViewById(R.id.sign_up_link);

        password_input_field = getView().findViewById(R.id.user_password_input_field);
        email_input_field = getView().findViewById(R.id.user_email_input_field);

        sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replace fragment to sign up fragment
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                SignUpFragment signUpFragment = new SignUpFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.main_container, signUpFragment)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();

            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = email_input_field.getText().toString();
                String password = password_input_field.getText().toString();

                if (email.isEmpty()) {
                    email_input_field.setError("Please insert your email");
                    email_input_field.requestFocus();
                } else if (password.isEmpty()) {
                    password_input_field.setError("Please insert your password");
                    password_input_field.requestFocus();
                } else {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getActivity(), "Welcome To Wagabati", Toast.LENGTH_SHORT).show();
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                RestaurantFragment restaurantFragment = new RestaurantFragment();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.main_container, restaurantFragment)
                                        .addToBackStack(null)
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                        .commit();
                            } else {
                                Toast.makeText(getActivity(), "Couldn't login, " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }
        });
    }
}