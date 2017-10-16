package dreamycoding.com.contact;

import android.graphics.Bitmap;

/**
 * Created by Juyel on 10/16/2017.
 */

public class Config {
    //Database name
    public static final String DB_NAME = "mycontact";

    //Database version
    public static final int VERSION = 1;

    //Database table name
    public static final String TABLE_NAME = "contact";

    // all the column name
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String IMAGE = "image";

    public static final String TABLE_SQL = "CREATE TABLE " +
            TABLE_NAME + " (" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT, " +
            PHONE + " TEXT, " +
            IMAGE + " BLOB)";

    public static final String SELECT_SQL = "SELECT * FROM " +
            TABLE_NAME + " ORDER BY " +
            ID + " DESC";
}
