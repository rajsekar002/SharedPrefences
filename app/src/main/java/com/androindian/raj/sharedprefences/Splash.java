package com.androindian.raj.sharedprefences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences preferences=
                        getSharedPreferences("Login",MODE_PRIVATE);

                String s1=preferences.getString("Username","");
                String s2=preferences.getString("Password","");

                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("Useremail","abc@gmail.com");
                editor.putString("add","hyd");
                editor.commit();
                if(s1.equals("") && s2.equals("")) {

                    Intent intent = new Intent(getApplicationContext(),
                            MainActivity.class);

                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getApplicationContext(),
                            NextActivity.class);

                    startActivity(intent);
                }
            }
        },4000);
    }
}
