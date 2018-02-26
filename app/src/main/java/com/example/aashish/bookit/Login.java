package com.example.aashish.bookit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.accounts.AccountManager.KEY_PASSWORD;
import static android.accounts.AccountManager.KEY_USERDATA;

public class Login extends AppCompatActivity {

    EditText user,pass;
    Button login;
    TextView create;
    LoginDatabaseAdapter loginDatabaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
        create=(TextView)findViewById(R.id.create);
        loginDatabaseAdapter=new LoginDatabaseAdapter(this);
        loginDatabaseAdapter=loginDatabaseAdapter.open();


        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this,android.R.color.transparent));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=user.getText().toString();
                String password=pass.getText().toString();



                // fetch the Password form database for respective user name
                String storedPassword=loginDatabaseAdapter.getSinlgeEntry(name);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Login.this);
                    SharedPreferences.Editor ed = prefs.edit();
                    ed.putString("username", name);
                    ed.putString("password", password);
                    ed.commit();
                    Intent i=new Intent(Login.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }






            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(Login.this,Create.class);
                startActivity(i2);
            }
        });

    }


}
