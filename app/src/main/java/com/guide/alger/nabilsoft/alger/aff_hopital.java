package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;

public class aff_hopital extends AppCompatActivity {
    Double deux;

    int i;
    int id;

    String nm;
    Double un;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_hopital);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.id = b.getInt("id");
            this.i = b.getInt("i");
        }
        aff_hopital(this.i, this.id);
        ((Button) findViewById(R.id.button16)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(aff_hopital.this, Showmapss.class);
                intent.putExtra("un", aff_hopital.this.un);
                intent.putExtra("deux", aff_hopital.this.deux);
                intent.putExtra("name_place", aff_hopital.this.nm);
                aff_hopital.this.startActivity(intent);
            }
        });
    }

    public void aff_hopital(int ii, int idd) {
        try {
            hopital ho = new DBConnection(this).get_hopital(ii, idd);
            TextView hname = (TextView) findViewById(R.id.namehopital);
            TextView desc = (TextView) findViewById(R.id.deschopital);
            TextView adr = (TextView) findViewById(R.id.adrhopital);
            TextView fix = (TextView) findViewById(R.id.fixhopital);
            TextView fax = (TextView) findViewById(R.id.faxhopital);
            TextView mail = (TextView) findViewById(R.id.mailhopital);
            TextView site = (TextView) findViewById(R.id.sitewebhopital);
            Typeface face = Typeface.createFromAsset(getAssets(), "font.ttf");
            Typeface face2 = Typeface.createFromAsset(getAssets(), "font2.ttf");
            Button bt = (Button) findViewById(R.id.button16);
            this.un = Double.valueOf(Double.parseDouble(""+ ho.un));
            this.deux = Double.valueOf(Double.parseDouble(""+ ho.deux));
            this.nm = ho.getName();
            hname.setTypeface(face);
            desc.setTypeface(face2);
            adr.setTypeface(face);
            fix.setTypeface(face);
            fax.setTypeface(face);
            mail.setTypeface(face);
            site.setTypeface(face);
            bt.setTypeface(face);
            hname.setText(ho.getName());
            desc.setText(ho.getDesc());
            adr.setText(ho.getAdr());
            fix.setText(ho.getTelephone());
            fax.setText(ho.getFax());
            mail.setText(ho.getEmail());
            site.setText(ho.getSite());
        } catch (Exception rr) {
            Toast.makeText(this, "Error : " + rr.getMessage(), (int) 1).show();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, list_hopital.class);
        intent.putExtra("id", this.i);
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

}