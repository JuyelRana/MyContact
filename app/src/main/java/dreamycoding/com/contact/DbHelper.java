package dreamycoding.com.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juyel on 10/16/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, Config.DB_NAME, null, Config.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        db.execSQL(Config.TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addContact(ContactModel model) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        //Store student data to database
        cv.put(Config.NAME, model.getName());
        cv.put(Config.PHONE, model.getPhoneNumber());
        cv.put(Config.IMAGE, DbBitmapUtility.getBytes(model.getBitmap()));

        long inserted = database.insert(Config.TABLE_NAME, "", cv);
        database.close();

        return inserted;
    }

    public List<Contact> getAllContact() {
        List<Contact> contactList = new ArrayList<Contact>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(Config.SELECT_SQL, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setName(cursor.getString(1));
                contact.setPhone(cursor.getString(2));
                contact.setBitmap(DbBitmapUtility.getImage(cursor.getBlob(3)));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

}
