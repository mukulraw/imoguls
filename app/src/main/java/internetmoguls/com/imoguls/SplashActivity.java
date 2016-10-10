package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.Timer;
import java.util.TimerTask;

import INTERFACES.Register;
import POJO.RegisterBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences pref;
    static SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


       // Log.d("asdasdasd" , FirebaseInstanceId.getInstance().getToken());


        pref = getSharedPreferences("myPref" , Context.MODE_PRIVATE);
        edit = pref.edit();

        Boolean is = pref.getBoolean("email" , false);

        if (is)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register cr = retrofit.create(Register.class);

            Call<RegisterBean> call = cr.login(pref.getString("emailId" , null) , pref.getString("password" , null));

            call.enqueue(new Callback<RegisterBean>() {
                @Override
                public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {


                    if (response.body().getStatus().equals("4"))
                    {






                        bean b = (bean)getApplicationContext();

                        b.userId = response.body().getUserId();

                        Intent i = new Intent(getBaseContext() ,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                    if (response.body().getStatus().equals("2"))
                    {
                        bean b = (bean)getApplicationContext();

                        b.userId = response.body().getUserId();
                        Intent i = new Intent(getBaseContext() ,OTP_Activity.class);
                        startActivity(i);
                        finish();

                    }

                    if (response.body().getStatus().equals("1") || response.body().getStatus().equals("3"))
                    {
                        Toast.makeText(getApplicationContext() , "Invalid Email or password" , Toast.LENGTH_SHORT).show();
                    }





                }

                @Override
                public void onFailure(Call<RegisterBean> call, Throwable t) {

                }
            });
        }
        else
        {
            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    Intent i = new Intent(getBaseContext() , LoginActivity.class);

                    startActivity(i);

                    finish();

                }
            } , 1500);
        }







    }
}
