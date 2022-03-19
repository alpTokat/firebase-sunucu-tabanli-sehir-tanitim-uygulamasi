package alp.tokat.at_adana_yresi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AT_MainActivity extends AppCompatActivity {
    String AT_secilencb, AT_secilenradio;
    EditText AT_isim, AT_aciklama, AT_fiyat;
    Spinner AT_urun_miktar;
    ArrayList<AT_URUN> AT_urunler;
    Button AT_liste, AT_foto, AT_btn_foto_cekim;
    RadioButton AT_radioButton_nakit, AT_radioButton_kart;
    RadioGroup AT_radioGroup;
    CheckBox AT_cb_portakal, AT_cb_mandalin;
    ImageView AT_fotoyeri, AT_cekilen_foto;
    Bitmap AT_resim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AT_cekilen_foto = findViewById(R.id.AT_iv_foto);
        AT_radioGroup = findViewById(R.id.AT_rdg);
        AT_cb_mandalin = findViewById(R.id.AT_cb_mandalin);
        AT_cb_portakal = findViewById(R.id.AT_cb_portakal);
        AT_isim = findViewById(R.id.AT_etxt_urun_isim);
        AT_aciklama = findViewById(R.id.AT_etxt_acıklama);
        AT_fiyat = findViewById(R.id.AT_etxt_urun_fiyat);
        AT_urun_miktar = findViewById(R.id.AT_spinner);
        AT_foto = findViewById(R.id.AT_btn_foto);
        AT_radioButton_kart = findViewById(R.id.AT_rb_kart);
        AT_radioButton_nakit = findViewById(R.id.AT_rb_nakit);
        AT_fotoyeri = findViewById(R.id.AT_iv_foto);
        AT_btn_foto_cekim = findViewById(R.id.AT_btn_foto);
        AT_urunler = new ArrayList<>();
        AT_liste = findViewById(R.id.AT_btn_listview);
        AT_liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AT_intent = new Intent(AT_MainActivity.this, AT_ListeAktivite.class);
                AT_Veritabani.AT_myurunler = AT_urunler;
                startActivity(AT_intent);
            }
        });
        // spinner ımıza  dinamik olarak elemanları ekleyen kod
        List<String> AT_spinnerElemanları = new ArrayList<>();
        AT_spinnerElemanları.add("- Paket");
        AT_spinnerElemanları.add("- Porsiyon");
        AT_spinnerElemanları.add("- Kilo");
        AT_spinnerElemanları.add("- Litre");
        AT_spinnerElemanları.add("- Adet");
        ArrayAdapter<String> AT_adapter = new ArrayAdapter<>(AT_MainActivity.this,
                android.R.layout.simple_spinner_item, AT_spinnerElemanları);
        AT_urun_miktar.setAdapter(AT_adapter);




        //Butona basıldığı zaman kameranın açılması kısmı
        AT_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AT_camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(AT_camera, 01);
            }
        });
    }
        //Yukardaki aktivite gerçekleştirdikten sonra sonucunun ne olacağı kısım
    @Override
    protected void onActivityResult(int AT_requestCode, int AT_resultCode, @Nullable Intent AT_data) {
        super.onActivityResult(AT_requestCode, AT_resultCode, AT_data);
        if (AT_requestCode == 01 && AT_resultCode == Activity.RESULT_OK) {
            AT_resim = (Bitmap) AT_data.getExtras().get("data");
            AT_fotoyeri.setImageBitmap(AT_resim);
        }
    }



    public void AT_urunOlustur(View view) {
        AT_secilencb = "";
        if (AT_cb_portakal.isChecked())
            AT_secilencb += " " + AT_cb_portakal.getText().toString();
        if (AT_cb_mandalin.isChecked())
            AT_secilencb += " " + AT_cb_mandalin.getText().toString();

        if (AT_radioButton_nakit.isChecked()) {
            AT_secilenradio = " " + AT_radioButton_nakit.getText().toString();
        } else {
            AT_secilenradio = " " + AT_radioButton_kart.getText().toString();
        }
        AT_urunler.add(new AT_URUN(AT_isim.getText().toString(), AT_urun_miktar.getSelectedItem().toString(),
                Double.parseDouble(AT_fiyat.getText().toString()),
                AT_aciklama.getText().toString(),
                AT_secilenradio,
                AT_secilencb,
                AT_resim,
                AT_MainActivity.this));
        Toast.makeText(getApplicationContext(), "Urun sayısı: " +
                        AT_urunler.size() + " , Eklenen : " + AT_urunler.get(AT_urunler.size() - 1).getAT_urunismi(),
                Toast.LENGTH_LONG).show();
    }
}
