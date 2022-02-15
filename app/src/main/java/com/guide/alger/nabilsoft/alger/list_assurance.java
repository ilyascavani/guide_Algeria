package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;

import android.os.Bundle;


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

public class list_assurance extends AppCompatActivity {
    private static final String TAG = list_assurance.class.getSimpleName();
    int ta;




    class list_A extends BaseAdapter {
        Context contx;
        ArrayList<String> lstp;

        public list_A(Context cntx, ArrayList<String> ex) {
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
            View rowView = list_assurance.this.getLayoutInflater().inflate(R.layout.row_aa, parent, false);
            TextView T1 = (TextView) rowView.findViewById(R.id.textView8);
            T1.setTypeface(Typeface.createFromAsset(list_assurance.this.getAssets(), "font.ttf"));
            try {
                T1.setText((String) this.lstp.get(position));
            } catch (Exception rr) {
                Toast.makeText(list_assurance.this, "Error : " + rr.getMessage(), (int) 1).show();
            }
            return rowView;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_assurance);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }

        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.ta = b.getInt("ta");
        }
        Typeface face = Typeface.createFromAsset(getAssets(), "font2.ttf");
        TextView T1 = (TextView) findViewById(R.id.list_assurance);
        if (this.ta == 1) {
            T1.setText("La List Des Agences D'Alliance Assurances");
        } else if (this.ta == 2) {
            T1.setText("La List Des Agences D'Axa Assurances");
        } else if (this.ta == 3) {
            T1.setText("La List Des Agences de Salama Assurances");
        } else if (this.ta == 4) {
            T1.setText("La List Des Agences De 2A Assurances");
        }
        T1.setTypeface(face);
        try {
            ListView lv = (ListView) findViewById(R.id.listView8);
            lv.setAdapter(new list_A(this, new DBConnection(this).get_all_assurance(this.ta)));
            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    int ht = position + 1;
                    Intent intent = new Intent(list_assurance.this, aff_assurance.class);
                    intent.putExtra("ta", list_assurance.this.ta);
                    intent.putExtra("id", ht);
                    list_assurance.this.startActivity(intent);
                }
            });
        } catch (Exception rr) {
            Toast.makeText(this, "Error : " + rr.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, list_a.class));
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