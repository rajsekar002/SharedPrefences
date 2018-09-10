package com.androindian.raj.sharedprefences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androindian.raj.sharedprefences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        activityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences=
                        getSharedPreferences("Login",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("Username",activityMainBinding.editText.getText().toString());
                editor.putString("Password",activityMainBinding.editText2.getText().toString());
                editor.commit();

            }
        });

        activityMainBinding.move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });
    }
}
