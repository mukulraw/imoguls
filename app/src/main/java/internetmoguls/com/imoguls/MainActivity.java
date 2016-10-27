package internetmoguls.com.imoguls;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import INTERFACES.Register;
import POJO.detailsBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    CardView asiana , elite , continental;


    static Typeface tf;
    static Typeface tf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent = new Intent(this , NotificationServiceClass.class);
        startService(intent);




        tf = Typeface.createFromAsset(getAssets() , "roboto.ttf");
        tf2 = Typeface.createFromAsset(getAssets() , "vladmir.TTF");


        TextView tit1 = (TextView)findViewById(R.id.asiana_title);
        TextView tit2 = (TextView)findViewById(R.id.cont_title);
        TextView tit3 = (TextView)findViewById(R.id.elite_title);

        tit1.setTypeface(tf2);
        tit2.setTypeface(tf2);
        tit3.setTypeface(tf2);

        tit1.setTextSize(30);
        tit2.setTextSize(30);
        tit3.setTextSize(30);


        TextView con1 = (TextView)findViewById(R.id.asiana_content);
        TextView con2 = (TextView)findViewById(R.id.cont_con);
        TextView con3 = (TextView)findViewById(R.id.elite_con);


        con1.setTypeface(tf);
        con2.setTypeface(tf);
        con3.setTypeface(tf);


        asiana = (CardView)findViewById(R.id.asiana);
        elite = (CardView)findViewById(R.id.elite);
        continental = (CardView)findViewById(R.id.continental);


        asiana.setVisibility(View.GONE);
        elite.setVisibility(View.GONE);
        continental.setVisibility(View.GONE);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Register cr = retrofit.create(Register.class);

        final bean b = (bean)getApplicationContext();

        Call<detailsBean> call = cr.details(b.userId);

        call.enqueue(new Callback<detailsBean>() {
            @Override
            public void onResponse(Call<detailsBean> call, Response<detailsBean> response) {

                b.username = response.body().getName();
                b.email = response.body().getEmail();

                asiana.setVisibility(View.VISIBLE);
                continental.setVisibility(View.VISIBLE);
                elite.setVisibility(View.VISIBLE);


            }

            @Override
            public void onFailure(Call<detailsBean> call, Throwable t) {

            }
        });









        asiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext() , DefaultPage.class);
                i.putExtra("form" , "1");
                startActivity(i);
            }
        });

        elite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext() , DefaultPage.class);
                i.putExtra("form" , "3");
                startActivity(i);

            }
        });

        continental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext() , DefaultPage.class);
                i.putExtra("form" , "2");
                startActivity(i);

            }
        });




    }


}
