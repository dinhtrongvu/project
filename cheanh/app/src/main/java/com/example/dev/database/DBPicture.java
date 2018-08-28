package com.example.dev.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dev.model.ItemRecycler;

import java.util.ArrayList;
import java.util.List;

public class DBPicture extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="dbpicture";
    public static final String TABLE_NAME="picture";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_IMG="img";
    public static final String COLUMN_FAVORITE="favorite";
    public static final String COLUMN_SAVE="save";

    public DBPicture(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_ID+" INTEGER PRIMARY KEY, "
                +COLUMN_IMG+ " INTEGER, " +COLUMN_FAVORITE+ " INTEGER, "+COLUMN_SAVE+ " INTEGER )";
        Log.d("dinhabc",sql);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public int getCount(){
        String sql="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        int count=cursor.getCount();
        cursor.close();
        return count;
    }
    public void createData(){
        int count=getCount();
        if(count==0) {
            ItemRecycler h1 = new ItemRecycler(1, 0, 0);
            ItemRecycler h2 = new ItemRecycler(1, 0, 0);
            ItemRecycler h3 = new ItemRecycler(1, 0, 0);
            ItemRecycler h4 = new ItemRecycler(1, 0, 0);
            ItemRecycler h5 = new ItemRecycler(1, 0, 0);
            ItemRecycler h6 = new ItemRecycler(1, 0, 0);
            ItemRecycler h7 = new ItemRecycler(1, 0, 0);
            ItemRecycler h15 = new ItemRecycler(2, 0, 0);
            ItemRecycler h16 = new ItemRecycler(2, 0, 0);
            ItemRecycler h17 = new ItemRecycler(2, 0, 0);
            ItemRecycler h12 = new ItemRecycler(3, 0, 0);
            ItemRecycler h13 = new ItemRecycler(3, 0, 0);
            ItemRecycler h14 = new ItemRecycler(3, 0, 0);
            ItemRecycler h8 = new ItemRecycler(4, 0, 0);
            ItemRecycler h9 = new ItemRecycler(4, 0, 0);
            ItemRecycler h10 = new ItemRecycler(4, 0, 0);
            ItemRecycler h11 = new ItemRecycler(4, 0, 0);
            addData(h1);
            addData(h2);
            addData(h3);
            addData(h4);
            addData(h5);
            addData(h6);
            addData(h7);
            addData(h8);
            addData(h9);
            addData(h10);
            addData(h11);
            addData(h12);
            addData(h13);
            addData(h14);
            addData(h15);
            addData(h16);
            addData(h17);
        }
    }
    public void addData(ItemRecycler ir){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMG, ir.getImg());
        values.put(COLUMN_FAVORITE, ir.getFavorite());
        values.put(COLUMN_SAVE, ir.getSave());
        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public List<ItemRecycler> getPicture(int img){
        List<ItemRecycler> list=new ArrayList<>();
        String sql="SELECT * FROM "+TABLE_NAME+" WHERE img= '"+img+"'" ;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do
            {
                ItemRecycler ir=new ItemRecycler();
                ir.setId(Integer.parseInt(cursor.getString(0)));
                ir.setImg(Integer.parseInt(cursor.getString(1)));
                ir.setFavorite(Integer.parseInt(cursor.getString(2)));
                ir.setSave(Integer.parseInt(cursor.getString(3)));
                list.add(ir);
            } while (cursor.moveToNext());
        }
        return list;
    }
}
