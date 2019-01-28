package com.example.carmar04.proyectofinal;

public final class SQLSentences {

    public static final String DATABASE_NAME = "ComponentMarket";

    public static final String TABLE_USER = "User";
    public static final String TABLE_USER_ID = "id";
    public static final String TABLE_USER_NICKNAME = "nickname";
    public static final String TABLE_USER_PASSWORD = "password";
    public static final String TABLE_USER_MAIL = "mail";

    public static final String TABLE_PRODUCT = "Product";
    public static final String TABLE_PRODUCT_ID = "id";
    public static final String TABLE_PRODUCT_NAME = "name";
    public static final String TABLE_PRODUCT_STOCK = "stock";
    public static final String TABLE_PRODUCT_PRICE = "price";

    public static final String TABLE_ORDER = "Order";
    public static final String TABLE_ORDER_ID = "id";
    public static final String TABLE_ORDER_USER_ID = "user_id";

    public static final String TABLE_ORDER_LINE = "OrderLine";
    public static final String TABLE_ORDER_LINE_ID = "id";
    public static final String TABLE_ORDER_LINE_ORDER_ID = "order_id";
    public static final String TABLE_ORDER_LINE_PRODUCT_ID = "product_id";

    public static final String CREATE_TABLE_USER = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL) ",
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
                    "%s INTEGER NOT NULL, " +
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
                    "%s INTEGER NOT NULL REFERENCES %s (%s) ",

            TABLE_ORDER,
            TABLE_ORDER_ID,
            TABLE_ORDER_USER_ID,
            TABLE_USER,
            TABLE_USER_ID
    );

    public static final String CREATE_TABLE_ORDER_LINE = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s) ",
            TABLE_ORDER_LINE,
            TABLE_ORDER_LINE_ID,
            TABLE_ORDER_LINE_ORDER_ID,
            TABLE_ORDER,
            TABLE_ORDER_ID,
            TABLE_ORDER_LINE_PRODUCT_ID,
            TABLE_PRODUCT,
            TABLE_PRODUCT_ID
    );
}

