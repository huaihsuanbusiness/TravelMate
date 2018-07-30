package com.huaihsuanhuang.TravelMate.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.huaihsuanhuang.TravelMate.Manifest;
import com.huaihsuanhuang.TravelMate.model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class DatabaseOrder extends SQLiteAssetHelper {
    private static final String DB_name = "TMDB.db";
    private static final String DB_path = "/Users/huaihsuanhuang/AndroidStudioProjects/TravelMate/app/src/main/assets/database/TMDB.db";
    private static final int DB_version = 1;
   // private SQLiteAssetHelper dbHelper;
    public DatabaseOrder(Context context) {
        super(context, DB_name, null, DB_version);
    }


    public List<Order> getcart() {
     //   SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_path, null,
        //               SQLiteDatabase.OPEN_READWRITE);
     //   SQLiteDatabase db = getWritableDatabase();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String sqlSelect[] = {"product_id", "product_name", "product_quantity", "product_price", "product_discount"};
        String sqltable = "Orderdetail";
        qb.setTables(sqltable);
      
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);

        final List<Order> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add(new Order(cursor.getString(cursor.getColumnIndex("product_id")),
                        cursor.getString(cursor.getColumnIndex("product_name")),
                        cursor.getString(cursor.getColumnIndex("product_quantity")),
                        cursor.getString(cursor.getColumnIndex("product_price")),
                        cursor.getString(cursor.getColumnIndex("product_discount"))));
            } while (cursor.moveToNext());
        }
        return result;
    }

    public void addtocart(Order order) {

        SQLiteDatabase db = getReadableDatabase();
      // SQLiteDatabase db = dbHelper.getWritableDatabase();
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_path, null,
//                SQLiteDatabase.OPEN_READWRITE);
        String query = String.format("INSERT OR REPLACE INTO Orderdetail(product_id,product_name,product_quantity,product_price, product_discount) VALUES ('%s','%s','%s','%s','%s');",
                order.getProduct_id(),
                order.getProduct_name(),
                order.getProduct_quantity(),
                order.getProduct_price(),
                order.getProduct_discount());
        db.execSQL(query);
    }

    public void clearcart() {
        SQLiteDatabase db = getWritableDatabase();
        String query = String.format("DELETE FROM OrderDetail;");
        db.execSQL(query);
    }
}


