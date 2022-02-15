package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;

public class aff_banque extends AppCompatActivity {
    private static final String TAG = aff_banque.class.getSimpleName();
    int aa = 0;

    int id = 0;
    int tb = 0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_banque);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.tb = b.getInt("tb");
            this.id = b.getInt("id");
            this.aa = b.getInt("aa");
        }
        aff_bnq(this.tb, this.aa, this.id);
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, list_banque.class);
        intent.putExtra("tb", this.tb);
        intent.putExtra("aa", this.aa);
        startActivity(intent);
    }

    public void onRestart() {
        super.onRestart();

    }

    public void onResume() {
        super.onResume();

    }

    public void onStart() {
        super.onStart();

    }
    public void aff_bnq(int tb, int aa, int id) {
        try {
            banque bnq = new DBConnection(this).get_banque(tb, aa, id);
            TextView name = (TextView) findViewById(R.id.namebanque);
            TextView desc = (TextView) findViewById(R.id.descbanque);
            TextView adr = (TextView) findViewById(R.id.adrbanque);
            TextView tel = (TextView) findViewById(R.id.telbanque);
            TextView mail = (TextView) findViewById(R.id.mailbanque);
            TextView site = (TextView) findViewById(R.id.sitebanque);
            TextView fax = (TextView) findViewById(R.id.faxbanque);
            Typeface face = Typeface.createFromAsset(getAssets(), "font.ttf");
            Typeface face2 = Typeface.createFromAsset(getAssets(), "font2.ttf");
            Button bt = (Button) findViewById(R.id.button19);
            name.setTypeface(face);
            desc.setTypeface(face2);
            adr.setTypeface(face);
            tel.setTypeface(face);
            mail.setTypeface(face);
            site.setTypeface(face);
            fax.setTypeface(face);
            bt.setTypeface(face);
            name.setText(bnq.getName());
            desc.setText(bnq.getDesc());
            adr.setText(bnq.getAdr());
            tel.setText(bnq.getTel());
            mail.setText(bnq.getMail());
            site.setText(bnq.getSite());
            fax.setText(bnq.getFax());
        } catch (Exception rr) {
            Toast.makeText(this, "Error aff: " + rr.getMessage(), (int) 1).show();
        }
    }
}