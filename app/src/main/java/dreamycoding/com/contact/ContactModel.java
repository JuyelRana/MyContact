package dreamycoding.com.contact;

import android.graphics.Bitmap;

/**
 * Created by Juyel on 10/16/2017.
 */

public class ContactModel {
    private String name,phoneNumber;
    private Bitmap bitmap;

    public ContactModel() {
    }

    public ContactModel(String name, String phoneNumber, Bitmap bitmap) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
