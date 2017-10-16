package dreamycoding.com.contact;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int GALLERY_REQUEST = 1;
    private FloatingActionButton floatingActionButton;
    private ImageView imageView;

    private DbHelper dbHelper;

    private ListView listView;
    private ContactAdapter contactAdapter;
    private List<Contact> contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        listView = (ListView) findViewById(R.id.listView);

        floatingActionButton.setOnClickListener(floatingActionButtonClickListener);

        contactList = new ArrayList<Contact>();

        if (dbHelper.getAllContact() != null) {
            contactList = dbHelper.getAllContact();
            contactAdapter = new ContactAdapter(getApplicationContext(), contactList);
            listView.setAdapter(contactAdapter);
        } else {
            Toast.makeText(this, "Empty Contact", Toast.LENGTH_SHORT).show();
        }

    }

    View.OnClickListener floatingActionButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            customDialog();
        }
    };

    private void customDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("Add Contact");

        final EditText etName = (EditText) dialog.findViewById(R.id.etName);
        final EditText etPhone = (EditText) dialog.findViewById(R.id.etPhone);
        Button btnSelectImage = (Button) dialog.findViewById(R.id.btnSelect);
        imageView = (ImageView) dialog.findViewById(R.id.imageView);
        Button btnAddContact = (Button) dialog.findViewById(R.id.btnAddContact);
        Button btnCancelContact = (Button) dialog.findViewById(R.id.btnCancel);


        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });


        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ContactModel model = new ContactModel(etName.getText().toString(), etPhone.getText().toString(), bitmap);

                if (dbHelper.addContact(model) == -1) {
                    Toast.makeText(MainActivity.this, "Contact not added to sql!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Contact successfully added!!", Toast.LENGTH_SHORT).show();
                }
                contactAdapter.notifyDataSetChanged();
            }
        });

        btnCancelContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void pickImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQUEST) {

                Uri selectedImageURI = data.getData();

                Picasso.with(MainActivity.this).load(selectedImageURI).noPlaceholder().centerCrop().fit()
                        .into(imageView);
            }

        }
    }
}
