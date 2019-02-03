package com.example.carmar04.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class SQLSentences {

    public static final String DATABASE_NAME = "ComponentMarket";
    public static final int DATABASE_VERSION = 5;

    public static final String TABLE_USER = "Users";
    public static final String TABLE_USER_ID = "id";
    public static final String TABLE_USER_NICKNAME = "nickname";
    public static final String TABLE_USER_PASSWORD = "password";
    public static final String TABLE_USER_MAIL = "mail";

    public static final String TABLE_PRODUCT = "Products";
    public static final String TABLE_PRODUCT_ID = "id";
    public static final String TABLE_PRODUCT_NAME = "name";
    public static final String TABLE_PRODUCT_STOCK = "stock";
    public static final String TABLE_PRODUCT_PRICE = "price";

    public static final String TABLE_ORDER = "Orders";
    public static final String TABLE_ORDER_ID = "id";
    public static final String TABLE_ORDER_USER_ID = "user_id";
    public static final String TABLE_ORDER_ARTICLES_AMOUNT = "articles";
    public static final String TABLE_ORDER_TOTAL_AMOUNT = "amount";

    public static final String TABLE_ORDER_LINE = "OrderLines";
    public static final String TABLE_ORDER_LINE_ID = "id";
    public static final String TABLE_ORDER_LINE_ORDER_ID = "order_id";
    public static final String TABLE_ORDER_LINE_PRODUCT_ID = "product_id";

    public static final String CREATE_TABLE_USER = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT ) ",
            TABLE_USER,
            TABLE_USER_ID,
            TABLE_USER_NICKNAME,
            TABLE_USER_PASSWORD,
            TABLE_USER_MAIL
    );

    public static final String CREATE_TABLE_PRODUCT = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL, " +
                    "%s DOUBLE NOT NULL)",
            TABLE_PRODUCT,
            TABLE_PRODUCT_ID,
            TABLE_PRODUCT_NAME,
            TABLE_PRODUCT_STOCK,
            TABLE_PRODUCT_PRICE
    );

    public static final String CREATE_TABLE_ORDER = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL, " +
                    "%s DOUBLE NOT NULL)",
            TABLE_ORDER,
            TABLE_ORDER_ID,
            TABLE_ORDER_USER_ID,
            TABLE_USER,
            TABLE_USER_ID,
            TABLE_ORDER_ARTICLES_AMOUNT,
            TABLE_ORDER_TOTAL_AMOUNT
    );

    public static final String CREATE_TABLE_ORDER_LINE = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s)) ",
            TABLE_ORDER_LINE,
            TABLE_ORDER_LINE_ID,
            TABLE_ORDER_LINE_ORDER_ID,
            TABLE_ORDER,
            TABLE_ORDER_ID,
            TABLE_ORDER_LINE_PRODUCT_ID,
            TABLE_PRODUCT,
            TABLE_PRODUCT_ID
    );
    public static final String FILL_TABLE_PRODUCT =
            String.format("INSERT INTO %s (%s, %s, %s) VALUES " +
                            "('AMD Radeon RX580 GIGABYTE', 'stock', 198.70), " +
                            "('AMD Radeon RX580 ASUS', 'stock', 223.60), " +
                            "('AMD Radeon RX580 SAPPHIRE', 'stock', 198.70), " +
                            "('NVIDIA GTX 1060 ASUS', 'stock', 270.70), " +
                            "('NVIDIA GTX 1060 GIGABYTE', 'stock', 258.40), " +
                            "('NVIDIA GTX 1060 MSI', 'stock', 298.70), " +
                            "('AMD Radeon RX64 GIGABYTE', 'stock', 498.10), " +
                            "('NVIDIA GTX 1080 GIGABYTE', 'stock', 530.70)",

                    TABLE_PRODUCT,
                    TABLE_PRODUCT_NAME,
                    TABLE_PRODUCT_STOCK,
                    TABLE_PRODUCT_PRICE
            );

    public static class DatabaseHelper {
        private Context context = null;
        private DataBaseHelperInternal helperInternal = null;
        private SQLiteDatabase database = null;

        public DatabaseHelper(Context context){
            this.context = context;
        }
        private class DataBaseHelperInternal extends SQLiteOpenHelper{
            DataBaseHelperInternal(Context context, String databaseName, int databaseVersion){
                super(context, databaseName, null, databaseVersion);
            }
            @Override
            public void onCreate(SQLiteDatabase db) {
                createTables(db);
                fillTables(db);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                deleteTables(db);
                createTables(db);
                fillTables(db);
            }

            private void createTables(SQLiteDatabase db){
                db.execSQL(SQLSentences.CREATE_TABLE_USER);
                db.execSQL(SQLSentences.CREATE_TABLE_PRODUCT);
                db.execSQL(SQLSentences.CREATE_TABLE_ORDER);
                db.execSQL(SQLSentences.CREATE_TABLE_ORDER_LINE);
            }

            private void deleteTables(SQLiteDatabase db){
                db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_USER);
                db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_PRODUCT);
                db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_ORDER);
                db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_ORDER_LINE);
            }

            private void fillTables(SQLiteDatabase db){
                db.beginTransaction();
                try{
                    db.execSQL(SQLSentences.FILL_TABLE_PRODUCT);
                    db.setTransactionSuccessful();
                }finally{
                    db.endTransaction();
                }
            }
        }
        public DatabaseHelper open(){
            helperInternal = new DataBaseHelperInternal(this.context, SQLSentences.DATABASE_NAME, SQLSentences.DATABASE_VERSION);
            database = helperInternal.getReadableDatabase();
            return this;
        }

        public void close(){
            helperInternal.close();
        }
        public Cursor getItems(String sqlQuery , String [] selectionArgs){
            return database.rawQuery(sqlQuery, selectionArgs);
        }

        public void insertItem(String sqlQuery){
            database.execSQL(sqlQuery);
        }
        public void drop(){
            this.context.deleteDatabase(DATABASE_NAME);
        }
    }
}