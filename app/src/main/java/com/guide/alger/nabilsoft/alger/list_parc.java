package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import android.os.Bundle;

public class list_parc extends AppCompatActivity {

    private static final String TAG = list_parc.class.getSimpleName();

    public void onBackPressed() {
        this.startActivity(new Intent((Context)this, MainActivity.class));
    }


    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_list_parc);
        try {
            this.getSupportActionBar().hide();
        }
        catch (Exception exception) {}

        try {
            Typeface typeface = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font2.ttf");
            ((TextView)this.findViewById(R.id.list_parc)).setTypeface(typeface);
            DBConnection dBConnection = new DBConnection((Context)this);
            ListView listView = (ListView)this.findViewById(R.id.listparc);
            listView.setAdapter((ListAdapter)new list_PR((Context)this, (ArrayList<parc>)dBConnection.get_all_parc()));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
                    int n2 = n + 1;
                    Intent intent = new Intent((Context)list_parc.this, Aff_parc.class);
                    intent.putExtra("id", n2);
                    list_parc.this.startActivity(intent);
                }
            });
            return;
        }
        catch (Exception exception) {
            Toast.makeText((Context)this, (CharSequence)("Error : " + exception.getMessage()), (int)1).show();
            return;
        }
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

    class list_PR
            extends BaseAdapter {
        Context contx;
        ArrayList<parc> lstp;

        public list_PR(Context context, ArrayList<parc> arrayList) {
            this.contx = context;
            this.lstp = arrayList;
        }

        public int getCount() {
            return this.lstp.size();
        }

        public Object getItem(int n) {
            return this.lstp.get(n);
        }

        public long getItemId(int n) {
            return n;
        }

        public View getView(int n, View view, ViewGroup viewGroup) {
            View view2 = list_parc.this.getLayoutInflater().inflate(R.layout.row_aa, viewGroup, false);
            Typeface typeface = Typeface.createFromAsset((AssetManager)list_parc.this.getAssets(), (String)"font.ttf");
            TextView textView = (TextView)view2.findViewById(R.id.textView8);
            textView.setTypeface(typeface);
            try {
                textView.setText((CharSequence)((parc)this.lstp.get((int)n)).name);
                return view2;
            }
            catch (Exception exception) {
                Toast.makeText((Context)list_parc.this, (CharSequence)("Error l : " + exception.getMessage()), (int)1).show();
                return view2;
            }
        }
    }
}