package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import OfferVoucherPOJO.ovBean;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.*;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.plus.model.people.Person;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import INTERFACES.Register;
import OfferVoucherPOJO.*;
import facilityPOJO.facilityBean;
import notificationjPOJO.Notification;
import notificationjPOJO.notifyBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class PromoCodeActivity extends AppCompatActivity {




    Toolbar toolbar;
    ViewPager pager;
    static String userId;
    TabLayout tabs;
    LayoutInflater inflater;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_code);

        pref = getSharedPreferences("pree" , Context.MODE_PRIVATE);



        userId = pref.getString("id" , "");

        pager = (ViewPager)findViewById(R.id.pager);
        tabs = (TabLayout)findViewById(R.id.tabs);

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

        inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

        View av = inflater.inflate(R.layout.tab_about, null);
        View av1 = inflater.inflate(R.layout.tab_about, null);
        View av2 = inflater.inflate(R.layout.tab_about, null);



        TextView tabtext = (TextView) av.findViewById(R.id.tab_text);
        TextView tabtext1 = (TextView) av1.findViewById(R.id.tab_text);
        TextView tabtext2 = (TextView) av2.findViewById(R.id.tab_text);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);


        tabtext.setMinWidth(size.x / 3);
        tabtext.setMaxWidth(size.x / 3);
        tabtext.setText("Notifications");

        tabtext1.setMinWidth(size.x / 3);
        tabtext1.setMaxWidth(size.x / 3);
        tabtext1.setText("Promo Codes");

        tabtext2.setMinWidth(size.x / 3);
        tabtext2.setMaxWidth(size.x / 3);
        tabtext2.setText("Offers");


//        tabs.addTab(tabs.newTab().setCustomView(av));

        //      tabs.addTab(tabs.newTab().setText("ROOMS"));
        //  tabs.addTab(tabs.newTab().setText("F and B"));
        //    tabs.addTab(tabs.newTab().setText("MEETING/EVENTS"));
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);


        tabs.setTabGravity(TabLayout.GRAVITY_FILL);


        FragStatePagerAdapter adapter = new FragStatePagerAdapter(getSupportFragmentManager(), 3);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        pager.setAdapter(adapter);


        tabs.setupWithViewPager(pager);
        tabs.getTabAt(0).setCustomView(av);
        tabs.getTabAt(1).setCustomView(av1);
        tabs.getTabAt(2).setCustomView(av2);



        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);


        tabs.setTabGravity(TabLayout.GRAVITY_FILL);





        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0)
                {
                    toolbar.setTitle("Notifications");
                }

                if (tab.getPosition() == 1)
                {
                    toolbar.setTitle("Promo Codes");
                }

                if (tab.getPosition() == 2)
                {
                    toolbar.setTitle("Offers");
                }

                pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }



    private class FragStatePagerAdapter extends FragmentStatePagerAdapter {


        private int count;


        FragStatePagerAdapter(FragmentManager fm, int count) {
            super(fm);

            this.count = count;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new NotificationClass();
                case 1:
                    return new Promo();
                case 2:
                    return new Offers();



            }


            return null;

        }

        @Override
        public int getCount() {
            return count;
        }


    }



    public static class NotificationClass extends Fragment{


        RecyclerView grid;
        GridLayoutManager manager;
        List<Notification> list;
        NotificationAdapter adapter;
        ProgressBar progress;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view  = inflater.inflate(R.layout.notification_layout , container , false);



            progress = (ProgressBar)view.findViewById(R.id.progress);

            grid = (RecyclerView)view.findViewById(R.id.grid);
            manager = new GridLayoutManager(getContext() , 1);

            list = new ArrayList<>();

            adapter = new NotificationAdapter(getContext() , list);

            grid.setAdapter(adapter);
            grid.setLayoutManager(manager);


            progress.setVisibility(View.VISIBLE);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register cr = retrofit.create(Register.class);


            Call<notifyBean> call = cr.getNotification(userId);

            call.enqueue(new Callback<notifyBean>() {
                @Override
                public void onResponse(Call<notifyBean> call, Response<notifyBean> response) {

                    list = response.body().getNotification();

                    adapter.setGridData(list);

                    progress.setVisibility(View.GONE);

                }

                @Override
                public void onFailure(Call<notifyBean> call, Throwable t) {
                    progress.setVisibility(View.GONE);
                }
            });




            return view;
        }
    }




    public static class Promo extends Fragment{


        RecyclerView grid;
        GridLayoutManager manager;
        List<Detail> list;

        ProgressBar progress;
        FacilityAdapter adapter;



        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.notification_layout  , container , false);

            progress = (ProgressBar)view.findViewById(R.id.progress);

            grid = (RecyclerView)view.findViewById(R.id.grid);
            manager = new GridLayoutManager(getContext() , 1);

            list = new ArrayList<>();

            adapter = new FacilityAdapter(getContext() , list);

            grid.setLayoutManager(manager);
            grid.setAdapter(adapter);

            progress.setVisibility(View.VISIBLE);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register cr = retrofit.create(Register.class);


            Call<ovBean> call = cr.getPromoCodes(userId , "voucher");

            call.enqueue(new Callback<ovBean>() {
                @Override
                public void onResponse(Call<ovBean> call, Response<ovBean> response) {



                    list = response.body().getDetail();
                    adapter.setGridData(list);



                    progress.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<ovBean> call, Throwable t) {
                    progress.setVisibility(View.GONE);
                }
            });




            return view;
        }





        class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder>{


            int id = 0;
            Context context;
            List<Detail> list = new ArrayList<>();
            private LayoutInflater inflater;


            FacilityAdapter(Context context, List<Detail> list)
            {
                this.list = list;
                this.context = context;
                this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }


            void setGridData(List<Detail> list)
            {
                this.list = list;
                notifyDataSetChanged();
            }


            @Override
            public FacilityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = inflater.inflate(R.layout.facility_list_model , parent , false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(final ViewHolder holder, final int position) {

                Detail item = list.get(position);


                if (id == position)
                {
                    holder.replace.setVisibility(View.VISIBLE);
                }
                else
                {
                    holder.replace.setVisibility(View.GONE);
                }


                Typeface tf = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");
                Typeface tf2 = Typeface.createFromAsset(context.getAssets(), "vladmir.TTF");



                //head.setTextColor(context.getResources().getColor(R.color.colorAccent));
                holder.title.setText(item.getHotelName());

                holder.title.setTypeface(tf2);

                //holder.title.setTextSize(30);

                holder.replace.removeAllViews();


                if (item.getData().size()>0) {











                    for (int j = 0; j < item.getData().size(); j++) {

                        View v = inflater.inflate(R.layout.promo_model, null);


                        TextView name = (TextView) v.findViewById(R.id.name);
                        android.webkit.WebView desc = (WebView) v.findViewById(R.id.desc);

                        name.setTypeface(tf);

                        //loader.displayImage(item.getData().get(j).getFacilityImage() , image , options);

                        name.setText(item.getData().get(j).getName());

                        String htmlText = "<html><body style=\"text-align:justify; padding:0 10px;\"><font size=\"2\" weight=\"300\" face=\"roboto\" color=\"#808080\"> %s </font></body></Html>";
                        desc.loadData(String.format(htmlText , item.getData().get(j).getDescription()) , "text/html", null);
                        desc.setFocusable(false);




                        holder.replace.addView(v);
                    }

                }
                else
                {
                    View v = inflater.inflate(R.layout.error_layout , null);
                    holder.replace.addView(v);
                }

                holder.title.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {

                                                        if (holder.replace.getVisibility() == View.VISIBLE)
                                                        {
                                                            id = -1;
                                                            notifyDataSetChanged();
                                                        }
                                                        else if (holder.replace.getVisibility() == View.GONE)
                                                        {
                                                            id = position;
                                                            notifyDataSetChanged();
                                                        }

                                                    }


                                                }
                );




            }







            @Override
            public int getItemCount() {
                return list.size();
            }

            class ViewHolder extends RecyclerView.ViewHolder{


                TextView title;
                LinearLayout replace;


                ViewHolder(View itemView) {
                    super(itemView);

                    title = (TextView)itemView.findViewById(R.id.name);
                    replace = (LinearLayout)itemView.findViewById(R.id.replace);

                }
            }


        }






    }








    public static class Offers extends Fragment{


        RecyclerView grid;
        GridLayoutManager manager;
        List<Detail> list;

        ProgressBar progress;
        FacilityAdapter adapter;



        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.notification_layout  , container , false);

            progress = (ProgressBar)view.findViewById(R.id.progress);

            grid = (RecyclerView)view.findViewById(R.id.grid);
            manager = new GridLayoutManager(getContext() , 1);

            list = new ArrayList<>();

            adapter = new FacilityAdapter(getContext() , list);

            grid.setLayoutManager(manager);
            grid.setAdapter(adapter);

            progress.setVisibility(View.VISIBLE);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register cr = retrofit.create(Register.class);


            Call<ovBean> call = cr.getPromoCodes(userId , "offer");

            call.enqueue(new Callback<ovBean>() {
                @Override
                public void onResponse(Call<ovBean> call, Response<ovBean> response) {



                    list = response.body().getDetail();
                    adapter.setGridData(list);



                    progress.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<ovBean> call, Throwable t) {
                    progress.setVisibility(View.GONE);
                }
            });




            return view;
        }





        class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder>{


            int id = 0;
            Context context;
            List<Detail> list = new ArrayList<>();
            private LayoutInflater inflater;


            FacilityAdapter(Context context, List<Detail> list)
            {
                this.list = list;
                this.context = context;
                this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }


            void setGridData(List<Detail> list)
            {
                this.list = list;
                notifyDataSetChanged();
            }


            @Override
            public FacilityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = inflater.inflate(R.layout.facility_list_model , parent , false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(final ViewHolder holder, final int position) {

                Detail item = list.get(position);


                if (id == position)
                {
                    holder.replace.setVisibility(View.VISIBLE);
                }
                else
                {
                    holder.replace.setVisibility(View.GONE);
                }


                Typeface tf = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");
                Typeface tf2 = Typeface.createFromAsset(context.getAssets(), "vladmir.TTF");


                DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                        .cacheOnDisc(true).resetViewBeforeLoading(false).build();

                ImageLoader loader = ImageLoader.getInstance();



                //head.setTextColor(context.getResources().getColor(R.color.colorAccent));

                holder.title.setText(item.getHotelName());

                holder.title.setTypeface(tf2);

                //holder.title.setTextSize(30);

                holder.replace.removeAllViews();

                if (item.getData().size()>0) {











                    for (int j = 0; j < item.getData().size(); j++) {

                        View v = inflater.inflate(R.layout.offer_model , null);


                        ImageView image = (ImageView)v.findViewById(R.id.image);
                        TextView name = (TextView) v.findViewById(R.id.name);
                        WebView desc = (WebView) v.findViewById(R.id.desc);

                        name.setTypeface(tf);

                        //loader.displayImage(item.getData().get(j).getFacilityImage() , image , options);

                        loader.displayImage(item.getData().get(j).getImage() , image , options);
                        name.setText(item.getData().get(j).getName());


                        String htmlText = "<html><body style=\"text-align:justify; padding:0 4px;\"><font size=\"2\" weight=\"300\" face=\"roboto\" color=\"#808080\"> %s </font></body></Html>";
                        desc.loadData(String.format(htmlText , item.getData().get(j).getDescription()) , "text/html", null);
                        desc.setFocusable(false);





                        holder.replace.addView(v);
                    }

                }else
                {
                    View v = inflater.inflate(R.layout.error_layout , null);
                    holder.replace.addView(v);
                }


                holder.title.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {

                                                        if (holder.replace.getVisibility() == View.VISIBLE)
                                                        {
                                                            id = -1;
                                                            notifyDataSetChanged();
                                                        }
                                                        else if (holder.replace.getVisibility() == View.GONE)
                                                        {
                                                            id = position;
                                                            notifyDataSetChanged();
                                                        }

                                                    }


                                                }
                );




            }







            @Override
            public int getItemCount() {
                return list.size();
            }

            class ViewHolder extends RecyclerView.ViewHolder{


                TextView title;
                LinearLayout replace;


                ViewHolder(View itemView) {
                    super(itemView);

                    title = (TextView)itemView.findViewById(R.id.name);
                    replace = (LinearLayout)itemView.findViewById(R.id.replace);

                }
            }


        }






    }










}
