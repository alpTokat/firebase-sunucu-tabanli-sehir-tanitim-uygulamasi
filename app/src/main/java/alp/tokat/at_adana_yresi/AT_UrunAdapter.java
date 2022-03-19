package alp.tokat.at_adana_yresi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AT_UrunAdapter extends ArrayAdapter<AT_URUN> {
    Context context;

    public AT_UrunAdapter(@NonNull Context context, int resource, @NonNull List<AT_URUN> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.at_urun_satir, parent, false);
        AT_URUN AT_urun = getItem(position);
        TextView AT_isim = convertView.findViewById(R.id.AT_txt_urun_isim_li);
        TextView AT_fiyat = convertView.findViewById(R.id.AT_txt_urun_fiyat_li);
        TextView AT_aciklama = convertView.findViewById(R.id.AT_txt_urun_aciklama_li);
        TextView AT_miktar = convertView.findViewById(R.id.AT_txt_urun_miktar_li);
        TextView AT_odeme = convertView.findViewById(R.id.AT_txt_urun_odeme_li);
        TextView AT_meyve = convertView.findViewById(R.id.AT_urun_meyve_li);
        Button AT_siparis = convertView.findViewById(R.id.AT_btn_sipraişver_li);
        ImageView AT_urun_resim_li = convertView.findViewById(R.id.AT_iv_urun_resim_li);
        AT_isim.setText(AT_urun.getAT_urunismi());
        AT_fiyat.setText(AT_urun.getAT_fiyat() + "");
        AT_aciklama.setText(AT_urun.getAT_urunaciklama());
        AT_miktar.setText(AT_urun.getAT_urun_miktar());
        AT_odeme.setText(AT_urun.getAT_secilenradio());
        AT_meyve.setText(AT_urun.getAT_secilenler());
        AT_urun_resim_li.setImageBitmap(AT_urun.getAT_secilen_resim());

        AT_siparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        AT_urun.getAT_urunismi() + " siparişiniz alınmıştır...",
                        Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
