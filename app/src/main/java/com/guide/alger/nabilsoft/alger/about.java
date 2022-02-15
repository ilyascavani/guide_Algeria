package com.guide.alger.nabilsoft.alger;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;


public class about extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        try {
            TabHost host = (TabHost) findViewById(R.id.tabHost);
            host.setup();
            TabSpec spec = host.newTabSpec("A propos");
            spec.setContent(R.id.tab1);
            spec.setIndicator("A propos");
            host.addTab(spec);
            spec = host.newTabSpec("Historique D'alger");
            spec.setContent(R.id.tab2);
            spec.setIndicator("Historique D'alger");
            host.addTab(spec);
            Typeface face = Typeface.createFromAsset(getAssets(), "font2.ttf");
            TextView t3 = (TextView) findViewById(R.id.textView50);
            TextView t4 = (TextView) findViewById(R.id.textView60);
            TextView t44 = (TextView) findViewById(R.id.textView9);
            TextView t2 = (TextView) findViewById(R.id.textView10);
            ((TextView) findViewById(R.id.textView3)).setTypeface(face);
            t2.setTypeface(face);
            t3.setTypeface(face);
            t4.setTypeface(face);
            t44.setTypeface(face);
            ImageButton gdpr = (ImageButton) findViewById(R.id.imageButton);
            ((ImageButton) findViewById(R.id.imageButton2)).setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    try {
                        about.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.guide.alger.nabilsoft.alger")));
                    } catch (ActivityNotFoundException e) {
                        about.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.guide.alger.nabilsoft.alger")));
                    }
                }
            });
            /*
           gdpr.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (ConsentInformation.getInstance(about.this.getBaseContext()).isRequestLocationInEeaOrUnknown()) {
                        about.this.requestConsent();
                    } else {
                        Toast.makeText(about.this, "" + about.this.getString(R.string.msg_data), Toast.LENGTH_LONG).show();
                    }
                }
            });*/
        } catch (Exception rr) {
            Toast.makeText(this, "Error aff: " + rr.getMessage(), (int)1).show();
        }
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

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

}