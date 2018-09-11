package com.androindian.raj.sharedprefences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Broad extends AppCompatActivity implements NetworkConnectivity.ConnectivityReceiverListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TestNetwork.getInstance().setConnectivityListener(this);
    }

    @Override
    protected void onPause() {
        TestNetwork.getInstance().resetConnectivityListener(null);
        super.onPause();
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if(isConnected){
            Toast.makeText(getApplicationContext(),
                    "Net is there", Toast.LENGTH_LONG).show();
            Log.i("Result","Net is there");
        }else {
            Toast.makeText(getApplicationContext(),
                    "Net is not there", Toast.LENGTH_LONG).show();
            Log.i("Result","Net is not there");
        }

    }
}