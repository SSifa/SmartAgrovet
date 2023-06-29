package com.example.smartagrovet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference reference;

    TextView txtView;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtView = findViewById(R.id.txtRegLogin);
        btnRegister = findViewById(R.id.btnRegister);
        final EditText fName = findViewById(R.id.FName);
        final EditText lName = findViewById(R.id.edtLname);
        final EditText location = findViewById(R.id.edtLocation);
        final EditText landSize = findViewById(R.id.edtLandSize);
        final EditText phone = findViewById(R.id.edtRegPhone);
        final EditText password = findViewById(R.id.edtRegPassword);
        final EditText confPassword = findViewById(R.id.edtRegConfirmPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("Farmers");
                final String fNameTxt = fName.getText().toString().trim();
                final String lNameTxt = lName.getText().toString().trim();
                final String locationTxt = location.getText().toString().trim();
                final String landSizeTxt = landSize.getText().toString().trim();
                final String phoneTxt = phone.getText().toString().trim();
                final String passwordTxt = password.getText().toString().trim();
                final String confPasswordTxt = confPassword.getText().toString().trim();

                // Check if farmer has filled all fields
                if (fNameTxt.isEmpty() || lNameTxt.isEmpty() || locationTxt.isEmpty() ||
                        landSizeTxt.isEmpty() || phoneTxt.isEmpty() || passwordTxt.isEmpty() ||
                        confPasswordTxt.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please fill all fields.",
                            Toast.LENGTH_SHORT).show();
                } else if (!passwordTxt.equals(confPasswordTxt)) {
                    Toast.makeText(getApplicationContext(), "Passwords don't match.",
                            Toast.LENGTH_SHORT).show();
                }else if (isValid(passwordTxt)){
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // Check whether phone is already registered
                            // Phone number is used as the unique identifier
                            if (snapshot.hasChild(phoneTxt)){
                                Toast.makeText(getApplicationContext(), "Phone number " +
                                                "already registered.", Toast.LENGTH_SHORT).show();
                            }else {
                                reference.child(phoneTxt).child("fName").setValue(fNameTxt);
                                reference.child(phoneTxt).child("lName").setValue(lNameTxt);
                                reference.child(phoneTxt).child("location").setValue(locationTxt);
                                reference.child(phoneTxt).child("landSize").setValue(landSizeTxt);
                                reference.child(phoneTxt).child("password").setValue(passwordTxt);
                                Toast.makeText(getApplicationContext(), "Farmer successfully"+
                                                " registered.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),
                                        MainActivity.class));
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
    public boolean isValid(String passwd){
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwd.length() < 8){
            Toast.makeText(getApplicationContext(), "Password length must be at least 8 " +
                            "character.", Toast.LENGTH_SHORT).show();
        }else {
            for (int p = 0; p < passwd.length(); p++){
                if (Character.isLetter(passwd.charAt(p))){
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwd.length(); r++){
                if (Character.isDigit(passwd.charAt(r))){
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwd.length(); s++){
                char c = passwd.charAt(s);
                if (c >= 33 && c <= 46 || c == 64){
                    f3 = 1;
                }
            }
            if (f1 ==1 && f2 == 1 && f3 == 1)
                return true;
            Toast.makeText(getApplicationContext(), "Password should have at least a " +
                            "special character, alphabet and number", Toast.LENGTH_LONG).show();
        }
        return false;
    }
}