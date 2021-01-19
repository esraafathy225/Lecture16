package com.company.lecture16;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    final String FILE="com.esraa.hp.sharedpreferencesproject.my_file";
    Button load,clear,remove;
    TextView name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        load=findViewById(R.id.btn1);
        clear=findViewById(R.id.btn2);
        remove=findViewById(R.id.btn3);
        name=findViewById(R.id.txt1);
        email=findViewById(R.id.txt2);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE, Context.MODE_PRIVATE);
                String myName=sharedPreferences.getString("name","Not available");
                String myEmail=sharedPreferences.getString("email","Not available");
                name.setText(myName);
                email.setText(myEmail);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();

            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.remove("name");
                editor.apply();
            }
        });
    }
}
