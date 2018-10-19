package com.pranaypathole.democrime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class complaint extends AppCompatActivity {

    Spinner complaintSpinner;
    EditText descriptionBox;

    ProgressDialog mDialog;

    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        complaintSpinner = findViewById(R.id.complaintSpinner);
        descriptionBox = findViewById(R.id.descriptionBox);

        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Submitting...");



        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Complaint");
    }

    public void submitReport(View view){
        AddData();
        Intent myIntent = new Intent(this, homepage.class);
        startActivity(myIntent);
    }

    public void AddData(){
        String complaintBox = descriptionBox.getText().toString();
        mDialog.show();
        SaveData saveData = new SaveData(complaintBox);
        mDatabaseReference.setValue(saveData);
        mDialog.dismiss();
        Toast.makeText(this, "Report Filed!", Toast.LENGTH_SHORT).show();
    }
}
