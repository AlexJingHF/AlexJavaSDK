package com.alex.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by alex on 14-8-15.
 */
public class AndroidNetUtil {

    /**
     *
     * @param context
     * @return {@code true} if the network is available, {@code false} otherwise
     */
    public static boolean isNetworkAvailable(Context context){
        if (context != null){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null){
              return   networkInfo.isAvailable();
            }
        }
        return  false;
    };
}
