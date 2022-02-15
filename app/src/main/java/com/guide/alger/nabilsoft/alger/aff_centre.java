package com.guide.alger.nabilsoft.alger;
import android.widget.Button;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

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
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.guide.alger.nabilsoft.alger.databinding.ActivityAffCentreBinding;

public class aff_centre extends AppCompatActivity {


  double deux;
    private static final String TAG = aff_centre.class.getSimpleName();
    String nm;
    double un;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_centre);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }
        Bundle b = getIntent().getExtras();
        int id = 0;
        if (b != null) {
            id = b.getInt("id");
        }
        affcentre(id);
        ((Button) findViewById(R.id.button18)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(aff_centre.this, Showmapss.class);
                intent.putExtra("un", aff_centre.this.un);
                intent.putExtra("deux", aff_centre.this.deux);
        //        intent.putExtra("name_place", aff_centre.this.nm);
                aff_centre.this.startActivity(intent);
            }
        });


    }


    public void affcentre(int id) {
        try {
            centre rest = new DBConnection(this).get_centre(id);
            TextView name = (TextView) findViewById(R.id.namecentre);
            TextView adr = (TextView) findViewById(R.id.adrcentre);
            TextView desc = (TextView) findViewById(R.id.desccentre);
            TextView tel = (TextView) findViewById(R.id.telcentre);
            TextView mail = (TextView) findViewById(R.id.mailcentre);
            TextView site = (TextView) findViewById(R.id.sitcentre);
            TextView fax = (TextView) findViewById(R.id.faxcentre);
            TextView ouv = (TextView) findViewById(R.id.ouver_centre);
            Button bt = (Button) findViewById(R.id.button18);
            Typeface face = Typeface.createFromAsset(getAssets(), "font.ttf");
            Typeface face2 = Typeface.createFromAsset(getAssets(), "font2.ttf");
       //   this.un = Double.valueOf(Double.parseDouble(BuildConfig.FLAVOR + rest.un));
          //  deux = Double.valueOf(Double.parseDouble(BuildConfig.FLAVOR + rest.deux));
            un =Double.valueOf(rest.un);
            deux  =Double.valueOf(rest.deux);
            this.nm = rest.getName();
            name.setTypeface(face);
            desc.setTypeface(face2);
            bt.setTypeface(face);
            adr.setTypeface(face);
            tel.setTypeface(face);
            mail.setTypeface(face);
            site.setTypeface(face);
            fax.setTypeface(face);
            ouv.setTypeface(face);
            name.setText(rest.getName());
            desc.setText(rest.getDesc());
            adr.setText(rest.getAdr());
            tel.setText(rest.getTel());
            mail.setText(rest.getEmail());
            site.setText(rest.getSite());
            fax.setText(rest.getFax());
            ouv.setText(rest.getOuvr());
        } catch (Exception rr) {
            Toast.makeText(this, "Error aff: " + rr.getMessage(), (int) 1).show();
        }
    }
}