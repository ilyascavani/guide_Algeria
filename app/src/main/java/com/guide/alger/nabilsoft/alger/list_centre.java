package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.guide.alger.nabilsoft.alger.DBConnection;
//import com.guide.alger.nabilsoft.alger.Main;
//import com.guide.alger.nabilsoft.alger.aff_centre;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.os.Bundle;

public class list_centre extends AppCompatActivity {



        class list_cen extends BaseAdapter {
            Context contx;
            ArrayList<String> lstp;

            public list_cen(Context cntx, ArrayList<String> ex) {
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
                View rowView = list_centre.this.getLayoutInflater().inflate(R.layout.row_aa, parent, false);
                TextView T1 = (TextView) rowView.findViewById(R.id.textView8);
                T1.setTypeface(Typeface.createFromAsset(list_centre.this.getAssets(), "font.ttf"));
                try {
                    T1.setText((String) this.lstp.get(position));
                } catch (Exception rr) {
                    Toast.makeText(list_centre.this, "Error : " + rr.getMessage(), (int)1).show();
                }
                return rowView;
            }
        }




        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_centre);

            ((TextView) findViewById(R.id.list_centre)).setTypeface(Typeface.createFromAsset(getAssets(), "font2.ttf"));
            try {
                ListView lv = (ListView) findViewById(R.id.listView14);
                lv.setAdapter(new list_cen(this, new DBConnection(this).get_all_centre()));
                lv.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        int ht = position + 1;
                        Intent intent = new Intent(list_centre.this, aff_centre.class);
                        intent.putExtra("id", ht);
                        list_centre.this.startActivity(intent);
                    }
                });
            } catch (Exception rr) {
                Toast.makeText(this, "Error : " + rr.getMessage(), (int)1).show();
            }
        }


    }

