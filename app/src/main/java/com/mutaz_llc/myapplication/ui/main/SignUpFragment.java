package com.mutaz_llc.myapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mutaz_llc.myapplication.R;
import com.mutaz_llc.myapplication.RestaurantFragment;

public class SignUpFragment extends Fragment {

//    private MainViewModel mViewModel;

    FirebaseAuth mAuth;

    EditText username_input_field;
    EditText password_input_field;
    EditText email_input_field;
    Button sign_up_button;
    TextView sign_in_link;


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
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();


        sign_in_link = getView().findViewById(R.id.sign_in_link);
        sign_up_button = getView().findViewById(R.id.sign_up_button);
        username_input_field = getView().findViewById(R.id.sign_up_username_input_field);
        password_input_field = getView().findViewById(R.id.sign_up_password_input_field);
        email_input_field = getView().findViewById(R.id.sign_up_email_input_field);


        sign_in_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                LoginFragment loginFragment = new LoginFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.main_container, loginFragment)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        sign_up_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = email_input_field.getText().toString();
                String password = password_input_field.getText().toString();
                String username = username_input_field.getText().toString();

                if (username.isEmpty()) {
                    username_input_field.setError("Please insert your username");
                    username_input_field.requestFocus();
                } else if (email.isEmpty()) {
                    email_input_field.setError("Please insert your email");
                    email_input_field.requestFocus();
                } else if (password.isEmpty()) {
                    password_input_field.setError("Please insert your password");
                    password_input_field.requestFocus();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getActivity(),"Welcome To Wagabati",Toast.LENGTH_SHORT).show();
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                RestaurantFragment rf = new RestaurantFragment();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.main_container, rf)
                                        .addToBackStack(null)
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                        .commit();
                                ;
                            }else {
                                Toast.makeText(getActivity(),"Couldn't sign up, "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

    }
}