package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
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

public class UpdateProfile extends AppCompatActivity {

    Toolbar toolbar;

    TextView update;
    EditText email , phone , address , name;
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    ProgressBar progress;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        pref = getSharedPreferences("pree" , Context.MODE_PRIVATE);
        edit = pref.edit();


        toolbar = (Toolbar) findViewById(R.id.toolbar);


        progress = (ProgressBar) findViewById(R.id.progress);

        toolbar.setTitle("Update profile");
        toolbar.setTitleTextColor(Color.WHITE);



        toolbar.setNavigationIcon(R.drawable.back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        update = (TextView) findViewById(R.id.update);

        progress.setVisibility(View.VISIBLE);

        updateDetails();



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                progress.setVisibility(View.VISIBLE);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://nationproducts.in/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Register cr = retrofit.create(Register.class);

                final bean b = (bean)getApplicationContext();

                String n = name.getText().toString();
                String e = email.getText().toString();
                String p = phone.getText().toString();
                String a = address.getText().toString();

                Call<updateBean> call = cr.update(String.valueOf(b.userId) , n , e , a , p);

                call.enqueue(new Callback<updateBean>() {
                    @Override
                    public void onResponse(Call<updateBean> call, Response<updateBean> response) {



                        updateDetails();


                    }

                    @Override
                    public void onFailure(Call<updateBean> call, Throwable t) {

                    }
                });



            }
        });




    }


    public void updateDetails()
    {




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
