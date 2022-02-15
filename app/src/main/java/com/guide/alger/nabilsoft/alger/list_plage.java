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

import com.guide.alger.nabilsoft.alger.plage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import android.os.Bundle;

public class list_plage extends AppCompatActivity {

    private static final String TAG = list_plage.class.getSimpleName();




    public void onBackPressed() {
        this.startActivity(new Intent((Context)this, MainActivity.class));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_list_plage);
        try {
            this.getSupportActionBar().hide();
        }
        catch (Exception exception) {}


        try {
            Typeface typeface = Typeface.createFromAsset((AssetManager)this.getAssets(), (String)"font2.ttf");
            ((TextView)this.findViewById(R.id.TextView25)).setTypeface(typeface);
            DBConnection dBConnection = new DBConnection((Context)this);
            ListView listView = (ListView)this.findViewById(R.id.listplage);
            listView.setAdapter((ListAdapter)new list_lp((Context)this, (ArrayList<plage>)dBConnection.get_all_plage()));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
                    int n2 = n + 1;
                    Intent intent = new Intent((Context)list_plage.this, aff_plage.class);
                    intent.putExtra("id", n2);
                    list_plage.this.startActivity(intent);
                }
            });
            return;
        }
        catch (Exception exception) {
            Toast.makeText((Context)this, (CharSequence)("Error : " + exception.getMessage()), (int)1).show();
            return;
        }
    }


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

    class list_lp
            extends BaseAdapter {
        Context contx;
        ArrayList<plage> lstp;

        public list_lp(Context context, ArrayList<plage> arrayList) {
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
            View view2 = list_plage.this.getLayoutInflater().inflate(R.layout.row_aa, viewGroup, false);
            Typeface typeface = Typeface.createFromAsset((AssetManager)list_plage.this.getAssets(), (String)"font.ttf");
            TextView textView = (TextView)view2.findViewById(R.id.textView8);
            textView.setTypeface(typeface);
            try {
                textView.setText((CharSequence)((plage)this.lstp.get((int)n)).name);
                return view2;
            }
            catch (Exception exception) {
                Toast.makeText((Context)list_plage.this, (CharSequence)("Error : " + exception.getMessage()), (int)1).show();
                return view2;
            }
        }
    }
}