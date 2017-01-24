package internetmoguls.com.imoguls;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.Html;
import android.util.Log;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import INTERFACES.Register;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import singlePOJO.Offer;
import singlePOJO.singleBean;


public class NotifyService extends Service {

    Timer timer;
    ConnectionDetector cd;

    private void doSomethingRepeatedly() {
        timer = new Timer();
        timer.scheduleAtFixedRate( new TimerTask() {
            public void run() {

                try{





                    if (cd.isConnectingToInternet())
                    {
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://nationproducts.in/")
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        Register cr = retrofit.create(Register.class);

                        Call<singleBean> call = cr.getSingle(pref.getString("id" , ""));


                        call.enqueue(new Callback<singleBean>() {
                            @Override
                            public void onResponse(Call<singleBean> call, Response<singleBean> response) {

                                if (response.body().getOffers()!=null) {

                                    Log.d("asdasdasdadadasds"  ,  "Notification called");


                                    List<Offer> list = response.body().getOffers();


                                    if (list.size() > 0) {

                                        if (list.size() == 1) {

                                            addNotification(list.get(0).getText(), list.get(0).getDescription());

                                        } else
                                        {

                                            addNotification2("You have " + String.valueOf(list.size()) + " new Notifications");

                                        }


                                    }

                                }

                            }

                            @Override
                            public void onFailure(Call<singleBean> call, Throwable t) {

                            }
                        });


                    }






                }
                catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }, 0, 1000);



    }


    private void addNotification(String message , String text) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.back)
                        .setContentTitle(message)
                        .setContentText(Html.fromHtml(text));

        Intent notificationIntent = new Intent(this, PromoCodeActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }


    private void addNotification2(String message) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.back)
                        .setContentTitle(message);

        Intent notificationIntent = new Intent(this, PromoCodeActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }




    SharedPreferences pref;


    @Override
    public void onCreate() {

        pref = getSharedPreferences("pree" , Context.MODE_PRIVATE);
        cd = new ConnectionDetector(getApplicationContext());


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("Asdadadadad" , "Service called");

        doSomethingRepeatedly();

        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        receive r = new receive();
        unregisterReceiver(r);


    }
}
