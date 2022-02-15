package com.guide.alger.nabilsoft.alger;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.guide.alger.nabilsoft.alger.DBConnection;
import com.guide.alger.nabilsoft.alger.MainActivity;
import com.guide.alger.nabilsoft.alger.aff_resto;
import com.guide.alger.nabilsoft.alger.resto;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class list_resto extends AppCompatActivity {
    private static final String TAG = list_resto.class.getSimpleName();


    public void onBackPressed() {
        this.startActivity(new Intent((Context)this, MainActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_list_resto);
        try {
            this.getSupportActionBar().hide();
        }
        catch (Exception exception) {}


      //  Typeface typeface = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font2.ttf");
        ((TextView) findViewById(R.id.TextView20)).setTypeface(Typeface.createFromAsset(getAssets(), "font2.ttf"));
        try {
            ListView listView = (ListView)this.findViewById(R.id.listresto);
            listView.setAdapter((ListAdapter)new list_rest((Context)this, (ArrayList<resto>)new DBConnection((Context)this).get_all_resto()));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
                    int n2 = n + 1;
                    Intent intent = new Intent((Context)list_resto.this, aff_resto.class);
                    intent.putExtra("id", n2);
                    list_resto.this.startActivity(intent);
                }
            });
            return;
        }
        catch (Exception exception) {
            Toast.makeText((Context)this, (CharSequence)("Error list : " + exception.getMessage()), (int)1).show();
            return;
        }
    }
/*
    public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(2131623962, menu2);
        return true;
    }*/

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131493266) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
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

    class list_rest extends BaseAdapter {
        Context contx;
        ArrayList<resto> lstp;

        public list_rest(Context context, ArrayList<resto> arrayList) {
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
            View view2 = list_resto.this.getLayoutInflater().inflate(R.layout.row_aa, viewGroup, false);
            Typeface typeface = Typeface.createFromAsset((AssetManager)list_resto.this.getAssets(), (String)"font.ttf");
            TextView textView = (TextView)view2.findViewById(R.id.textView8);
            textView.setTypeface(typeface);
            try {
                textView.setText((CharSequence)((resto)this.lstp.get((int)n)).name);
                return view2;
            }
            catch (Exception exception) {
                Toast.makeText((Context)list_resto.this, (CharSequence)("Error : " + exception.getMessage()), (int)1).show();
                return view2;
            }
        }
    }

}

