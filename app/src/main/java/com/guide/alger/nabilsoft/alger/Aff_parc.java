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

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.guide.alger.nabilsoft.alger.DBConnection;
import com.guide.alger.nabilsoft.alger.Showmapss;
import com.guide.alger.nabilsoft.alger.list_parc;
import com.guide.alger.nabilsoft.alger.parc;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;

public class Aff_parc extends AppCompatActivity {

    private static final String TAG = Aff_parc.class.getSimpleName();
    Double deux;

    String nm;
    Double un;


    public void affparc(int n) {
        try {
            parc parc2 = new DBConnection((Context)this).get_parc(n);
            ImageView imageView = (ImageView)this.findViewById(R.id.imgprc);
            TextView textView = (TextView)this.findViewById(R.id.descprc);
            TextView textView2 = (TextView)this.findViewById(R.id.txt3);
          // TextView textView3 = (TextView)this.findViewById(R.id.txt4);
            TextView textView4 = (TextView)this.findViewById(R.id.txt11);
            TextView textView5 = (TextView)this.findViewById(R.id.txt4);
            TextView textView6 = (TextView)this.findViewById(R.id.txt5);
            TextView textView7 = (TextView)this.findViewById(R.id.txt7);
            TextView textView8 = (TextView)this.findViewById(R.id.txt8);
            TextView textView9 = (TextView)this.findViewById(R.id.txt6);
            TextView textView10 = (TextView)this.findViewById(R.id.txt9);
            Button button = (Button)this.findViewById(R.id.parcbtn);
         //   imageView = (ImageView)this.findViewById(R.id.imgprc);
            imageView.setBackgroundResource(this.getResources().getIdentifier(parc2.img, "drawable", this.getPackageName()));

            imageView.setVisibility(View.VISIBLE);
            Typeface typeface = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font.ttf");
            Typeface typeface2 = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font2.ttf");
            this.un = Double.parseDouble((String)("" + parc2.un));
            this.deux = Double.parseDouble((String)("" + parc2.deux));
            this.nm = parc2.getName();
            textView.setTypeface(typeface);
            button.setTypeface(typeface);
          //  textView3.setTypeface(typeface);
            textView4.setTypeface(typeface);
            textView5.setTypeface(typeface);
            textView6.setTypeface(typeface);
            textView7.setTypeface(typeface);
            textView8.setTypeface(typeface);
            textView9.setTypeface(typeface);
            textView10.setTypeface(typeface);
            textView2.setTypeface(typeface2);
            textView.setText((CharSequence)parc2.getName());
            textView4.setText((CharSequence)parc2.getTarif());
            textView5.setText((CharSequence)parc2.getAdr());
            textView6.setText((CharSequence)parc2.getTel());
            textView7.setText((CharSequence)parc2.getMail());
            textView8.setText((CharSequence)parc2.getSite());
            textView9.setText((CharSequence)parc2.getFax());
            textView10.setText((CharSequence)parc2.getOuv());
            textView2.setText((CharSequence)parc2.getDesc());
            return;
        }
        catch (Exception exception) {
            Toast.makeText((Context)this, (CharSequence)("Error aff: " + exception.getMessage()), (int)1).show();
            return;
        }
    }



    public void onBackPressed() {
        this.startActivity(new Intent((Context)this, list_parc.class));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_aff_parc);
        try {
            this.getSupportActionBar().hide();
        }
        catch (Exception exception) {}

        Bundle bundle2 = this.getIntent().getExtras();
        int n = 0;
        if (bundle2 != null) {
            n = bundle2.getInt("id");
        }
        this.affparc(n);
        ((Button)this.findViewById(R.id.parcbtn)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent((Context)Aff_parc.this, Showmapss.class);
                intent.putExtra("un", (Serializable)Aff_parc.this.un);
                intent.putExtra("deux", (Serializable)Aff_parc.this.deux);
                intent.putExtra("name_place", Aff_parc.this.nm);
                Aff_parc.this.startActivity(intent);
            }
        });
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