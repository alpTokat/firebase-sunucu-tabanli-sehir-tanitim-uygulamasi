package alp.tokat.at_adana_yresi;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

public class AT_URUN {
    private String AT_urunismi;
    private String AT_urun_miktar;
    private double AT_fiyat;
    private String AT_urunaciklama;
    private String AT_secilenler;
    private String AT_secilenradio;
    private Bitmap AT_secilen_resim;
    Context AT_context;

    public AT_URUN(String AT_urunismi, String AT_urun_miktar, double AT_fiyat, String AT_urunaciklama, String AT_secilenler, String AT_secilenradio, Bitmap AT_secilen_resim, Context AT_context) {
        this.AT_urunismi = AT_urunismi;
        this.AT_urun_miktar = AT_urun_miktar;
        this.AT_fiyat = AT_fiyat;
        this.AT_urunaciklama = AT_urunaciklama;
        this.AT_secilenler = AT_secilenler;
        this.AT_secilenradio = AT_secilenradio;
        this.AT_secilen_resim = AT_secilen_resim;
        this.AT_context = AT_context;
    }

    public void setAT_urunismi(String AT_urunismi) {
        this.AT_urunismi = AT_urunismi;
    }

    public void setAT_urun_miktar(String AT_urun_miktar) {
        this.AT_urun_miktar = AT_urun_miktar;
    }

    public void setAT_fiyat(double AT_fiyat) {
        this.AT_fiyat = AT_fiyat;
        if (AT_fiyat < 0) {
            if (AT_context != null) {
                Toast.makeText(AT_context, "Ürün fiyatı negatif olamaz", Toast.LENGTH_LONG).show();
            }
        } else this.AT_fiyat = AT_fiyat;
    }

    public void setAT_urunaciklama(String AT_urunaciklama) {
        this.AT_urunaciklama = AT_urunaciklama;
    }

    public void setAT_secilenler(String AT_secilenler) {
        this.AT_secilenler = AT_secilenler;
    }

    public void setAT_secilenradio(String AT_secilenradio) {
        this.AT_secilenradio = AT_secilenradio;
    }

    public void setAT_secilen_resim(Bitmap AT_secilen_resim) {
        this.AT_secilen_resim = AT_secilen_resim;
    }

    public void setAT_context(Context AT_context) {
        this.AT_context = AT_context;
    }

    public String getAT_urunismi() {
        return AT_urunismi;
    }

    public String getAT_urun_miktar() {
        return AT_urun_miktar;
    }

    public double getAT_fiyat() {
        return AT_fiyat;
    }

    public String getAT_urunaciklama() {
        return AT_urunaciklama;
    }

    public String getAT_secilenler() {
        return AT_secilenler;
    }

    public String getAT_secilenradio() {
        return AT_secilenradio;
    }

    public Bitmap getAT_secilen_resim() {
        return AT_secilen_resim;
    }

    public Context getAT_context() {
        return AT_context;
    }
}
