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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;

public class aff_cinema extends AppCompatActivity {
    Double deux;
    String nm;
    Double un;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_cinema);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        int id = 0;
        if (b != null) {
            id = b.getInt("id");
        }
        affcinema(id);
        ((Button) findViewById(R.id.button21)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(aff_cinema.this, Showmapss.class);
                intent.putExtra("un", aff_cinema.this.un);
                intent.putExtra("deux", aff_cinema.this.deux);
                intent.putExtra("name_place", aff_cinema.this.nm);
                aff_cinema.this.startActivity(intent);
            }
        });
    }

    public void affcinema(int id) {
        try {
            cinema rest = new DBConnection(this).get_cinema(id);
            TextView name = (TextView) findViewById(R.id.namecinema);
            TextView tar = (TextView) findViewById(R.id.tarif_cinema);
            TextView prx = (TextView) findViewById(R.id.prcinema);
            TextView adr = (TextView) findViewById(R.id.adrcinema);
            TextView tel = (TextView) findViewById(R.id.telcinema);
            TextView mail = (TextView) findViewById(R.id.mailcinema);
            TextView site = (TextView) findViewById(R.id.sitcinema);
            TextView fax = (TextView) findViewById(R.id.faxcinema);
            TextView ouv = (TextView) findViewById(R.id.ouver_cinema);
            Button bt = (Button) findViewById(R.id.button21);
            ((ImageView) findViewById(R.id.imagecinema)).setBackgroundResource(getResources().getIdentifier(rest.img, "drawable", getPackageName()));
            Typeface face = Typeface.createFromAsset(getAssets(), "font.ttf");
            this.un = Double.valueOf(Double.parseDouble("" + rest.un));
            this.deux = Double.valueOf(Double.parseDouble(""+ rest.deux));
            this.nm = rest.getName();
            name.setTypeface(face);
            bt.setTypeface(face);
            tar.setTypeface(face);
            prx.setTypeface(face);
            adr.setTypeface(face);
            tel.setTypeface(face);
            mail.setTypeface(face);
            site.setTypeface(face);
            fax.setTypeface(face);
            ouv.setTypeface(face);
            name.setText(rest.getName());
            prx.setText(rest.getPrix());
            adr.setText(rest.getAdr());
            tel.setText(rest.getTel());
            mail.setText(rest.getMail());
            site.setText(rest.getSite());
            fax.setText(rest.getFax());
            ouv.setText(rest.getOuvert());
        } catch (Exception rr) {
            Toast.makeText(this, "Error aff: " + rr.getMessage(), (int) 1).show();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, list_cinema.class));
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