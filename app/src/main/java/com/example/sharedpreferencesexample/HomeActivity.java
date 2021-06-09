package com.example.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView name, email;
    Button btnLogout;
    private static String SHAREDPREFERENCENAME = "myshared";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = findViewById(R.id.txtFullNameView);
        email = findViewById(R.id.txtEmailView);
        btnLogout = findViewById(R.id.btnLogout);
        //getting values
        sharedPreferences = getSharedPreferences(SHAREDPREFERENCENAME,MODE_PRIVATE);
        String sname = sharedPreferences.getString(KEY_NAME,"");
        String semail = sharedPreferences.getString(KEY_EMAIL,"");

        if (sname!= null || semail!=null){
            name.setText(sname);
            email.setText(semail);
            System.err.println(name);
            System.err.println(email);

        }
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this,"Data Cleared",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}