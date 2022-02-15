package com.guide.alger.nabilsoft.alger;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.net.MalformedURLException;
import java.net.URL;

public class aff_hotel extends AppCompatActivity {
    Double deux;

    int ht;
    int id;

    String nm;
    String phone;
    String site_web;
    Double un;



    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_hotel);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Button b1 =  findViewById(R.id.button13);
        Button b2 =  findViewById(R.id.button14);
        Button b3 =  findViewById(R.id.button15);
        Button b4 =  findViewById(R.id.button26);
        Typeface face1 = Typeface.createFromAsset(getAssets(), "Sukar.ttf");
        b1.setTypeface(face1);
        b2.setTypeface(face1);
        b3.setTypeface(face1);
        b1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (aff_hotel.this.phone.trim().equals("Non disponible.")) {
                    Toast.makeText(aff_hotel.this, "Numero de Telephone Non Disponible. !!", (int) 1).show();
                    return;
                }
             //  String numm = aff_hotel.this.phone.split("/")[0].trim().replace(" ", BuildConfig.FLAVOR);
               String numm = aff_hotel.this.phone.split("/")[0].trim().replace(" ", "");
                Intent inten = new Intent();
                inten.setAction("android.intent.action.DIAL");
                inten.setData(Uri.parse("tel:" + numm));
                inten.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                aff_hotel.this.startActivity(inten);
                aff_hotel.this.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", numm, null)));
            }
        });
        b2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(aff_hotel.this, Showmapss.class);
                intent.putExtra("un", aff_hotel.this.un);
                intent.putExtra("deux", aff_hotel.this.deux);
                intent.putExtra("name_place", aff_hotel.this.nm);
                aff_hotel.this.startActivity(intent);
            }
        });
        b4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(aff_hotel.this, Showmapss.class);
                intent.putExtra("un", aff_hotel.this.un);
                intent.putExtra("deux", aff_hotel.this.deux);
                intent.putExtra("name_place", aff_hotel.this.nm);
                aff_hotel.this.startActivity(intent);
            }
        });
        b3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    if (aff_hotel.this.site_web.trim().equals("Non disponible.")) {
                        Toast.makeText(aff_hotel.this, "Site Web Non Disponible. !!", (int) 1).show();
                        return;
                    }
                    aff_hotel.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aff_hotel.this.site_web.trim())));
                } catch (Exception hg) {
                    Toast.makeText(aff_hotel.this, hg.getMessage(), (int) 1).show();
                }
            }
        });
        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.ht = b.getInt("h");
            this.id = b.getInt("id");
        }
        try {
            hotel hot = new DBConnection(this).get_hotel(this.ht, this.id);
         //  this.un = Double.valueOf(Double.parseDouble(BuildConfig.FLAVOR + hot.un));
          // this.deux = Double.valueOf(Double.parseDouble(BuildConfig.FLAVOR + hot.deux));
            un =Double.valueOf(hot.un);
            deux  =Double.valueOf(hot.deux);
            this.nm = hot.getName();
            this.site_web = hot.getSite();
            this.phone = hot.getTelephone();
            ImageView img = (ImageView) findViewById(R.id.imageView3);
            ImageView img1 = (ImageView) findViewById(R.id.image1);
            ImageView img2 = (ImageView) findViewById(R.id.image2);
            ImageView img3 = (ImageView) findViewById(R.id.image3);
            TextView hname = (TextView) findViewById(R.id.hotelname);
            TextView desc = (TextView) findViewById(R.id.desc);
            TextView adr = (TextView) findViewById(R.id.adr);
            TextView fix = (TextView) findViewById(R.id.fix);
            TextView fax = (TextView) findViewById(R.id.fax);
            TextView mobile = (TextView) findViewById(R.id.mobile);
            TextView mail = (TextView) findViewById(R.id.mail);
            TextView site = (TextView) findViewById(R.id.siteweb);
            TextView pr = (TextView) findViewById(R.id.prix);
            TextView un = (TextView) findViewById(R.id.unit);
            TextView txtp = (TextView) findViewById(R.id.txtprix);
            ((LinearLayout) findViewById(R.id.l1)).setVisibility(View.VISIBLE);
            ((LinearLayout) findViewById(R.id.l2)).setVisibility(View.VISIBLE);
            RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
            Resources res = getResources();
            img.setBackgroundResource(res.getIdentifier(hot.img, "drawable", getPackageName()));
            String img11 = hot.img1;
            if (img11 != null) {
                img1.setBackgroundResource(res.getIdentifier(img11, "drawable", getPackageName()));
            } else {
                img1.setVisibility(View.INVISIBLE);
            }
            String img22 = hot.img2;
            if (img22 != null) {
                img2.setBackgroundResource(res.getIdentifier(img22, "drawable", getPackageName()));
            } else {
                img2.setVisibility(View.INVISIBLE);
            }
            String img33 = hot.img3;
            if (img33 != null) {
                img3.setBackgroundResource(res.getIdentifier(img33, "drawable", getPackageName()));
            } else {
                img3.setVisibility(View.INVISIBLE);
            }
            Typeface face = Typeface.createFromAsset(getAssets(), "font.ttf");
            Typeface face2 = Typeface.createFromAsset(getAssets(), "font2.ttf");
            hname.setTypeface(face);
            desc.setTypeface(face2);
            adr.setTypeface(face);
            fix.setTypeface(face);
            fax.setTypeface(face);
            mobile.setTypeface(face);
            mail.setTypeface(face);
            site.setTypeface(face);
            pr.setTypeface(face);
            un.setTypeface(face);
            txtp.setTypeface(face);
            hname.setText(hot.getName());
            desc.setText(hot.getDesc());
            adr.setText(hot.getAdr());
            fix.setText(hot.getTelephone());
            fax.setText(hot.getFax());
            mobile.setText(hot.getMobile());
            mail.setText(hot.getEmail());
            site.setText(hot.getSite());
            pr.setText(hot.getPrix());
            un.setText(hot.getUnit());
          //  ratingBar.setRating(Float.parseFloat(hot.getEt() + BuildConfig.FLAVOR));
            ratingBar.setRating(Float.parseFloat(hot.getEt() + ""));
        } catch (Exception rr) {
            Toast.makeText(this, "Error : " + rr.getMessage(), (int) 1).show();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, list_ht.class);
        intent.putExtra("h", this.ht);
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




/*
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_aff_hotel, menu);
        return true;
    }*/

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }









}
