package com.taisys.sc.mobileid;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by sunny.sun on 2017/11/24.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("FCM", "onMessageReceived:"+remoteMessage.getFrom());
        Map<String, String> messageData = remoteMessage.getData();
        if (messageData!=null && messageData.size()>0){
            for(Map.Entry<String, String> entry : messageData.entrySet()) {
                String keyName = entry.getKey();
                String valueString = entry.getValue();
                Log.d("FCM", "Message data, key=" + keyName + ", value=" + valueString);
            }
        }else{
            Log.d("FCM", "No Message data");
        }
    }
}