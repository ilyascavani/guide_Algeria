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

public class list_AAbanque extends AppCompatActivity {
    int tb;
    class list_AA extends BaseAdapter {
        Context contx;
        ArrayList<String> lstp;

        public list_AA(Context cntx, ArrayList<String> ex) {
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
            View rowView = list_AAbanque.this.getLayoutInflater().inflate(R.layout.row_aa, parent, false);
            TextView T1 = (TextView) rowView.findViewById(R.id.textView8);
            T1.setTypeface(Typeface.createFromAsset(list_AAbanque.this.getAssets(), "font.ttf"));
            try {
                T1.setText((String) this.lstp.get(position));
            } catch (Exception rr) {
                Toast.makeText(list_AAbanque.this, "Error : " + rr.getMessage(), (int) 1).show();
            }
            return rowView;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_aabanque);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.tb = b.getInt("tb");
        }
        ((TextView) findViewById(R.id.list_aab)).setTypeface(Typeface.createFromAsset(getAssets(), "font.ttf"));
        try {
            ListView lv = (ListView) findViewById(R.id.listView6);
            ArrayList<String> li = new ArrayList();
            li.add("Les Directions");
            li.add("Les Agences Bancaires");
            lv.setAdapter(new list_AA(this, li));
            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    int ht = position + 1;
                    Intent intent = new Intent(list_AAbanque.this, list_banque.class);
                    intent.putExtra("tb", list_AAbanque.this.tb);
                    intent.putExtra("aa", ht);
                    list_AAbanque.this.startActivity(intent);
                }
            });
        } catch (Exception rr) {
            Toast.makeText(this, "Error : " + rr.getMessage(), (int) 1).show();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, list_Tbanque.class));
    }

  /*  public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list__aabanque, menu);
        return true;
    }
*/
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