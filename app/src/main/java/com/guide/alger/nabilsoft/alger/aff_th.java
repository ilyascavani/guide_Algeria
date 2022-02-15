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

public class aff_th extends AppCompatActivity {
    Double deux;

    String nm;
    Double un;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_th);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        int id = 0;
        if (b != null) {
            id = b.getInt("id");
        }
        affth(id);
        ((Button) findViewById(R.id.button22)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(aff_th.this, Showmapss.class);
                intent.putExtra("un", aff_th.this.un);
                intent.putExtra("deux", aff_th.this.deux);
                intent.putExtra("name_place", aff_th.this.nm);
                aff_th.this.startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(this, list_th.class));
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
    public void affth(int id) {
        try {
            th rest = new DBConnection(this).get_th(id);
            TextView name = (TextView) findViewById(R.id.nameth);
            Button bt = (Button) findViewById(R.id.button22);
            TextView desc = (TextView) findViewById(R.id.descth);
            TextView adr = (TextView) findViewById(R.id.adrth);
            TextView tel = (TextView) findViewById(R.id.telth);
            TextView mail = (TextView) findViewById(R.id.mailth);
            TextView site = (TextView) findViewById(R.id.siteth);
            TextView fax = (TextView) findViewById(R.id.faxth);
            ((ImageView) findViewById(R.id.imageth)).setBackgroundResource(getResources().getIdentifier(rest.img, "drawable", getPackageName()));
            Typeface face = Typeface.createFromAsset(getAssets(), "font.ttf");
            Typeface face2 = Typeface.createFromAsset(getAssets(), "font2.ttf");
            this.un = Double.valueOf(Double.parseDouble("" + rest.un));
            this.deux = Double.valueOf(Double.parseDouble("" + rest.deux));
            this.nm = rest.getName();
            name.setTypeface(face);
            bt.setTypeface(face);
            desc.setTypeface(face2);
            adr.setTypeface(face);
            tel.setTypeface(face);
            mail.setTypeface(face);
            site.setTypeface(face);
            fax.setTypeface(face);
            name.setText(rest.getName());
            desc.setText(rest.getDesc());
            adr.setText(rest.getAdr());
            tel.setText(rest.getTel());
            mail.setText(rest.getMail());
            site.setText(rest.getSite());
            fax.setText(rest.getFax());
        } catch (Exception rr) {
            Toast.makeText(this, "Error aff: " + rr.getMessage(), (int) 1).show();
        }
    }

 /*   public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_aff_th, menu);
        return true;
    }*/

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}