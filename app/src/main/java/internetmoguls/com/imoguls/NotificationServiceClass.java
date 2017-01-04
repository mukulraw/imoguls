package internetmoguls.com.imoguls;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import INTERFACES.Register;
import PROMO_POJO.Post;
import PROMO_POJO.promoBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class NotificationServiceClass extends Service {

    Timer timer;
    ConnectionDetector cd;

    private void doSomethingRepeatedly() {
        timer = new Timer();
        timer.scheduleAtFixedRate( new TimerTask() {
            public void run() {

                try{





                    if (cd.isConnectingToInternet())
                    {



                    }






                }
                catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }, 0, 1000*60);



    }


    @Override
    public void onCreate() {


        cd = new ConnectionDetector(getApplicationContext());
        doSomethingRepeatedly();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        //cd = new ConnectionDetector(getApplicationContext());




        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }
}
