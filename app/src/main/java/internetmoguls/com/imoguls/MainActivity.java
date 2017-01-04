package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import INTERFACES.Register;
import POJO.detailsBean;
import propertiesPOJO.HotelDetail;
import propertiesPOJO.propertyBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {




    static Typeface tf;
    static Typeface tf2;

    TextView title;

    RecyclerView grid;
    SharedPreferences pref;
    SharedPreferences.Editor edit;

    List<HotelDetail> list;

    GridLayoutManager manager;

    PropertyAdapter adapter;

    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pref = getSharedPreferences("pree" , Context.MODE_PRIVATE);
        edit = pref.edit();


        title = (TextView)findViewById(R.id.title);


        progress = (ProgressBar)findViewById(R.id.progress);


        Intent intent = new Intent(this , NotificationServiceClass.class);
        //startService(intent);

        list = new ArrayList<>();
        manager = new GridLayoutManager(this , 1);

        grid = (RecyclerView)findViewById(R.id.property_list);


        adapter = new PropertyAdapter(this , list);

        tf = Typeface.createFromAsset(getAssets() , "roboto.ttf");
        tf2 = Typeface.createFromAsset(getAssets() , "vladmir.TTF");


        title.setTypeface(tf2);


        grid.setAdapter(adapter);

        grid.setLayoutManager(manager);




        progress.setVisibility(View.VISIBLE);





        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Register cr = retrofit.create(Register.class);

        final bean b = (bean)getApplicationContext();

        Call<detailsBean> call = cr.details(b.userId);


        edit.putString("id" , String.valueOf(b.userId));
        edit.apply();


        call.enqueue(new Callback<detailsBean>() {
            @Override
            public void onResponse(Call<detailsBean> call, Response<detailsBean> response) {

                b.username = response.body().getName();
                b.email = response.body().getEmail();







            }

            @Override
            public void onFailure(Call<detailsBean> call, Throwable t) {

            }
        });





        Call<propertyBean> call2 = cr.getProperties();

        call2.enqueue(new Callback<propertyBean>() {
            @Override
            public void onResponse(Call<propertyBean> call, Response<propertyBean> response) {


                adapter.setGridData(response.body().getHotelDetail());


                progress.setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<propertyBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });




/*

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
*/


            Intent intent1 = new Intent(this , NotifyService.class);
            startService(intent1);



    }


}
