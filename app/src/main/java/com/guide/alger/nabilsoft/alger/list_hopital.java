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

public class list_hopital extends AppCompatActivity {
    int hop;
    class list_hop extends BaseAdapter {
        Context contx;
        ArrayList<String> lstp;

        public list_hop(Context cntx, ArrayList<String> ex) {
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
            View rowView = list_hopital.this.getLayoutInflater().inflate(R.layout.row_aa, parent, false);
            TextView T1 = (TextView) rowView.findViewById(R.id.textView8);
            T1.setTypeface(Typeface.createFromAsset(list_hopital.this.getAssets(), "font.ttf"));
            try {
                T1.setText((String) this.lstp.get(position));
            } catch (Exception rr) {
                Toast.makeText(list_hopital.this, "Error : " + rr.getMessage(), (int) 1).show();
            }
            return rowView;
        }
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hopital);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.hop = b.getInt("id");
        }
        Typeface face = Typeface.createFromAsset(getAssets(), "font2.ttf");
        TextView T1 = (TextView) findViewById(R.id.list_hopital);
        if (this.hop == 1) {
            T1.setText("La List Des Hôpitaux Publics");
        } else if (this.hop == 2) {
            T1.setText("La List Des Cliniques Privées");
        }
        T1.setTypeface(face);
        try {
            ListView lv = (ListView) findViewById(R.id.listView16);
            lv.setAdapter(new list_hop(this, new DBConnection(this).get_all_hopital(this.hop)));
            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    int ht = position + 1;
                    Intent intent = new Intent(list_hopital.this, aff_hopital.class);
                    intent.putExtra("id", ht);
                    intent.putExtra("i", list_hopital.this.hop);
                    list_hopital.this.startActivity(intent);
                }
            });
        } catch (Exception rr) {
            Toast.makeText(this, "Error : " + rr.getMessage(), (int) 1).show();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, list_pp.class));
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