package dreamycoding.com.contact;

import android.graphics.Bitmap;

/**
 * Created by Juyel on 10/16/2017.
 */

public class Contact {
    private String name,phone;
    private Bitmap bitmap;

    public Contact() {
    }

    public Contact(String name, String phone, Bitmap bitmap) {
        this.name = name;
        this.phone = phone;
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
