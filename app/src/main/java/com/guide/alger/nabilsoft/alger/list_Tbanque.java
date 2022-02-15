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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import android.os.Bundle;

public class list_Tbanque extends AppCompatActivity {
    private static final String TAG = list_Tbanque.class.getSimpleName();
    class list_TB extends BaseAdapter {
        Context contx;
        ArrayList<banque> lstp;

        public list_TB(Context cntx, ArrayList<banque> ex) {
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
            View rowView = list_Tbanque.this.getLayoutInflater().inflate(R.layout.row_tb, parent, false);
            TextView T1 = (TextView) rowView.findViewById(R.id.textView22);
            ImageView img = (ImageView) rowView.findViewById(R.id.imageView26);
            T1.setTypeface(Typeface.createFromAsset(list_Tbanque.this.getAssets(), "font.ttf"));
            try {
                banque temp = (banque) this.lstp.get(position);
                T1.setText(temp.name);
                img.setBackgroundResource(list_Tbanque.this.getResources().getIdentifier(temp.img, "drawable", list_Tbanque.this.getPackageName()));
            } catch (Exception rr) {
                Toast.makeText(list_Tbanque.this, "Error : " + rr.getMessage(), (int) 1).show();
            }
            return rowView;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tbanque);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        ((TextView) findViewById(R.id.list_tb)).setTypeface(Typeface.createFromAsset(getAssets(), "font.ttf"));
        try {
            ListView lv = (ListView) findViewById(R.id.listView4);
            ArrayList<banque> li = new ArrayList();
            li.add(new banque("La Banque De l'Agriculture et Du Developpement Rural (BADR)", "banquebadr"));
            li.add(new banque("La Banque De Developpement Local (BDL)", "banquebdl"));
            li.add(new banque("La Banque Societe Generale", "banquesg"));
            lv.setAdapter(new list_TB(this, li));
            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    int ht = position + 1;
                    Intent intent = new Intent(list_Tbanque.this, list_AAbanque.class);
                    intent.putExtra("tb", ht);
                    list_Tbanque.this.startActivity(intent);
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