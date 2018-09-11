package com.androindian.raj.sharedprefences;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class NetworkConnectivity extends BroadcastReceiver {
    public static ConnectivityReceiverListener connectivityReceiverListener;
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isConnected=isnetworkok();
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
    }

    public  boolean isnetworkok(){
        ConnectivityManager manager= (ConnectivityManager) TestNetwork.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager!=null){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Network[] network = manager.getAllNetworks();
                NetworkInfo info=manager.getActiveNetworkInfo();
                if (info!=null&&info.isConnectedOrConnecting()){
                    return true;
                }
               /* if (network.length >= 0) {
                    for (Network mntework : network) {
                        info = manager.getNetworkInfo(mntework);
                        if (info.getState().equals(NetworkInfo.State.CONNECTED)) {
                            return true;
                        }
                    }
                }*/
            }else {
                NetworkInfo[] networkInfos = manager.getAllNetworkInfo();
                if (networkInfos != null) {
                    for (NetworkInfo info : networkInfos) {
                        if (info.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }
}
