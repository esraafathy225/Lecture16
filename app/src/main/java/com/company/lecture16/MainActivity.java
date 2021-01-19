package com.company.lecture16;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
 Button save,load,navigate;
 TextView name,email;
 Switch changeColour;
 LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        save=findViewById(R.id.btn1);
        load=findViewById(R.id.btn2);
        navigate=findViewById(R.id.btn3);
        name=findViewById(R.id.txt1);
        email=findViewById(R.id.txt2);
        changeColour=findViewById(R.id.changecolour);
        linearLayout=findViewById(R.id.layout);




        SharedPreferences sharedPreferences =getPreferences(Context.MODE_PRIVATE);
        boolean Switch=sharedPreferences.getBoolean("isChecked",false);
        if(Switch){
            changeColour.setChecked(true);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
        }
        else{
            changeColour.setChecked(false);
            linearLayout.setBackgroundColor(Color.parseColor("#F48FB1"));
        }




        final String FILE="com.esraa.hp.sharedpreferencesproject.my_file";

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SharedPreferences sharedPreferences=getSharedPreferences(FILE, Context.MODE_PRIVATE);
               SharedPreferences.Editor editor=sharedPreferences.edit();
               editor.putString("name",edit1.getText().toString());
               editor.putString("email",edit2.getText().toString());
               editor.apply();
            }
        });


        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE, Context.MODE_PRIVATE);

                String nameValue=sharedPreferences.getString("name","No data");
                String emailValue=sharedPreferences.getString("email","No data");

                name.setText(nameValue);
                email.setText(emailValue);

            }
        });

        changeColour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               SharedPreferences sharedPreferences =getPreferences(Context.MODE_PRIVATE);
               SharedPreferences.Editor editor=sharedPreferences.edit();
               editor.putBoolean("isChecked",b);
               editor.apply();
               if(b){
                 linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
               }
               else{
                   linearLayout.setBackgroundColor(Color.parseColor("#F48FB1"));
               }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(MainActivity.this,"Item 1", Toast.LENGTH_SHORT).show();break;
            case R.id.item2:
                Toast.makeText(MainActivity.this,"Item 2", Toast.LENGTH_SHORT).show();break;
            case R.id.item3:
                Toast.makeText(MainActivity.this,"Item 3", Toast.LENGTH_SHORT).show();break;
        }
        return super.onOptionsItemSelected(item);
    }
}
