package internetmoguls.com.imoguls;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import INTERFACES.Register;
import PROMO_POJO.Post;
import PROMO_POJO.promoBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class PromoCodeActivity extends AppCompatActivity {


    List<Post> list;
    PromoAdapter adapter;
    RecyclerView grid;
    GridLayoutManager manager;
    int flag = 0;
    static Typeface tf2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_code);


        toolbar = (Toolbar) findViewById(R.id.toolbar);


        toolbar.setTitle("Notifications");
        toolbar.setTitleTextColor(Color.WHITE);



        toolbar.setNavigationIcon(R.drawable.back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tf2 = Typeface.createFromAsset(getAssets() , "vladmir.TTF");







        manager = new GridLayoutManager(this , 1);
        grid = (RecyclerView)findViewById(R.id.promo_list);
        grid.setLayoutManager(manager);

        list = new ArrayList<>();

        adapter = new PromoAdapter(this , list);
        grid.setAdapter(adapter);

        bean b = (bean)getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Register cr = retrofit.create(Register.class);

        Call<promoBean> call = cr.getPromo(b.userId);

        call.enqueue(new Callback<promoBean>() {
            @Override
            public void onResponse(Call<promoBean> call, Response<promoBean> response) {


                if (response.body().getPosts()!=null)
                {
                        list = response.body().getPosts();
                        adapter.setGridData(list);


                }












            }

            @Override
            public void onFailure(Call<promoBean> call, Throwable t) {

            }
        });






    }











}
