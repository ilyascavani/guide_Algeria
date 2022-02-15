package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.guide.alger.nabilsoft.alger.DBConnection;

import com.guide.alger.nabilsoft.alger.list_resto;
import com.guide.alger.nabilsoft.alger.resto;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;

public class aff_resto extends AppCompatActivity {
    private static final String TAG = aff_resto.class.getSimpleName();
    Double deux;

    String nm;
    Double un;
    public void affresto(int n) {
        try {
            resto resto2 = new DBConnection((Context)this).get_resto(n);
            ImageView imageView = (ImageView)this.findViewById(R.id.img);
            TextView textView = (TextView)this.findViewById(R.id.textView);
            TextView textView2 = (TextView)this.findViewById(R.id.textView2);
            TextView textView3 = (TextView)this.findViewById(R.id.textView3);
            TextView textView4 = (TextView)this.findViewById(R.id.textView4);
            TextView textView5 = (TextView)this.findViewById(R.id.textView5);
            TextView textView6 = (TextView)this.findViewById(R.id.textView6);
            TextView textView7 = (TextView)this.findViewById(R.id.textView7);
            TextView textView8 = (TextView)this.findViewById(R.id.textView8);
            Button button = (Button)this.findViewById(R.id.btn);
            imageView.setBackgroundResource(this.getResources().getIdentifier(resto2.img, "drawable", this.getPackageName()));
            Typeface typeface = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font.ttf");
            Typeface typeface2 = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font2.ttf");
            this.un = Double.parseDouble((String)("" + resto2.un));
            this.deux = Double.parseDouble((String)("" + resto2.deux));
            this.nm = resto2.getName();
            textView.setTypeface(typeface);
            button.setTypeface(typeface);
            textView2.setTypeface(typeface2);
            textView3.setTypeface(typeface);
            textView4.setTypeface(typeface);
            textView5.setTypeface(typeface);
            textView6.setTypeface(typeface);
            textView7.setTypeface(typeface);
            textView8.setTypeface(typeface);
            textView.setText((CharSequence)resto2.getName());
            textView2.setText((CharSequence)resto2.getDesc());
            textView3.setText((CharSequence)resto2.getAdr());
            textView4.setText((CharSequence)resto2.getTel());
            textView6.setText((CharSequence)resto2.getMail());
            textView7.setText((CharSequence)resto2.getSite());
            textView5.setText((CharSequence)resto2.getFax());
            textView8.setText((CharSequence)resto2.getOuvert());
            return;
        }
        catch (Exception exception) {
            Toast.makeText((Context)this, (CharSequence)("Error aff: " + exception.getMessage()), (int)1).show();
            return;
        }
    }



    public void onBackPressed() {
        this.startActivity(new Intent((Context)this, list_resto.class));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_aff_resto);
        try {
            this.getSupportActionBar().hide();
        }
        catch (Exception exception) {}


        Bundle bundle2 = this.getIntent().getExtras();
        int n = 0;
        if (bundle2 != null) {
            n = bundle2.getInt("id");
        }
        this.affresto(n);
        ((Button)this.findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent((Context)aff_resto.this, Showmapss.class);
                intent.putExtra("un", (Serializable)aff_resto.this.un);
                intent.putExtra("deux", (Serializable)aff_resto.this.deux);
                intent.putExtra("name_place", aff_resto.this.nm);
                aff_resto.this.startActivity(intent);
            }
        });
    }

  /*  public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(2131623945, menu2);
        return true;
    }
*/
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131493266) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
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

