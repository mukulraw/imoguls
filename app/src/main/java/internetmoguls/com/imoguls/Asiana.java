package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import INTERFACES.Register;
import POJO.RegisterBean;
import POJO.fnbBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Asiana extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TabLayout tabs;
    ViewPager pager;
    DrawerLayout drawer;
    SharedPreferences pref;
    static SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asiana);
        pref = getSharedPreferences("myPref" , Context.MODE_PRIVATE);
        edit = pref.edit();

        bean b = (bean)getApplicationContext();

        NavigationView nav = (NavigationView)findViewById(R.id.navId);



        View view = nav.getHeaderView(0);


        nav.setNavigationItemSelectedListener(this);

        TextView tv = (TextView)view.findViewById(R.id.nav_name);


        tv.setText(b.username);


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        drawer = (DrawerLayout)findViewById(R.id.drawer_asiana);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();





        tabs = (TabLayout)findViewById(R.id.tabs_asiana);
        pager = (ViewPager)findViewById(R.id.pager_asiana);



        tabs.addTab(tabs.newTab().setText("ABOUT"));
        tabs.addTab(tabs.newTab().setText("ROOMS"));
        tabs.addTab(tabs.newTab().setText("F & B"));
        tabs.addTab(tabs.newTab().setText("MEETING/EVENTS"));
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setTabGravity(TabLayout.GRAVITY_CENTER);




        FragStatePagerAdapter adapter = new FragStatePagerAdapter(getSupportFragmentManager() , tabs.getTabCount());
pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        pager.setAdapter(adapter);

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_log_out) {



            bean b = (bean)getApplicationContext();

            b.userId = "";
            b.username = "";
            edit.putBoolean("email" , false);
            edit.remove("emailId");
            edit.remove("password");
            edit.apply();

            Intent i = new Intent(Asiana.this , LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();

        }

        if (id == R.id.nav_camera)
        {




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
            }


            return null;

        }

        @Override
        public int getCount() {
            return count;
        }


    }


    public static class about extends Fragment{

        Button book;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.asiana_about_us , container , false);
            book = (Button)v.findViewById(R.id.book_asiana);

            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(getActivity() , WebView.class);
                    i.putExtra("url" , "http://www.axisrooms.com/beV2/home1.html?bookingEngineId=1792");
                    getActivity().startActivity(i);

                }
            });


            return v;
        }
    }

    public static class rooms extends Fragment{

        Button b1 , b2;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.asiana_rooms , container , false);

            b1 = (Button)v.findViewById(R.id.asiana_room_1);
            b2 = (Button)v.findViewById(R.id.asiana_room_2);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(getActivity() , WebView.class);
                    i.putExtra("url" , "http://www.axisrooms.com/beV2/home1.html?bookingEngineId=1792");
                    getActivity().startActivity(i);

                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getActivity() , WebView.class);
                    i.putExtra("url" , "http://www.axisrooms.com/beV2/home1.html?bookingEngineId=1792");
                    getActivity().startActivity(i);
                }
            });


            return v;
        }
    }

    public static class fnb extends Fragment{

        FnBListAdapter adapter;

        RecyclerView grid;
        GridLayoutManager manager;
        TextView hide;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            manager = new GridLayoutManager(getContext() , 1);

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.asiana_fnb , container , false);

            hide = (TextView)v.findViewById(R.id.hide);

            grid = (RecyclerView)v.findViewById(R.id.fnb_list);

            grid.setLayoutManager(manager);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register cr = retrofit.create(Register.class);

            Call<fnbBean> call = cr.getfnb("1");



            call.enqueue(new Callback<fnbBean>() {
                @Override
                public void onResponse(Call<fnbBean> call, Response<fnbBean> response) {

                    if (response.body().getPosts().size()>0)
                    {
                        adapter = new FnBListAdapter(getContext() , response.body().getPosts());

                        grid.setAdapter(adapter);

                        hide.setVisibility(View.GONE);
                        grid.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        hide.setVisibility(View.VISIBLE);
                        grid.setVisibility(View.GONE);
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
            View v = inflater.inflate(R.layout.asiana_meetings , container , false);
            name = (EditText)v.findViewById(R.id.asiana_m_name);
            email = (EditText)v.findViewById(R.id.asiana_m_email);
            phone = (EditText)v.findViewById(R.id.asiana_m_phone);
            sub = (EditText)v.findViewById(R.id.asiana_m_subject);
            mess = (EditText)v.findViewById(R.id.asiana_m_message);
            submit = (Button) v.findViewById(R.id.asiana_m_submit);


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


                                        Call<RegisterBean> call = cr.submitQuery("1" , name.getText().toString() , email.getText().toString() , phone.getText().toString() , sub.getText().toString() , mess.getText().toString());

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
