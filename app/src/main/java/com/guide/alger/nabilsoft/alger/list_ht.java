package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.os.Bundle;

public class list_ht extends AppCompatActivity {

    private static final String TAG = list_ht.class.getSimpleName();

    int ht;


    /* renamed from: com.guide.alger.nabilsoft.alger.list_ht$4 */


    class list_htt extends BaseAdapter {
        Context contx;
        ArrayList<hotel> lstp;

        public list_htt(Context cntx, ArrayList<hotel> ex) {
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
            View rowView = list_ht.this.getLayoutInflater().inflate(R.layout.row_aa, parent, false);
            TextView T1 = (TextView) rowView.findViewById(R.id.textView8);
            T1.setTypeface(Typeface.createFromAsset(list_ht.this.getAssets(), "font.ttf"));
            try {
                T1.setText(((hotel) this.lstp.get(position)).name);
            } catch (Exception rr) {
                Toast.makeText(list_ht.this, "Error : " + rr.getMessage(), (int) 1).show();
            }
            return rowView;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ht);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }


        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.ht = b.getInt("h");
        }
        Typeface face = Typeface.createFromAsset(getAssets(), "font2.ttf");
        TextView T1 = (TextView) findViewById(R.id.list_hotel);
        T1.setText("La List Des Hôtels " + this.ht + " Etoiles");
        T1.setTypeface(face);
        try {
            ListView lv = (ListView) findViewById(R.id.listView2);
            lv.setAdapter(new list_htt(this, new DBConnection(this).get_all_hotel(this.ht)));
            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    int idd = position + 1;
                    Intent intent = new Intent(list_ht.this, aff_hotel.class);
                    intent.putExtra("h", list_ht.this.ht);
                    intent.putExtra("id", idd);
                    list_ht.this.startActivity(intent);
                }
            });
        } catch (Exception rr) {
            Toast.makeText(this, "Error : " + rr.getMessage(), (int) 1).show();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, list_hotel.class));
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
        getMenuInflater().inflate(R.menu.menu_list_ht, menu);
        return true;
    }*/

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}