package internetmoguls.com.imoguls;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    RecyclerView grid;

    List<HotelDetail> list;

    GridLayoutManager manager;

    PropertyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent = new Intent(this , NotificationServiceClass.class);
        //startService(intent);

        list = new ArrayList<>();
        manager = new GridLayoutManager(this , 1);

        grid = (RecyclerView)findViewById(R.id.property_list);


        adapter = new PropertyAdapter(this , list);

        tf = Typeface.createFromAsset(getAssets() , "roboto.ttf");
        tf2 = Typeface.createFromAsset(getAssets() , "vladmir.TTF");




        grid.setAdapter(adapter);

        grid.setLayoutManager(manager);








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



            }

            @Override
            public void onFailure(Call<propertyBean> call, Throwable t) {

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



    }


}
