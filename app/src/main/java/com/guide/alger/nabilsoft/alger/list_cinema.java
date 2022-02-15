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

public class list_cinema extends AppCompatActivity {


    class list_ci extends BaseAdapter {
        Context contx;
        ArrayList<String> lstp;

        public list_ci(Context cntx, ArrayList<String> ex) {
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
            View rowView = list_cinema.this.getLayoutInflater().inflate(R.layout.row_aa, parent, false);
            TextView T1 = (TextView) rowView.findViewById(R.id.textView8);
            T1.setTypeface(Typeface.createFromAsset(list_cinema.this.getAssets(), "font.ttf"));
            try {
                T1.setText((String) this.lstp.get(position));
            } catch (Exception rr) {
                Toast.makeText(list_cinema.this, "Error : " + rr.getMessage(), (int) 1).show();
            }
            return rowView;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cinema);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }


        try {
            ((TextView) findViewById(R.id.list_cinema)).setTypeface(Typeface.createFromAsset(getAssets(), "font2.ttf"));
            ListView lv = (ListView) findViewById(R.id.listView11);
            lv.setAdapter(new list_ci(this, new DBConnection(this).get_all_cinema()));
            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    int ht = position + 1;
                    Intent intent = new Intent(list_cinema.this, aff_cinema.class);
                    intent.putExtra("id", ht);
                    list_cinema.this.startActivity(intent);
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
}