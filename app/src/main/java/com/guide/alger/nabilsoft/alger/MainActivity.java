package com.guide.alger.nabilsoft.alger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copy_bdd(this);

      /*  File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if(false == database.exists()) {
            mDBHelper.getReadableDatabase();
            //Copy db
            if(copyDatabase(this)) {
                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }*/
        try {
            this.getSupportActionBar().hide();
        }
        catch (Exception exception) {}
         Button button2 = findViewById(R.id.btn1);
        Button button3 = findViewById(R.id.btn2);
        Button button = findViewById(R.id.btn7);
        Button button4 = findViewById(R.id.btn3);
        Button button5 = findViewById(R.id.btn4);
        Button button6 = findViewById(R.id.btn5);
        Button button7 = findViewById(R.id.btn6);
        Button button8 = findViewById(R.id.btn8);
        Button button9 = findViewById(R.id.btn9);
        Button button10 = findViewById(R.id.btn10);
        Button button11 = findViewById(R.id.btn11);
        Button button12 = findViewById(R.id.btn12);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_centre.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_hotel.class);
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_resto.class);
                startActivity(intent);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_plage.class);
                startActivity(intent);

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_parc.class);
                startActivity(intent);

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_cinema.class);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_musee.class);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_pp.class);
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_th.class);
                startActivity(intent);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_Tbanque.class);
                startActivity(intent);
            }
        });


        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, list_a.class);
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent((Context) MainActivity.this, about.class);
                startActivity(intent);
            }
        });

    }
 //   copy_bdd(this);
  public boolean copy_bdd(Context cnt) {
        try {
            InputStream inputStream = cnt.getAssets().open("Algerguide.db");
            String outfile = "/data/data/com.guide.alger.nabilsoft.alger/databases/Algerguide.db";
            File databaseFile = new File("/data/data/com.guide.alger.nabilsoft.alger/databases");
            if (!databaseFile.exists()) {
                databaseFile.mkdir();
            }
            FileOutputStream outputStream = new FileOutputStream(outfile);
            byte[] buffer = new byte[1024];
            while (true) {
                int length = inputStream.read(buffer);
                if (length > 0) {
                    outputStream.write(buffer, 0, length);
                } else {
                    outputStream.flush();
                    outputStream.close();
                    return true;
                }
            }
        } catch (Exception rt) {
            Toast.makeText(this, "err copy bdd  / " + rt.getMessage(), (int)1).show();
            return false;
        }
    }

   /* public boolean copy_bdd(Context context) {
        try {
            int n;
            InputStream inputStream = context.getAssets().open("Algerguide.db");
            File file = new File("/data/data/com.guide.alger.nabilsoft.alger/databases");
            if (!file.exists()) {
                file.mkdir();
            }
            FileOutputStream fileOutputStream = new FileOutputStream("/data/data/com.guide.alger.nabilsoft.alger/databases/Algerguide.db");
            byte[] arrby = new byte[1024];
            while ((n = inputStream.read(arrby)) > 0) {
                fileOutputStream.write(arrby, 0, n);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        }
        catch (Exception exception) {
            Toast.makeText((Context)this, (CharSequence)("err copy bdd  / " + exception.getMessage()), (int)1).show();
            return false;
        }
    }*/


  // final Button button = (Button).findViewById(R.id.btn1);
}