package com.example.jobapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=findViewById(R.id.submitbtn);
        text=findViewById(R.id.editplace);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String place=text.getText().toString();
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pre",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("key",place);
                editor.apply();
                Intent intent=new Intent(getApplicationContext(),Parsingactivity.class);
                if (place.equals(""))
                {
                  text.setError("Enter the place");
                }
                else
                {
                    startActivity(intent);
                }

            }
        });


    }
}
