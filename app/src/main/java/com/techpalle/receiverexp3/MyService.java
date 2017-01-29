package com.techpalle.receiverexp3;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
        public MyService() {


        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            Bundle bundle = intent.getExtras();
            String name = bundle.getString("name");
            Toast.makeText(MyService.this, "name is ... "+name, Toast.LENGTH_SHORT).show();

            // trigger or start broadcast receiver use intent & sendbroadcast

            Intent intent1 = new Intent();
            intent1.setAction("WORK_DONE");
            sendBroadcast(intent1);

            //code over



            return super.onStartCommand(intent, flags, startId);
        }

        @Override
        public IBinder onBind(Intent intent) {
            // TODO: Return the communication channel to the service.
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
