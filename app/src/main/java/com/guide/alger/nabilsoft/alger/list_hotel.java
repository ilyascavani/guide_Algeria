package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.Menu;


public class list_hotel extends AppCompatActivity {
    private static final String TAG = list_hotel.class.getSimpleName();

    class list_h extends BaseAdapter {
        Context contx;
        ArrayList<cat_h> lstp;

        public list_h(Context cntx, ArrayList<cat_h> ex) {
            this.contx = cntx;
            this.lstp = ex;
        }

        public int getCount() {
            return this.lstp.size();
        }

        public Object getItem(int h) {
            return this.lstp.get(h);
        }

        public long getItemId(int h) {
            return (long) h;
        }

        public View getView(int position, View convertView, ViewGroup parent) {


            View rowView = list_hotel.this.getLayoutInflater().inflate(R.layout.row_cat_h, parent, false);
            TextView T1 = (TextView) rowView.findViewById(R.id.textView3);
            RatingBar ratingBar = (RatingBar) rowView.findViewById(R.id.ratingBar2);
            T1.setTypeface(Typeface.createFromAsset(list_hotel.this.getAssets(), "font.ttf"));
            try {
              //  cat_h temp = (cat_h) this.lstp.get(position);
                cat_h temp=lstp.get(position);
                T1.setText(temp.name);
                if (temp.et == 2) {
                    ratingBar.setRating(2.0f);
                } else if (temp.et == 3) {
                    ratingBar.setRating(3.0f);
                } else if (temp.et == 4) {
                    ratingBar.setRating(4.0f);
                } else if (temp.et == 5) {
                    ratingBar.setRating(5.0f);
                }
            } catch (Exception rr) {
                Toast.makeText(list_hotel.this, "Error : " + rr.getMessage(), (int)1).show();
            }
            return rowView;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hotel);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }


        ((TextView) findViewById(R.id.list_hot)).setTypeface(Typeface.createFromAsset(getAssets(), "font2.ttf"));
        try {
            ListView lv = (ListView) findViewById(R.id.listView5);
            ArrayList<cat_h> li = new ArrayList();
            li.add(new cat_h("Hôtels 2 Etoiles", 2));
            li.add(new cat_h("Hôtels 3 Etoiles", 3));
            li.add(new cat_h("Hôtels 4 Etoiles", 4));
            li.add(new cat_h("Hôtels 5 Etoiles", 5));
            lv.setAdapter(new list_h(this, li));
            lv.setOnItemClickListener(new OnItemClickListener()  {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    int ht = position + 2;
                    Intent intent = new Intent(list_hotel.this, list_ht.class);
                    intent.putExtra("h", ht);
                    list_hotel.this.startActivity(intent);
                }
            });
        } catch (Exception rr) {
            Toast.makeText(this, "Error : " + rr.getMessage(), (int) 1).show();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
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
        getMenuInflater().inflate(R.menu.menu_list_hotel, menu);
        return true;
    }*/

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}