package com.huaihsuanhuang.TravelMate.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.huaihsuanhuang.TravelMate.model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database_order extends SQLiteAssetHelper {
    private static final String DB_name="TravelMateDB.db";
    private static final int DB_version =1;
    public Database_order(Context context) {
        super(context,DB_name,null,DB_version);
    }

   public List<Order> getcart(){

        SQLiteDatabase db =getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String sqlSelect[] = {"product_id", "product_name", "product_quantity","product_price", "product_discount"};
        String sqltable="Orderdetail";
        qb.setTables(sqltable);
        //TODO 呼叫DB檔案？
        Cursor cursor =qb.query(db,sqlSelect,null,null,null,null,null);

final List<Order> result = new ArrayList<>();
if (cursor.moveToFirst()){
    do{
        result.add(new Order(cursor.getString(cursor.getColumnIndex("product_id")),
                cursor.getString(cursor.getColumnIndex("product_name")),
                 cursor.getString(cursor.getColumnIndex("product_quantity")),
                cursor.getString(cursor.getColumnIndex("product_price")),
                cursor.getString(cursor.getColumnIndex("product_discount"))));
    }while(cursor.moveToNext());
}
return result;
    }

    public void addtocart(Order order){
SQLiteDatabase db = getReadableDatabase();
String query = String.format("INSERT INTO Orderdetail(product_id,product_name,product_quantity,product_price, product_discount) VALUS (%s,%s,%s,%s,%s);",
        order.getProduct_id(),order.getProduct_name(),order.getProduct_quantity(),order.getProduct_price(),order.getProduct_discount());
db.execSQL(query);
    }

    public void clearcart(){
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM OrderDetail;");
        db.execSQL(query);
    }
}
