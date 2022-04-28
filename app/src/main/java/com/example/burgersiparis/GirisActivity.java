package com.example.burgersiparis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class GirisActivity extends AppCompatActivity {

    private EditText txtEmail,txtSifre;
    private Button btnGirisYap;
    private TextView lblKayitYonlemdirme;
    private FirebaseDatabase database;

    public void onCreate(Bundle bundle){
        FirebaseApp.initializeApp(this);
        SplashScreen.installSplashScreen(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_giris);

        initComponents();
        registerEventHandlers();
    }

    private void initComponents(){
        database = FirebaseDatabase.getInstance();
        txtEmail = findViewById(R.id.txtGirisEmail);
        txtSifre = findViewById(R.id.txtGirisSifre);
        btnGirisYap = findViewById(R.id.btnGirisYap);
        lblKayitYonlemdirme = findViewById(R.id.lblKayitYonlendirme);
    }

    private void registerEventHandlers(){
        btnGirisYap_onClick();
        lblKayitYonlendirme_onClick();
    }

    private void btnGirisYap_onClick(){
        String email = txtEmail.getText().toString().trim();
        String sifre = txtSifre.getText().toString().trim();
        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("kullanicilar");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        GenericTypeIndicator<List<Kullanici>> t = new GenericTypeIndicator<List<Kullanici>>() {};
                        List<Kullanici> list = snapshot.getValue(t);
                        for (Kullanici kullanici: list){
                            if (kullanici.getEmail().equals(email) && kullanici.getSifre().equals(sifre)){
                                /*Intent intent = new Intent(GirisActivity.this, gideceği aktivitiyi yazcaz);
                                startActivity(intent);
                                 */
                            }
                        }
                        Toast.makeText(GirisActivity.this,"Girdiğiniz email ve şifre ile bir hesap bulunamadı.",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    private void lblKayitYonlendirme_onClick(){
        lblKayitYonlemdirme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GirisActivity.this,KayitActivity.class);
                startActivity(intent);
            }
        });
    }

}
