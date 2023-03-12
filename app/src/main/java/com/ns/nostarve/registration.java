package com.ns.nostarve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class registration extends AppCompatActivity {
    EditText Uname, Uaddress, UnikId, PhoneNo;
    Button buttonSignup;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("Needs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Uname = (EditText) findViewById(R.id.Uname);
        Uaddress = (EditText) findViewById(R.id.Uaddress);
        UnikId = (EditText) findViewById(R.id.UnikId);
        PhoneNo = (EditText) findViewById(R.id.Unumber);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);
//        String no = getIntent().getStringExtra("keyNo");
//        PhoneNo.setText(no);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = PhoneNo.getText().toString();
                String name = Uname.getText().toString();
                String address = Uaddress.getText().toString();
                String uniqueId = UnikId.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("name", name);
                userMap.put("address", address);
                userMap.put("uniqueId", uniqueId);
                userMap.put("Phone", number);

                root.child(number).setValue(userMap);

                Intent extraIntent = new Intent(registration.this, Login.class);
                extraIntent.putExtra("keyNo", number);
                startActivity(extraIntent);
                finish();


            }
        });
    }
}