package internetmoguls.com.imoguls;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    TextView filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_code);
        tf2 = Typeface.createFromAsset(getAssets() , "vladmir.TTF");

        TextView title = (TextView)findViewById(R.id.promo_title);

        filter = (TextView)findViewById(R.id.promo_filter);


        title.setTypeface(tf2);


        title.setTextSize(30);

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



        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(PromoCodeActivity.this);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialog_filter);
                dialog.show();

                final TextView all = (TextView)dialog.findViewById(R.id.filter_dialog_all);
                final TextView asiana = (TextView)dialog.findViewById(R.id.filter_dialog_asiana);
                final TextView continental = (TextView)dialog.findViewById(R.id.filter_dialog_continental);
                final TextView elite = (TextView)dialog.findViewById(R.id.filter_dialog_elite);
                final TextView ok = (TextView)dialog.findViewById(R.id.filter_ok);


                all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (flag == 1)
                        {
                            asiana.setTextColor(Color.BLACK);
                        }
                        if (flag == 2)
                        {
                            continental.setTextColor(Color.BLACK);
                        }
                        if (flag == 3)
                        {
                            elite.setTextColor(Color.BLACK);
                        }

                        flag = 4;
                        all.setTextColor(getResources().getColor(R.color.colorPrimaryDark));




                    }
                });

                asiana.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if (flag == 4)
                        {
                            all.setTextColor(Color.BLACK);
                        }
                        if (flag == 2)
                        {
                            continental.setTextColor(Color.BLACK);
                        }
                        if (flag == 3)
                        {
                            elite.setTextColor(Color.BLACK);
                        }

                        flag = 1;
                        asiana.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    }
                });

                continental.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (flag == 1)
                        {
                            asiana.setTextColor(Color.BLACK);
                        }
                        if (flag == 4)
                        {
                            all.setTextColor(Color.BLACK);
                        }
                        if (flag == 3)
                        {
                            elite.setTextColor(Color.BLACK);
                        }

                        flag = 2;
                        continental.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    }
                });

                elite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (flag == 1)
                        {
                            asiana.setTextColor(Color.BLACK);
                        }
                        if (flag == 2)
                        {
                            continental.setTextColor(Color.BLACK);
                        }
                        if (flag == 4)
                        {
                            all.setTextColor(Color.BLACK);
                        }

                        flag = 3;
                        elite.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    }
                });



                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (flag == 1)
                        {
                            List<Post> l2 = new ArrayList<Post>();
                            for (int i = 0 ; i < list.size() ; i++)
                            {
                                if (list.get(i).getPost().getHotelCat().equals("1"))
                                {
                                    l2.add(list.get(i));
                                }
                            }
                            adapter.setGridData(l2);
                            filter.setText("KOHINOOR ASIANA");
                        }
                        if (flag == 2)
                        {
                            List<Post> l2 = new ArrayList<Post>();
                            for (int i = 0 ; i < list.size() ; i++)
                            {
                                if (list.get(i).getPost().getHotelCat().equals("2"))
                                {
                                    l2.add(list.get(i));
                                }
                            }
                            adapter.setGridData(l2);
                            filter.setText("KOHINOOR CONTINENTAL");
                        }
                        if (flag == 3)
                        {
                            List<Post> l2 = new ArrayList<Post>();
                            for (int i = 0 ; i < list.size() ; i++)
                            {
                                if (list.get(i).getPost().getHotelCat().equals("3"))
                                {
                                    l2.add(list.get(i));
                                }
                            }
                            adapter.setGridData(l2);
                            filter.setText("KOHINOOR ELITE");
                        }
                        if (flag == 4)
                        {
                           adapter.setGridData(list);
                            filter.setText("ALL");

                        }

                        dialog.dismiss();

                    }



                });



            }
        });


    }











}
