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
                        getCodes();
                    }






                }
                catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }, 0, 1000*60);
    }


    private void getCodes()
    {





        bean b = (bean)getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Register cr = retrofit.create(Register.class);

        Call<promoBean> call = cr.getPromo2(b.userId , "android");

        call.enqueue(new Callback<promoBean>() {
            @Override
            public void onResponse(Call<promoBean> call, Response<promoBean> response) {


                if (response.body().getPosts()!=null)
                {

                    int size = response.body().getPosts().size();

                    if (size == 1)
                    {
                        NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(getApplicationContext())
                                        .setSmallIcon(R.mipmap.ic_launcher2)
                                        .setContentTitle(response.body().getPosts().get(0).getPost().getTitle())
                                        .setContentText(response.body().getPosts().get(0).getPost().getVoucherCode())
                                .setContentInfo(response.body().getPosts().get(0).getPost().getDescription());

                        Intent resultIntent = new Intent(getApplicationContext(), PromoCodeActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
                        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
// Adds the back stack for the Intent (but not the Intent itself)
                        stackBuilder.addParentStack(PromoCodeActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
                        stackBuilder.addNextIntent(resultIntent);
                        PendingIntent resultPendingIntent =
                                stackBuilder.getPendingIntent(
                                        0,
                                        PendingIntent.FLAG_UPDATE_CURRENT
                                );
                        mBuilder.setContentIntent(resultPendingIntent);
                        NotificationManager mNotificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
                        mNotificationManager.notify(123, mBuilder.build());
                    }




                    if (size>1)
                    {
                        NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(getApplicationContext())
                                        .setSmallIcon(R.mipmap.ic_launcher2)
                                        .setContentTitle("You have "+ String.valueOf(size) +" new Promo Codes");

                        Intent resultIntent = new Intent(getApplicationContext(), PromoCodeActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
                        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
// Adds the back stack for the Intent (but not the Intent itself)
                        stackBuilder.addParentStack(PromoCodeActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
                        stackBuilder.addNextIntent(resultIntent);
                        PendingIntent resultPendingIntent =
                                stackBuilder.getPendingIntent(
                                        0,
                                        PendingIntent.FLAG_UPDATE_CURRENT
                                );
                        mBuilder.setContentIntent(resultPendingIntent);
                        NotificationManager mNotificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
                        mNotificationManager.notify(123, mBuilder.build());



                    }





                }












            }

            @Override
            public void onFailure(Call<promoBean> call, Throwable t) {

            }
        });
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        cd = new ConnectionDetector(getApplicationContext());

        doSomethingRepeatedly();
        return null;
    }
}
