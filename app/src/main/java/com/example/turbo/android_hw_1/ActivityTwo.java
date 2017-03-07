package com.example.turbo.android_hw_1;

import android.content.Intent;
import android.database.Cursor;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;


public class ActivityTwo extends AppCompatActivity {
    private static final int PICK_CONTACT_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TextView textView = (TextView) findViewById(R.id.textView2);
        Button button = (Button) findViewById(R.id.button2);



        if (getIntent().getExtras() != null) {
            textView.setText(getIntent().getExtras().getString("EXTRA_ONE", "NOTHING FOUND"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findContact();
            }
        });


    }

    private void findContact() {
        startActivityForResult(new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts")).setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE), PICK_CONTACT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CONTACT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();
                Toast.makeText(this, "Result = " + cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Access Denied", Toast.LENGTH_LONG).show();
            }

        }

    }
}