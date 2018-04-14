package com.example.pronoymukherjee.classify.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;

import com.example.pronoymukherjee.classify.Helper.HashMaker;
import com.example.pronoymukherjee.classify.Helper.Message;
import com.example.pronoymukherjee.classify.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    AppCompatEditText _email, _password;
    AppCompatButton _signUp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initializeViews();
        firebaseAuth = FirebaseAuth.getInstance();
        _signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isNotNull(_email, _password)) {
                    _email.setEnabled(false);
                    _password.setEnabled(false);
                    Pattern pattern=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$");
                    Matcher matcher=pattern.matcher(_email.getText().toString());
                    if(matcher.matches()) {
                        signUp(_email.getText().toString(), _password.getText().toString());
                    }else{
                        _email.setError("Invalid Email.");
                        _email.setEnabled(true);
                        _password.setEnabled(true);
                    }
                } else {
                    _email.setEnabled(true);
                    _password.setEnabled(true);
                    Message.toastMessage(
                            getApplicationContext(),
                            "Please fill in all details.",
                            "");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            finish();
        }
    }

    /**
     * Method to initialize the views.
     */
    private void initializeViews() {
        _email = findViewById(R.id.emailEnter);
        _password = findViewById(R.id.password_Enter);
        _signUp = findViewById(R.id.signUpButton);
    }

    /**
     * This is the method to check whether the EDIT TEXT is not NULL.
     *
     * @param editTexts: The Edit Text(s) you want to check for NULL.
     * @return: False: if NOT NULL, else TRUE: if NULL.
     */
    private boolean isNotNull(AppCompatEditText... editTexts) {
        for (AppCompatEditText editText : editTexts) {
            if (TextUtils.isEmpty(editText.getText().toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to create the user.
     *
     * @param email:    The Email of the user.
     * @param password: The password of the user.
     */
    private void signUp(String email, String password) {
        password = HashMaker.getHash(password);
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //TODO:SignUpComplete
                        } else {
                            Message.toastMessage(getApplicationContext(),
                                    "SignUp Failed.",
                                    "");
                            _email.setError("SignUpFailed");
                        }
                    }
                });
    }
}
