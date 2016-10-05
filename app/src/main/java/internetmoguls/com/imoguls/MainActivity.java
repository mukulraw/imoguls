package internetmoguls.com.imoguls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




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

            }

            @Override
            public void onFailure(Call<detailsBean> call, Throwable t) {

            }
        });




        asiana = (CardView)findViewById(R.id.asiana);
        elite = (CardView)findViewById(R.id.elite);
        continental = (CardView)findViewById(R.id.continental);




        asiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext() , Asiana.class);
                startActivity(i);
            }
        });

        elite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext() , Elite.class);
                startActivity(i);

            }
        });

        continental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext() , Continental.class);
                startActivity(i);

            }
        });




    }


}
