package com.example.android.sunshine.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

public class ListenerService extends WearableListenerService {


       @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        Log.d("DataChange","11111");

        for(DataEvent dataEvent : dataEventBuffer ){

            if(dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                DataMap dataMap = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap();
                String path = dataEvent.getDataItem().getUri().getPath();
                if (path.equals("/wearable_data")) {

                    String weatherId = dataMap.getString("weatherId");
                    String highTemp = dataMap.getString("highTemp");
                    String lowTemp = dataMap.getString("lowTemp");
                    int timeStamp = dataMap.getInt("timeStamp");


                    Log.d("Listener service:", weatherId + " " + highTemp + " " + lowTemp);



                }
            }

        }

    }
}
