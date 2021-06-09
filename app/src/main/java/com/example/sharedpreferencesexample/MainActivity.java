package com.example.sharedpreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtEmail;
    Button btnSave;
    SharedPreferences sharedPreferences;

    private static String SHAREDPREFERENCENAME = "myshared";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEmail =  findViewById(R.id.txtUserEmail);
        txtName = findViewById(R.id.txtUsername);
        btnSave = findViewById(R.id.btnSave);

        sharedPreferences = getSharedPreferences(SHAREDPREFERENCENAME,MODE_PRIVATE);

        //check whether sharedprefernce available at when opening the app
        String name = sharedPreferences.getString(KEY_NAME,null);
        if(name !=null){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String email = txtEmail.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(KEY_NAME,name);
                editor.putString(KEY_EMAIL,email);
                editor.apply();
                editor.commit();
                Toast.makeText(MainActivity.this,"Data Save Success",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }
        });
    }
}