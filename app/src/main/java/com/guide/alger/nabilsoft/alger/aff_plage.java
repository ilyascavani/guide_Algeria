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
import com.guide.alger.nabilsoft.alger.Showmapss;
import com.guide.alger.nabilsoft.alger.list_plage;
import com.guide.alger.nabilsoft.alger.plage;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;

public class aff_plage extends AppCompatActivity {

    private static final String TAG = aff_plage.class.getSimpleName();
    Double deux;

    String nm;
    Double un;









    public void aff_plg(int n) {
        try {
            plage plage2 = new DBConnection((Context)this).get_plage(n);
            TextView textView = (TextView)this.findViewById(R.id.plagename);
            TextView textView2 = (TextView)this.findViewById(R.id.plagdesc);
            ImageView imageView = (ImageView)this.findViewById(R.id.plagimg);
            Button button = (Button)this.findViewById(R.id.plgbtn);
            imageView.setBackgroundResource(this.getResources().getIdentifier(plage2.img, "drawable", this.getPackageName()));
            Typeface typeface = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font.ttf");
            Typeface typeface2 = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font2.ttf");
            textView.setTypeface(typeface);
            button.setTypeface(typeface);
            textView2.setTypeface(typeface2);
            this.nm = plage2.getName();
            this.un = Double.parseDouble((String)("" + plage2.un));
            this.deux = Double.parseDouble((String)("" + plage2.deux));
            textView.setText((CharSequence)plage2.getName());
            textView2.setText((CharSequence)plage2.getDesc());
            return;
        }
        catch (Exception exception) {
            Toast.makeText((Context)this, (CharSequence)("Error aff: " + exception.getMessage()), (int)1).show();
            return;
        }
    }


    public void onBackPressed() {
        this.startActivity(new Intent((Context)this, list_plage.class));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_aff_plage);
        try {
            this.getSupportActionBar().hide();
        }
        catch (Exception exception) {}

        ((Button)this.findViewById(R.id.plgbtn)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent((Context)aff_plage.this, Showmapss.class);
                intent.putExtra("un", (Serializable)aff_plage.this.un);
                intent.putExtra("deux", (Serializable)aff_plage.this.deux);
                intent.putExtra("name_place", aff_plage.this.nm);
                aff_plage.this.startActivity(intent);
            }
        });
        Bundle bundle2 = this.getIntent().getExtras();
        int n = 0;
        if (bundle2 != null) {
            n = bundle2.getInt("id");
        }
        this.aff_plg(n);
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