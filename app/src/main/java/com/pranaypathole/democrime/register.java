package com.pranaypathole.democrime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText emailRegister, pwdRegister, nameRegister, addressRegister, phoneRegister;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    DatabaseReference rootReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailRegister = findViewById(R.id.emailRegistration);
        pwdRegister = findViewById(R.id.passwordRegistration);
        nameRegister = findViewById(R.id.nameRegister);
        addressRegister = findViewById(R.id.addressRegister);
        phoneRegister = findViewById(R.id.phoneRegister);

        mAuth = FirebaseAuth.getInstance();

        rootReference = FirebaseDatabase.getInstance().getReference();

    }

    public void registerToLogin(View view){


        if(emailRegister.getText().toString().equals("") && pwdRegister.getText().toString().equals("") && nameRegister.getText().toString().equals("") && phoneRegister.getText().toString().equals("") && addressRegister.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Blank fields not allowed!", Toast.LENGTH_SHORT).show();
        }

        else{

            final String email = emailRegister.getText().toString();
            final String password = pwdRegister.getText().toString();
            final String name = nameRegister.getText().toString();
            final String phone = phoneRegister.getText().toString();
            final String address = addressRegister.getText().toString();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                mUser = mAuth.getCurrentUser();

                                User myUser = new User(emailRegister.getText().toString(),pwdRegister.getText().toString(), name, address, phone);

                                rootReference.child(mUser.getUid()).setValue(myUser)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(getApplicationContext(), "Values stored in db!", Toast.LENGTH_SHORT).show();
                                                    finish();

                                                    Intent i = new Intent(getApplicationContext(), homepage.class);
                                                    startActivity(i);
                                                }
                                            }
                                        });


                            }else{
                                Toast.makeText(getApplicationContext(), "User could not be created! Error 404", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }


    }

}
