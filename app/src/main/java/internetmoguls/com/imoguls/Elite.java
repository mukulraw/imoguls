package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import INTERFACES.Register;
import POJO.RegisterBean;
import POJO.fnbBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Elite extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    TabLayout tabs;
    MyViewPager pager;
    SharedPreferences pref;
    static SharedPreferences.Editor edit;
    DrawerLayout drawer;

    static Typeface tf;
    static Typeface tf2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elite);

        pref = getSharedPreferences("myPref" , Context.MODE_PRIVATE);
        edit = pref.edit();
        bean b = (bean)getApplicationContext();

        NavigationView nav = (NavigationView)findViewById(R.id.navId);

        tf = Typeface.createFromAsset(getAssets() , "roboto.ttf");
        tf2 = Typeface.createFromAsset(getAssets() , "vladmir.TTF");

        View view = nav.getHeaderView(0);
        nav.setNavigationItemSelectedListener(this);
        TextView tv = (TextView)view.findViewById(R.id.nav_name);


        tv.setText(b.username);





        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        drawer = (DrawerLayout)findViewById(R.id.activity_elite);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        tabs = (TabLayout)findViewById(R.id.tabs_asiana);
        pager = (MyViewPager) findViewById(R.id.pager_asiana);

        pager.setSwipeable(false);

        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

        View av = inflater.inflate(R.layout.tab_about , null);
        View av1 = inflater.inflate(R.layout.tab_about , null);
        View av2= inflater.inflate(R.layout.tab_about , null);
        View av3 = inflater.inflate(R.layout.tab_about , null);
        View av4 = inflater.inflate(R.layout.tab_about, null);

        TextView tabtext = (TextView)av.findViewById(R.id.tab_text);
        TextView tabtext1 = (TextView)av1.findViewById(R.id.tab_text);
        TextView tabtext2 = (TextView)av2.findViewById(R.id.tab_text);
        TextView tabtext3 = (TextView)av3.findViewById(R.id.tab_text);
        TextView tabtext4 = (TextView) av4.findViewById(R.id.tab_text);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);



        tabtext.setMinWidth(size.x/3);
        tabtext.setMaxWidth(size.x/3);
        tabtext.setText("About");

        tabtext1.setMinWidth(size.x/3);
        tabtext1.setMaxWidth(size.x/3);
        tabtext1.setText("Rooms");

        tabtext2.setMinWidth(size.x/3);
        tabtext2.setMaxWidth(size.x/3);
        tabtext2.setText("F & B");

        tabtext3.setMinWidth(size.x/3);
        tabtext3.setMaxWidth(size.x/3);
        tabtext3.setText("Meeting/Events");

        tabtext4.setMinWidth(size.x / 3);
        tabtext4.setMaxWidth(size.x / 3);
        tabtext4.setText("Contact us");



        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setTabGravity(TabLayout.GRAVITY_CENTER);

        FragStatePagerAdapter adapter = new FragStatePagerAdapter(getSupportFragmentManager() , 5);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        pager.setAdapter(adapter);


        tabs.setupWithViewPager(pager);
        tabs.getTabAt(0).setCustomView(av);
        tabs.getTabAt(1).setCustomView(av1);
        tabs.getTabAt(2).setCustomView(av2);
        tabs.getTabAt(3).setCustomView(av3);
        tabs.getTabAt(4).setCustomView(av4);


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                pager.setCurrentItem(tab.getPosition());

                View v = tab.getCustomView();
                TextView tv = (TextView) v.findViewById(R.id.tab_text);







                //tv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                tv.setTextColor(getResources().getColor(R.color.colorAccent));


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View v = tab.getCustomView();
                TextView tv = (TextView) v.findViewById(R.id.tab_text);




                tv.setTextColor(Color.GRAY);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.nav_log_out) {



            bean b = (bean)getApplicationContext();

            Intent delService = new Intent(this , DeleteTokenService.class);
            startService(delService);

            b.userId = "";
            b.username = "";
            edit.putBoolean("email" , false);
            edit.remove("emailId");
            edit.remove("RegId");
            edit.remove("password");
            edit.apply();


            Intent i = new Intent(Elite.this , LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();

        }

        if (id == R.id.nav_camera)
        {

            Intent i = new Intent(Elite.this , PromoCodeActivity.class);
            startActivity(i);



        }
        return false;
    }

    class FragStatePagerAdapter extends FragmentStatePagerAdapter {


        private int count;


        FragStatePagerAdapter(FragmentManager fm, int count) {
            super(fm);

            this.count = count;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new about();

                case 1:
                    return new rooms();
                case 2:
                    return new fnb();
                case 3:
                    return new meetings();
                case 4:
                    return new contact();
            }


            return null;

        }

        @Override
        public int getCount() {
            return count;
        }


    }


    public static class contact extends Fragment {


        GoogleMap mMap;

        TextView title;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.contact_elite, container, false);


            final SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.eventMapView);


            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {

                    mMap = googleMap;

                    LatLng loc = new LatLng(19.080820, 72.885523);

                    mMap.addMarker(new MarkerOptions().position(loc).title("Kohinoor Elite"));

                    mMap.animateCamera(CameraUpdateFactory.newLatLng(loc));

                    if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    mMap.setMyLocationEnabled(true);

                }
            });


            title = (TextView)view.findViewById(R.id.contact_asiana_title);

            title.setTypeface(tf2);
            title.setTextSize(30);





            return view;
        }
    }


    public static class about extends Fragment{

        Button book;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.elite_about , container , false);
            book = (Button)v.findViewById(R.id.book_asiana);


            TextView tit = (TextView)v.findViewById(R.id.elite_ab_title);
            TextView con = (TextView)v.findViewById(R.id.elite_ab_con);

            tit.setTypeface(tf2);
            tit.setTextSize(30);
            con.setTypeface(tf);

            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getActivity() , WebView.class);
                    i.putExtra("url" , "https://www.yourreservation.net/tb3/index.cfm?bf=HABOMELI&arrivaldate=undefined-undefined-&departuredate=undefined-undefined-&adults=1&children=0&plprun=1&_=1475668637295");
                    getActivity().startActivity(i);


                }
            });

            return v;
        }
    }

    public static class rooms extends Fragment{

        Button b1 , b2 ;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.elite_rooms , container , false);

            b1 = (Button)v.findViewById(R.id.asiana_room_1);
            b2 = (Button)v.findViewById(R.id.asiana_room_2);


            TextView tit1 = (TextView)v.findViewById(R.id.elite_room1_title);
            TextView tit2 = (TextView)v.findViewById(R.id.elite_room2_title);

            tit1.setTypeface(tf2);
            tit2.setTypeface(tf2);

            tit1.setTextSize(30);
            tit2.setTextSize(30);


            TextView con1 = (TextView)v.findViewById(R.id.elite_room1_con);
            TextView con2 = (TextView)v.findViewById(R.id.elite_room2_con);

            con1.setTypeface(tf);
            con2.setTypeface(tf);



            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(getActivity() , WebView.class);
                    i.putExtra("url" , "https://www.yourreservation.net/tb3/index.cfm?bf=HABOMELI&arrivaldate=2016-10-03&departuredate=2016-10-04&adults=1&children=0&plprun=1&_=1462766405231");
                    getActivity().startActivity(i);

                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getActivity() , WebView.class);
                    i.putExtra("url" , "https://www.yourreservation.net/tb3/index.cfm?bf=HABOMELI&arrivaldate=2016-10-03&departuredate=2016-10-04&adults=1&children=0&plprun=1&_=1462766405231");
                    getActivity().startActivity(i);
                }
            });


            return v;
        }
    }

    public static class fnb extends Fragment{

        //FnBListAdapter adapter;

       // RecyclerView grid;
        //GridLayoutManager manager;
        //TextView hide;
       LinearLayout todaysOffer , moreOffers;
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           // manager = new GridLayoutManager(getContext() , 1);

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.asiana_fnb , container , false);
            todaysOffer = (LinearLayout)v.findViewById(R.id.layout_todays_offer);
            moreOffers = (LinearLayout)v.findViewById(R.id.fnb_more_offers);
            //hide = (TextView)v.findViewById(R.id.hide);
            TextView title = (TextView)v.findViewById(R.id.asiana_fnb_title);
            title.setTypeface(tf2);
            title.setTextSize(30);
          //  grid = (RecyclerView)v.findViewById(R.id.fnb_list);

           // grid.setLayoutManager(manager);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register cr = retrofit.create(Register.class);

            Call<fnbBean> call = cr.getfnb("3");



            call.enqueue(new Callback<fnbBean>() {
                @Override
                public void onResponse(Call<fnbBean> call, Response<fnbBean> response) {

                    if (response.body().getPosts()!=null)
                    {

                        for (int i = 0 ; i<response.body().getPosts().size() ; i++)
                        {
                            if (response.body().getPosts().get(i).getPost().getOfferDay().equals("1"))
                            {
                                ImageLoader imageLoader = ImageLoader.getInstance();
                                LayoutInflater inflater1 = (LayoutInflater)getContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                                View view = inflater1.inflate(R.layout.fnb_model , null);

                                ImageView banner = (ImageView)view.findViewById(R.id.fnb_offer_image);
                                TextView title = (TextView)view.findViewById(R.id.fnb_offer_name);
                                TextView desc = (TextView)view.findViewById(R.id.fnb_offer_desc);

                                imageLoader.displayImage(response.body().getPosts().get(i).getPost().getImage() , banner);

                                title.setText(response.body().getPosts().get(i).getPost().getOfferName());
                                desc.setText(response.body().getPosts().get(i).getPost().getDescription());

                                todaysOffer.addView(view);



                            }
                            else
                            {
                                ImageLoader imageLoader = ImageLoader.getInstance();
                                LayoutInflater inflater1 = (LayoutInflater)getContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                                View view = inflater1.inflate(R.layout.fnb_model , null);

                                ImageView banner = (ImageView)view.findViewById(R.id.fnb_offer_image);
                                TextView title = (TextView)view.findViewById(R.id.fnb_offer_name);
                                TextView desc = (TextView)view.findViewById(R.id.fnb_offer_desc);

                                imageLoader.displayImage(response.body().getPosts().get(i).getPost().getImage() , banner);

                                title.setText(response.body().getPosts().get(i).getPost().getOfferName());
                                desc.setText(response.body().getPosts().get(i).getPost().getDescription());

                                moreOffers.addView(view);
                            }


                        }

                       // adapter = new FnBListAdapter(getContext() , response.body().getPosts());

                       // grid.setAdapter(adapter);

                        //hide.setVisibility(View.GONE);
                        //grid.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        //hide.setVisibility(View.VISIBLE);
                      //  grid.setVisibility(View.GONE);
                    }




                }

                @Override
                public void onFailure(Call<fnbBean> call, Throwable t) {

                }
            });



            return v;
        }
    }


    public static class meetings extends Fragment{

        EditText name , email , phone , sub , mess;
        Button submit;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.elite_meeting , container , false);
            name = (EditText)v.findViewById(R.id.elite_m_name);
            email = (EditText)v.findViewById(R.id.elite_m_email);
            phone = (EditText)v.findViewById(R.id.elite_m_phone);
            sub = (EditText)v.findViewById(R.id.elite_m_subject);


            TextView title = (TextView)v.findViewById(R.id.elite_meeting_title);

            title.setTypeface(tf2);
            title.setTextSize(30);



            mess = (EditText)v.findViewById(R.id.elite_m_message);
            submit = (Button) v.findViewById(R.id.elite_m_submit);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (name.getText().toString().length()>0)
                    {

                        if (email.getText().toString().length()>0)
                        {

                            if (phone.getText().toString().length()>0)
                            {

                                if (sub.getText().toString().length()>0)
                                {

                                    if (mess.getText().toString().length()>0)
                                    {


                                        Retrofit retrofit = new Retrofit.Builder()
                                                .baseUrl("http://nationproducts.in/")
                                                .addConverterFactory(ScalarsConverterFactory.create())
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .build();

                                        Register cr = retrofit.create(Register.class);


                                        Call<RegisterBean> call = cr.submitQuery("3" , name.getText().toString() , email.getText().toString() , phone.getText().toString() , sub.getText().toString() , mess.getText().toString());

                                        call.enqueue(new Callback<RegisterBean>() {
                                            @Override
                                            public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {


                                                if (response.body().getStatus().equals("1"))
                                                {
                                                    Toast.makeText(getActivity() , "Your query submitted successfully" , Toast.LENGTH_SHORT).show();
                                                    name.setText("");
                                                    email.setText("");
                                                    phone.setText("");
                                                    sub.setText("");
                                                    mess.setText("");

                                                }


                                            }

                                            @Override
                                            public void onFailure(Call<RegisterBean> call, Throwable t) {

                                            }
                                        });





                                    }
                                    else
                                    {
                                        Toast.makeText(getContext() , "Please enter a message" , Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else
                                {
                                    Toast.makeText(getContext() , "Please enter a subject" , Toast.LENGTH_SHORT).show();

                                }

                            }
                            else
                            {
                                Toast.makeText(getContext() , "Phone number is required" , Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            Toast.makeText(getActivity() , "Email is required" , Toast.LENGTH_SHORT).show();
                        }


                    }
                    else {
                        Toast.makeText(getActivity() , "Name is required" , Toast.LENGTH_SHORT).show();
                    }






                }
            });

            return v;
        }
    }


}
