package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import INTERFACES.Register;
import POJO.detailsBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class UserProfile extends AppCompatActivity {

    Toolbar toolbar;

    ProgressBar progress;

    TextView name , email , phone , address , update;
    SharedPreferences pref;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        progress = (ProgressBar)findViewById(R.id.progress);

        pref = getSharedPreferences("pree" , Context.MODE_PRIVATE);
        edit = pref.edit();


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        phone = (TextView)findViewById(R.id.phone);
        address = (TextView)findViewById(R.id.address);
        update = (TextView)findViewById(R.id.update);




        toolbar.setTitle("Profile");
        toolbar.setTitleTextColor(Color.WHITE);



        toolbar.setNavigationIcon(R.drawable.back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , UpdateProfile.class);
                startActivity(intent);

            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();

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



                name.setText(response.body().getName());
                email.setText(response.body().getEmail());
                phone.setText(response.body().getNumber());
                address.setText(response.body().getAddress());

                progress.setVisibility(View.GONE);




            }

            @Override
            public void onFailure(Call<detailsBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });






    }
}
