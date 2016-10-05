package internetmoguls.com.imoguls;

import android.content.Intent;
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
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Elite extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    TabLayout tabs;
    ViewPager pager;
    DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elite);


        bean b = (bean)getApplicationContext();

        NavigationView nav = (NavigationView)findViewById(R.id.navId);



        View view = nav.getHeaderView(0);

        TextView tv = (TextView)view.findViewById(R.id.nav_name);


        tv.setText(b.username);





        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        drawer = (DrawerLayout)findViewById(R.id.activity_elite);

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

        if (id == R.id.nav_gallery) {




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
            View v = inflater.inflate(R.layout.elite_about , container , false);
            book = (Button)v.findViewById(R.id.book_asiana);


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

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.elite_fnb , container , false);
            return v;
        }
    }

    public static class meetings extends Fragment{


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.elite_meeting , container , false);
            return v;
        }
    }


}
