package com.example.usingpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, confirmPassword;
    Button buttondaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.et_emailSignup);
        password = findViewById(R.id.et_passwordSignup);
        confirmPassword = findViewById(R.id.et_passwordSignup2);
        buttondaftar = findViewById(R.id.button_signupSignup);
        buttondaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });

    }

    private void validateInput() {
        if (username.getText().toString().equals("")) {
            username.setError("Username Tidak Boleh Kosong!");
        } else if (password.getText().toString().equals("")) {
            password.setError("Password Tidak Boleh Kosong!");
        } else if (password.getText().toString().length() < 8) {
            password.setError("Password Harus Berjumlah 8 Karakter!");
        } else if (confirmPassword.getText().toString().equals("")) {
            confirmPassword.setError("Confirm Password Tidak Boleh Kosong!");
        } else if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
            confirmPassword.setError("Pengisian Confirm Password Harus Sama Dengan Password!");
        } else {
            daftar();
        }

    }

    private void daftar() {
        Preferences preferences = new Preferences();
        preferences.setRegisteredUser(this, username.getText().toString());
        preferences.setRegisteredPass(this, password.getText().toString());
        Toast.makeText(this, "Anda Telah Berhasil Daftar", Toast.LENGTH_SHORT).show();
        finish();
    }
}