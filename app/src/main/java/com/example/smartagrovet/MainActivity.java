package com.example.smartagrovet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    TextView tv, tvPhone, tvPassword;

    FirebaseDatabase db;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPhone = findViewById(R.id.txtPhone);
        tvPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tv = findViewById(R.id.txtRegLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("Farmers");

                final String phoneTxt = tvPhone.getText().toString().trim();
                final String passwordTxt = tvPassword.getText().toString().trim();

                /*if (phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter Phone number or " +
                            "password", Toast.LENGTH_SHORT).show();
                }else {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // Check if phone number exist in firebase
                            if (snapshot.hasChild(phoneTxt)){
                                // Now let's get user entered password and match it with the
                                // existing password in firebase database
                                final String getPassword = snapshot.child(phoneTxt).child(
                                                "password").getValue(String.class);

                                if (getPassword.equals(passwordTxt)){
                                    // Open farmer dashboard upon success
                                    startActivity(new Intent(getApplicationContext(),
                                            DashboardActivity.class));
                                    finish();
                                }else {
                                    Toast.makeText(getApplicationContext(), "Wrong Phone or" +
                                            " Password", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(getApplicationContext(), "Wrong Phone or" +
                                        " Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getApplicationContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
                        }
                    });
                }*/
                startActivity(new Intent(getApplicationContext(),
                        DashboardActivity.class));
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }
}