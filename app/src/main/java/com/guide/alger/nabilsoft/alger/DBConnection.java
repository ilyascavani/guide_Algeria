package com.guide.alger.nabilsoft.alger;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
public class DBConnection extends SQLiteOpenHelper {
    static final String BDname = "Algerguide.db";
    private static final String DB_PATH = "/data/data/com.guide.alger.nabilsoft.alger/databases/";
    static final int version = 3;
    public SQLiteDatabase myDataBase;

    private Context mycontext = null;
    public DBConnection(Context context) {
        super(context, BDname, null, 3);
        this.mycontext = context;
    }
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void opendatabase() {
        String mypth  = mycontext.getDatabasePath(BDname).getPath();
        if (myDataBase != null && myDataBase.isOpen()) {
            return;
        }
        myDataBase = SQLiteDatabase.openDatabase(mypth , null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void close() {
        if (myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }


    public centre get_centre(int id) {
        try {
            opendatabase();
            Cursor res = this.myDataBase.rawQuery("SELECT * FROM centre where id =" + id, null);
            res.moveToFirst();
            if (!res.isAfterLast()) {
                return new centre(res.getFloat(res.getColumnIndex("un")), res.getFloat(res.getColumnIndex("deux")), res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("desc")), res.getString(res.getColumnIndex("ouvr")), res.getString(res.getColumnIndex("adr")), res.getString(res.getColumnIndex("tel")), res.getString(res.getColumnIndex("fax")), res.getString(res.getColumnIndex("email")), res.getString(res.getColumnIndex("site")));
            }
        } catch (Exception rr) {
            Toast.makeText(this.mycontext, " " + rr.getMessage(), (int) 1).show();
        }
        centre centre = null;
        return null;
    }
    public ArrayList get_all_centre() {
        ArrayList arrayList = new ArrayList();
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT name FROM centre ", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }
    public ArrayList get_all_resto() {
        ArrayList arrayList = new ArrayList();
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT name,img FROM restaurant", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)new resto(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img"))));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }
    /*
    public ArrayList get_all_justice() {
        ArrayList arrayList = new ArrayList();
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT name,img FROM justice ", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)new justice(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img"))));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }
















    public justice get_tribunal(int n) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM justice where id =" + n, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                justice justice2 = new justice(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img")), cursor.getString(cursor.getColumnIndex("desc")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")));
                return justice2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
   */


    public assurance get_assurance(int n, int n2) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM assurance where tp =" + n + " AND id =  " + n2, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                assurance assurance2 = new assurance(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("desc")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")));
                return assurance2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public ArrayList get_AA_banque(int tb, int aa) {
        ArrayList<String> ar = new ArrayList();
        try {
            opendatabase();
            Cursor res = this.myDataBase.rawQuery("SELECT name FROM banque where tb =" + tb + " AND aa = " + aa, null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                ar.add(res.getString(res.getColumnIndex("name")));
                res.moveToNext();
            }
        } catch (Exception rr) {
            Toast.makeText(this.mycontext, " " + rr.getMessage(), (int) 1).show();
        }
        return ar;
    }
    public banque get_banque(int n, int n2, int n3) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM banque where tb =" + n + " AND aa =  " + n2 + " AND id =  " + n3, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                banque banque2 = new banque(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("desc")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")), cursor.getString(cursor.getColumnIndex("img")));
                return banque2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public th get_th(int n) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM th where id =" + n, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                th th2 = new th(cursor.getFloat(cursor.getColumnIndex("un")), cursor.getFloat(cursor.getColumnIndex("deux")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img")), cursor.getString(cursor.getColumnIndex("desc")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")));
                return th2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public ArrayList get_all_hopital(int n) {
        ArrayList arrayList = new ArrayList();
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT name FROM sante where tp =" + n, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }
    public hopital get_hopital(int n, int n2) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM sante where tp =" + n + " AND id =  " + n2, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                hopital hopital2 = new hopital(cursor.getFloat(cursor.getColumnIndex("un")), cursor.getFloat(cursor.getColumnIndex("deux")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("desc")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")));
                return hopital2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public musee get_musee(int n) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM musee where id =" + n, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                musee musee2 = new musee(cursor.getFloat(cursor.getColumnIndex("un")), cursor.getFloat(cursor.getColumnIndex("deux")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img")), cursor.getString(cursor.getColumnIndex("desc")), cursor.getString(cursor.getColumnIndex("prix")), cursor.getString(cursor.getColumnIndex("ouv")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")));
                return musee2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public cinema get_cinema(int n) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM cinema where id =" + n, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                cinema cinema2 = new cinema(cursor.getFloat(cursor.getColumnIndex("un")), cursor.getFloat(cursor.getColumnIndex("deux")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img")), cursor.getString(cursor.getColumnIndex("prix")), cursor.getString(cursor.getColumnIndex("ouv")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")));
                return cinema2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public ArrayList get_all_th() {
        ArrayList<String> ar = new ArrayList();
        try {
            opendatabase();
            Cursor res = this.myDataBase.rawQuery("SELECT name FROM th ", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                ar.add(res.getString(res.getColumnIndex("name")));
                res.moveToNext();
            }
        } catch (Exception rr) {
            Toast.makeText(this.mycontext, " " + rr.getMessage(), (int) 1).show();
        }
        return ar;
    }
    public ArrayList get_all_musee() {
        ArrayList arrayList = new ArrayList();
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT name FROM musee ", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }
    public parc get_parc(int n) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM parc where id =" + n, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                parc parc2 = new parc(cursor.getFloat(cursor.getColumnIndex("un")), cursor.getFloat(cursor.getColumnIndex("deux")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img")), cursor.getString(cursor.getColumnIndex("desc")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")), cursor.getString(cursor.getColumnIndex("trf")), cursor.getString(cursor.getColumnIndex("ouvr")));
                return parc2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public ArrayList get_all_parc() {
        ArrayList arrayList = new ArrayList();
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT name FROM parc ", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)new parc(cursor.getString(cursor.getColumnIndex("name"))));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }
    public ArrayList get_all_plage() {
        ArrayList arrayList = new ArrayList();
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT name,img FROM plage ", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)new plage(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img"))));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }
    public plage get_plage(int n) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM plage where id =" + n, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                plage plage2 = new plage(cursor.getString(cursor.getColumnIndex("name")), cursor.getFloat(cursor.getColumnIndex("un")), cursor.getFloat(cursor.getColumnIndex("deux")), cursor.getString(cursor.getColumnIndex("img")), cursor.getString(cursor.getColumnIndex("desc")));
                return plage2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public resto get_resto(int n) {
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT * FROM restaurant where id =" + n, null);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                resto resto2 = new resto(cursor.getFloat(cursor.getColumnIndex("un")), cursor.getFloat(cursor.getColumnIndex("deux")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("img")), cursor.getString(cursor.getColumnIndex("desc")), cursor.getString(cursor.getColumnIndex("ouvert")), cursor.getString(cursor.getColumnIndex("adr")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("fax")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("site")));
                return resto2;
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" bdd" + exception.getMessage()), (int)1).show();
        }
        return null;
    }
    public ArrayList get_all_assurance(int n) {
        ArrayList arrayList = new ArrayList();
        try {
            opendatabase();
            Cursor cursor = myDataBase.rawQuery("SELECT name FROM assurance where tp =" + n, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }

    public ArrayList get_all_hotel(int et) {
        ArrayList<hotel> ar = new ArrayList();
        try {
            opendatabase();
            Cursor res = this.myDataBase.rawQuery("SELECT * FROM hotel where et =" + et, null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                ar.add(new hotel(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("img"))));
                res.moveToNext();
            }
        } catch (Exception rr) {
            Toast.makeText(this.mycontext, " " + rr.getMessage(), (int) 1).show();
        }
        return ar;
    }
    public ArrayList get_all_cinema() {
        ArrayList arrayList = new ArrayList();
        try {
            this.opendatabase();
            Cursor cursor = this.myDataBase.rawQuery("SELECT name FROM cinema ", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add((Object)cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
        }
        catch (Exception exception) {
            Toast.makeText((Context)this.mycontext, (CharSequence)(" " + exception.getMessage()), (int)1).show();
        }
        return arrayList;
    }
    public hotel get_hotel(int et, int id) {
        try {
            opendatabase();
            Cursor res = this.myDataBase.rawQuery("SELECT * FROM hotel where et =" + et + " AND id =  " + id, null);
            res.moveToFirst();
            if (!res.isAfterLast()) {
                return new hotel(res.getString(res.getColumnIndex("name")), res.getFloat(res.getColumnIndex("un")), res.getFloat(res.getColumnIndex("deux")), res.getString(res.getColumnIndex("adr")), res.getInt(res.getColumnIndex("et")), res.getString(res.getColumnIndex("img")), res.getString(res.getColumnIndex("prix")), res.getString(res.getColumnIndex("unit")), res.getString(res.getColumnIndex("telephone")), res.getString(res.getColumnIndex("mobile")), res.getString(res.getColumnIndex("fax")), res.getString(res.getColumnIndex("email")), res.getString(res.getColumnIndex("siteweb")), res.getString(res.getColumnIndex("desc")), res.getString(res.getColumnIndex("img1")), res.getString(res.getColumnIndex("img2")), res.getString(res.getColumnIndex("img3")));
            }
        } catch (Exception rr) {
            Toast.makeText(this.mycontext, " " + rr.getMessage(), (int)1).show();
        }
        hotel hotel = null;
        return null;
    }

}
