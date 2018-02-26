package com.example.aashish.bookit;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {

    EditText username,email,create_pass,retype,phone;
    Button create_button;

    LoginDatabaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.toolbar));
        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDatabaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get Refferences of Views
        username=(EditText)findViewById(R.id.username);
        create_pass=(EditText)findViewById(R.id.create_pass);
        retype=(EditText)findViewById(R.id.retype);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.phone);

        create_button=(Button)findViewById(R.id.create_button);
        create_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String userName=username.getText().toString();
                String password=create_pass.getText().toString();
                String confirmPassword=retype.getText().toString();
                String phone_num=phone.getText().toString();
                String email_id=email.getText().toString();

                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName, password,phone_num,email_id);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
