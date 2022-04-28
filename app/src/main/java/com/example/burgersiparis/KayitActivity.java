package com.example.burgersiparis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class KayitActivity extends AppCompatActivity {

    private static long idUret = 0;
    private EditText txtIsim,txtSoyisim,txtSifre,txtTelefon,txtKonum,txtEmail;
    private Button btnKayitOl;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        initComponents();
        registerEventHandlers();
    }

    private void initComponents(){
        txtIsim = findViewById(R.id.txtIsim);
        txtSoyisim = findViewById(R.id.txtSoyisim);
        txtSifre = findViewById(R.id.txtSifre);
        txtTelefon = findViewById(R.id.txtTelefon);
        txtKonum = findViewById(R.id.txtKonum);
        txtEmail = findViewById(R.id.txtEmail);
        btnKayitOl = findViewById(R.id.btnKayitOl);

        database = FirebaseDatabase.getInstance();
    }

    private void registerEventHandlers(){
        btnKayitOl_onClick();
    }

    private void btnKayitOl_onClick(){
        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long kullaniciId = idUret++;
                String isim = txtIsim.getText().toString().trim();
                String soyisim = txtSoyisim.getText().toString().trim();
                String sifre = txtSifre.getText().toString().trim();
                String telefon = txtTelefon.getText().toString().trim();
                String konum = txtKonum.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();

                Kullanici kullanici = new Kullanici(kullaniciId,isim,soyisim,sifre,telefon,konum,email,2);
                final DatabaseReference dbRef = database.getReference("kullanicilar").child(String.valueOf(kullanici.getId()));

                dbRef.setValue(kullanici, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if(databaseError == null) {
                            Toast.makeText(KayitActivity.this, "Kayıt başarılı", Toast.LENGTH_SHORT).show();
                            DatabaseReference kullanici1 = databaseReference.child(String.valueOf(kullaniciId));
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(KayitActivity.this);
                            builder.setTitle("Hata");
                            builder.setMessage("Bir hata oluştu");
                            builder.setIcon(android.R.drawable.ic_dialog_info);

                            builder.setPositiveButton("Kapat", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });

                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    }
                });
            }
        });
    }




}