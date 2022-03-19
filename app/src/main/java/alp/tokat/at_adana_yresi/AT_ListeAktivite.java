package alp.tokat.at_adana_yresi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AT_ListeAktivite extends AppCompatActivity {
    ListView AT_listem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_t__liste_aktivite);
        AT_listem = findViewById(R.id.AT_liste);
        ArrayList<AT_URUN> AT_urunler = AT_Veritabani.AT_myurunler;


        Toast.makeText(AT_ListeAktivite.this, AT_urunler.get(0).getAT_urunismi(), Toast.LENGTH_LONG).show();

        AT_UrunAdapter AT_urunAdapter = new AT_UrunAdapter(AT_ListeAktivite.this, 0, AT_urunler);
        AT_listem.setAdapter(AT_urunAdapter);
    }
}