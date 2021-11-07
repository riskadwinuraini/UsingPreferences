package com.example.usingpreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Deklarasi dan Menginisialisasi variabel nama dengan Label Nama dari Layout MainActivity */
        TextView nama = findViewById(R.id.tv_namaMain);

        /* Men-set Label Nama dengan data User sedang login dari Preferences */
        nama.setText(Preferences.getLoggedInUser(getBaseContext()));

        /* Men-set Status dan User yang sedang login menjadi default atau kosong di
        * Data Preferences. Kemudian menuju ke LoginActivity */
        findViewById(R.id.button_LogoutMain).setOnClickListener((v) -> {
            //Menghapus Status login dan kembali ke login activity
            Preferences.clearLoggedInUser(getBaseContext());
            startActivity(new Intent(getBaseContext(),LoginActivity.class));
            finish();

        });


    }
}