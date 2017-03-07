package com.example.turbo.android_hw_1;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MyScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = "Портретная";
                        String s1 = "Горизонтальная";
                        Intent intent = new Intent(MyScreen.this, ActivityTwo.class);
                        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                            intent.putExtra("EXTRA_ONE", s);

                        } else {
                            intent.putExtra("EXTRA_ONE", s1);

                        }
                        startActivity(intent);
                    }
                }
        );
    }
}