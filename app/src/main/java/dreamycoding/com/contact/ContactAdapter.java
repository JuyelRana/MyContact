package dreamycoding.com.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Juyel on 10/16/2017.
 */

public class ContactAdapter extends BaseAdapter {

    private Context context;
    private List<Contact> contactList;
    private LayoutInflater inflater;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        ImageView contactImage = (ImageView) convertView.findViewById(R.id.imageShowView);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);

        txtName.setText(contactList.get(position).getName().toString());
        txtPhone.setText(contactList.get(position).getPhone().toString());
        contactImage.setImageBitmap(contactList.get(position).getBitmap());

        return convertView;
    }
}
