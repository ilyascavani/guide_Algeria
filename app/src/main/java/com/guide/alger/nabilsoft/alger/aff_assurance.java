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

public class aff_assurance extends AppCompatActivity {

    private static final String TAG = aff_assurance.class.getSimpleName();

    int id = 0;

    int ta = 0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_assurance);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.ta = b.getInt("ta");
            this.id = b.getInt("id");
        }
        aff_assur(this.ta, this.id);
    }

    public void aff_assur(int ta, int id) {
        try {
            assurance bnq = new DBConnection(this).get_assurance(ta, id);
            TextView name = (TextView) findViewById(R.id.namea);
            TextView desc = (TextView) findViewById(R.id.desca);
            TextView adr = (TextView) findViewById(R.id.adra);
            TextView tel = (TextView) findViewById(R.id.tela);
            TextView mail = (TextView) findViewById(R.id.maila);
            TextView site = (TextView) findViewById(R.id.sitea);
            TextView fax = (TextView) findViewById(R.id.faxa);
            Typeface face = Typeface.createFromAsset(getAssets(), "font.ttf");
            Typeface face2 = Typeface.createFromAsset(getAssets(), "font2.ttf");
            Button bt = (Button) findViewById(R.id.button17);
            name.setTypeface(face);
            bt.setTypeface(face);
            desc.setTypeface(face2);
            adr.setTypeface(face);
            tel.setTypeface(face);
            mail.setTypeface(face);
            site.setTypeface(face);
            fax.setTypeface(face);
            name.setText(bnq.getName());
            desc.setText(bnq.getDesc());
            adr.setText(bnq.getAdr());
            tel.setText(bnq.getTel());
            mail.setText(bnq.getMail());
            site.setText(bnq.getSite());
            fax.setText(bnq.getFax());
        } catch (Exception rr) {
            Toast.makeText(this, "Error aff: " + rr.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, list_assurance.class);
        intent.putExtra("ta", this.ta);
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