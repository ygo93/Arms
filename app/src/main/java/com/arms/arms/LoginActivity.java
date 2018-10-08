package com.arms.arms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arms.arms.view.ContainerActivity;
import com.arms.arms.view.CreateAccount;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view)
    {
        Intent intent=new Intent(this,CreateAccount.class);
        startActivity(intent);
    }

    public void goContentActivity(View view) {
        Intent intent2=new Intent(this,ContainerActivity.class);
        startActivity(intent2);
    }
}
