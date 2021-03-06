package com.example.simon.instantmessengerapp.gcmClasses;

import android.content.Context;
import android.util.Log;

import com.example.simon.instantmessengerapp.R;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;

import java.io.IOException;

/**
 * Created by Christian on 23.03.2018.
 */

public class MyInstanceIDListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        Context context = getApplicationContext();
        InstanceID instanceID = InstanceID.getInstance(context);
        try {
            String token = instanceID.getToken(context.getString(R.string.gcm_defaultSenderId), GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
        }
        catch(IOException e){
            Log.e("Token", e.getMessage());
        }
        //send token to app server
    }
}
