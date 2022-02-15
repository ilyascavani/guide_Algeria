package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import android.os.Bundle;

public class aff_musee extends AppCompatActivity {
    private static final String TAG = aff_musee.class.getSimpleName();
    Double deux;

    String nm;
    Double un;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_musee);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        int id = 0;
        if (b != null) {
            id = b.getInt("id");
        }
        affmusee(id);
        ((Button) findViewById(R.id.button20)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(aff_musee.this, Showmapss.class);
                intent.putExtra("un", aff_musee.this.un);
                intent.putExtra("deux", aff_musee.this.deux);
                intent.putExtra("name_place", aff_musee.this.nm);
                aff_musee.this.startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(this, list_musee.class));
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

    public void affmusee(int id) {
        try {
            musee rest = new DBConnection(this).get_musee(id);
            ImageView img = (ImageView) findViewById(R.id.imagemusee);
            TextView name = (TextView) findViewById(R.id.namemusee);
            TextView desc = (TextView) findViewById(R.id.descmusee);
            TextView tar = (TextView) findViewById(R.id.tarif_musee);
            TextView prx = (TextView) findViewById(R.id.prmusee);
            TextView adr = (TextView) findViewById(R.id.adrmusee);
            TextView tel = (TextView) findViewById(R.id.telmusee);
            TextView mail = (TextView) findViewById(R.id.mailmusee);
            TextView site = (TextView) findViewById(R.id.sitmusee);
            TextView fax = (TextView) findViewById(R.id.faxmusee);
            TextView ouv = (TextView) findViewById(R.id.ouver_musee);
            Button bt = (Button) findViewById(R.id.button20);
            img.setBackgroundResource(getResources().getIdentifier(rest.img, "drawable", getPackageName()));
            img.setVisibility(View.VISIBLE);
            Typeface face = Typeface.createFromAsset(getAssets(), "font.ttf");
            Typeface face2 = Typeface.createFromAsset(getAssets(), "font2.ttf");
            this.un = Double.valueOf(Double.parseDouble("" + rest.un));
            this.deux = Double.valueOf(Double.parseDouble("" + rest.deux));
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
            desc.setTypeface(face2);
            name.setText(rest.getName());
            prx.setText(rest.getPrix());
            adr.setText(rest.getAdr());
            tel.setText(rest.getTel());
            mail.setText(rest.getMail());
            site.setText(rest.getSite());
            fax.setText(rest.getFax());
            ouv.setText(rest.getOuvert());
            desc.setText(rest.getDesc());
        } catch (Exception rr) {
            Toast.makeText(this, "Error aff: " + rr.getMessage(), (int) 1).show();
        }
    }

}