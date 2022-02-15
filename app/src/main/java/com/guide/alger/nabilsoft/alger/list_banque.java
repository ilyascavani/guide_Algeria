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

public class list_banque extends AppCompatActivity {
    private static final String TAG = list_banque.class.getSimpleName();

    int aa;
    int tb;

    class list_B extends BaseAdapter {
        Context contx;
        ArrayList<String> lstp;

        public list_B(Context cntx, ArrayList<String> ex) {
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
            View rowView = list_banque.this.getLayoutInflater().inflate(R.layout.row_aa, parent, false);
            TextView T1 = (TextView) rowView.findViewById(R.id.textView8);
            T1.setTypeface(Typeface.createFromAsset(list_banque.this.getAssets(), "font.ttf"));
            try {
                T1.setText((String) this.lstp.get(position));
            } catch (Exception rr) {
                Toast.makeText(list_banque.this, "Error : " + rr.getMessage(), (int) 1).show();
            }
            return rowView;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_banque);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.tb = b.getInt("tb");
            this.aa = b.getInt("aa");
        }
        Typeface face = Typeface.createFromAsset(getAssets(), "font2.ttf");
        TextView T1 = (TextView) findViewById(R.id.list_b);
        if (this.tb == 1) {
            if (this.aa == 1) {
                T1.setText("La List Des Directions De La Banque BADR");
            } else if (this.aa == 2) {
                T1.setText("La List Des Agences De La Banque BADR");
            }
        } else if (this.tb == 2) {
            if (this.aa == 1) {
                T1.setText("La List Des Directions De La Banque BDL");
            } else if (this.aa == 2) {
                T1.setText("La List Des Agences De La Banque BDL");
            }
        } else if (this.tb == 3) {
            if (this.aa == 1) {
                T1.setText("La List Des Directions De La Banque Societe Generale");
            } else if (this.aa == 2) {
                T1.setText("La List Des Agences De La Banque Societe Generale");
            }
        }
        T1.setTypeface(face);
        try {
            ListView lv = (ListView) findViewById(R.id.listView55);
            lv.setAdapter(new list_B(this, new DBConnection(this).get_AA_banque(this.tb, this.aa)));
            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    int idd = position + 1;
                    Intent intent = new Intent(list_banque.this, aff_banque.class);
                    intent.putExtra("tb", list_banque.this.tb);
                    intent.putExtra("aa", list_banque.this.aa);
                    intent.putExtra("id", idd);
                    list_banque.this.startActivity(intent);
                }
            });
        } catch (Exception rr) {
            Toast.makeText(this, "Error : " + rr.getMessage(), (int) 1).show();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, list_AAbanque.class);
        intent.putExtra("tb", this.tb);
        startActivity(intent);
    }
/*
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_banque, menu);
        return true;
    }*/

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