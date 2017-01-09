package internetmoguls.com.imoguls;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.SmoothViewPager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import INTERFACES.Register;
import POJO.RegisterBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LoginActivity extends AppCompatActivity {
    public static Context context;
    static SmoothViewPager pager;
    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;
    static TextSwitcher title;
    static SharedPreferences pref;
    static SharedPreferences.Editor edit;
    static String e = "";
    static String p = "";
    static Boolean keepLogged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;

        overridePendingTransition(0 , R.anim.fade);

        pref = getSharedPreferences("myPref" , Context.MODE_PRIVATE);
        edit = pref.edit();

        pager = (SmoothViewPager) findViewById(R.id.pager);
        title = (TextSwitcher) findViewById(R.id.title);







        title.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView () {
                TextView myText = new TextView(LoginActivity.this);
                myText.setTextSize(34);
                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });

        title.setText("Sign In");


        title.setInAnimation(getApplicationContext() , R.anim.fade_in);
        //title.setOutAnimation(getApplicationContext() , R.anim.fade_out);


        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), 2);




        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0)
                {
                    title.setText("Sign In");
                }
                else
                {
                    title.setText("Sign Up");
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pager.setAdapter(mSectionsPagerAdapter);



    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        final int noOfTabs;

        SectionsPagerAdapter(FragmentManager fm, int noOfTabs) {
            super(fm);
            this.noOfTabs = noOfTabs;
        }



        @Override
        public int getCount() {
            // Show 3 total pages.
            return noOfTabs;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:


                    return new FirstPage();

                case 1:

                    return new SecondPage();

            }
            return null;
        }
    }



    public static class FirstPage extends Fragment {


        EditText email , password;
        Button log;
        TextView forgot;

        ProgressBar progress;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.sign_in_page1, container, false);

            progress = (ProgressBar)v.findViewById(R.id.progress);

            email = (EditText)v.findViewById(R.id.email_login);
            password = (EditText)v.findViewById(R.id.password_login);

            forgot = (TextView)v.findViewById(R.id.forgot);

            forgot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final Dialog dialog = new Dialog(getActivity());
                    dialog.setCancelable(true);
                    dialog.setContentView(R.layout.forgot_dialog);

                    dialog.show();

                    final EditText forText = (EditText)dialog.findViewById(R.id.forgot_text);
                    Button forg = (Button)dialog.findViewById(R.id.forgot_button);

                    forg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            progress.setVisibility(View.VISIBLE);


                            Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl("http://nationproducts.in/")
                                    .addConverterFactory(ScalarsConverterFactory.create())
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();

                            Register cr = retrofit.create(Register.class);

                            Call<RegisterBean> call = cr.forgotPass(forText.getText().toString());

                            call.enqueue(new Callback<RegisterBean>() {
                                @Override
                                public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {


                                    if (response.body().getStatus().equals("1"))
                                    {
                                        Toast.makeText(getActivity() , "Your password has sent to your email id" , Toast.LENGTH_SHORT).show();

                                        progress.setVisibility(View.GONE);

                                        dialog.dismiss();

                                    }
                                    if (response.body().getStatus().equals("2"))
                                    {
                                        Toast.makeText(getActivity() , "Invalid email id" , Toast.LENGTH_SHORT).show();

                                        progress.setVisibility(View.GONE);

                                        dialog.dismiss();
                                    }




                                }

                                @Override
                                public void onFailure(Call<RegisterBean> call, Throwable t) {

                                    progress.setVisibility(View.GONE);

                                }
                            });


                        }
                    });


                }
            });




            log = (Button)v.findViewById(R.id.signin);


            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    e = email.getText().toString();

                    p = password.getText().toString();


                    //add login logic

                  /*  Intent i = new Intent(getContext() , MainActivity.class);
                    startActivity(i);
                    getActivity().finish();
*/
                    //logoEmail("email" , e , p);

                    progress.setVisibility(View.VISIBLE);


                    login(e , p);




                }
            });


            TextView goToCreatePage = (TextView)v.findViewById(R.id.create_page);
            goToCreatePage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    pager.setCurrentItem(2 , true);

                    title.setText("Sign Up");
                    // title.setInAnimation(getApplicationContext() , R.anim.fade_in);
                    ///title.setOutAnimation(getApplicationContext() , R.anim.fade_out);

                }
            });

            return v;

        }


        public void login(String em , String pas)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register cr = retrofit.create(Register.class);

            String token = pref.getString("RegId" , null);

            Call<RegisterBean> call = cr.login(em , pas , token);

            call.enqueue(new Callback<RegisterBean>() {
                @Override
                public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {


                    if (response.body().getStatus().equals("1"))
                    {


                            edit.putBoolean("email" , true);
                            edit.putString("emailId" , e);
                            edit.putString("password" , p);
                            edit.apply();






                        bean b = (bean)getActivity().getApplicationContext();

                        b.userId = response.body().getUserId();

                        progress.setVisibility(View.GONE);

                        Intent i = new Intent(getContext() ,MainActivity.class);
                        startActivity(i);
                        getActivity().finish();
                    }
                    if (response.body().getStatus().equals("4"))
                    {
                        bean b = (bean)getActivity().getApplicationContext();

                        b.userId = response.body().getUserId();
                        progress.setVisibility(View.GONE);

                        Intent i = new Intent(getContext() ,OTP_Activity.class);
                        startActivity(i);
                        getActivity().finish();

                    }

                    if (response.body().getStatus().equals("2") || response.body().getStatus().equals("3"))
                    {
                        progress.setVisibility(View.GONE);
                        Toast.makeText(getContext() , "Invalid Email or password" , Toast.LENGTH_SHORT).show();
                    }





                }

                @Override
                public void onFailure(Call<RegisterBean> call, Throwable t) {
                    progress.setVisibility(View.GONE);
                }
            });

        }

    }

    public static class SecondPage extends Fragment {


        EditText username , emailId , mobileNo , passw , retpassword , addre;
        Button create;

        ProgressBar progress;





        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.sign_in_page2, container, false);
            //  title.setText("Sign Up");


            progress = (ProgressBar)v.findViewById(R.id.progress);



            TextView goToLoginPage = (TextView)v.findViewById(R.id.login_pager);

            username = (EditText)v.findViewById(R.id.username);
            emailId = (EditText)v.findViewById(R.id.emailId);
            mobileNo = (EditText)v.findViewById(R.id.mobile);
            passw = (EditText)v.findViewById(R.id.password);
            retpassword = (EditText)v.findViewById(R.id.retpassword);
            addre = (EditText)v.findViewById(R.id.address);
            create = (Button)v.findViewById(R.id.signup);



            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String user = username.getText().toString();
                    String emai = emailId.getText().toString();
                    String pass = passw.getText().toString();
                    String retpa = retpassword.getText().toString();
                    String addr = addre.getText().toString();
                    String mob = mobileNo.getText().toString();


                    if (user.length()>0)
                    {

                        if (emai.length()>0)
                        {

                            if (addr.length()>0)
                            {

                                if (mob.length()>0)
                                {

                                    if (pass.length()>0)
                                    {



                                        if (retpa.equals(pass))
                                        {

                                            //add register logic


                                            progress.setVisibility(View.VISIBLE);


                                            regisEmail(user , emai , mob , pass , addr);

                                        }
                                        else
                                        {
                                            Toast.makeText(getActivity() , "Your password didn't match" , Toast.LENGTH_SHORT).show();
                                        }



                                    }
                                    else
                                    {
                                        Toast.makeText(getContext() , "Please enter password" , Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else
                                {
                                    Toast.makeText(getContext() , "Please enter mobile number" , Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(getContext() , "Address is required" , Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            Toast.makeText(getContext() , "Please enter email address" , Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(getContext() , "Please enter username" , Toast.LENGTH_SHORT).show();
                    }




                    //new register(emai , user , pass).execute();
                    //regisEmail("email" , user , emai , pass);
                    //new register1(emai , pass).execute();


                }
            });









            goToLoginPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pager.setCurrentItem(0 , true);

                    title.setText("Sign In");
                    //  title.setInAnimation(getApplicationContext() , R.anim.fade_in);
                    //  title.setOutAnimation(getApplicationContext() , R.anim.fade_out);
                }
            });

            return v;
        }



        public void regisEmail(String name , String email , String mobile , String password , String address)
        {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register cr = retrofit.create(Register.class);

            Call<RegisterBean> call = cr.register(name , email , mobile , password , address);

            call.enqueue(new Callback<RegisterBean>() {
                @Override
                public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {


                    if (response.body().getStatus().equals("1"))
                    {
                        Toast.makeText(getActivity() , "Please check registered Email Id for verification code" , Toast.LENGTH_LONG).show();

                        username.setText("");
                        emailId.setText("");
                        mobileNo.setText("");
                        passw.setText("");
                        retpassword.setText("");
                        addre.setText("");


                        progress.setVisibility(View.GONE);


                        Intent i = new Intent(getActivity() , OTP_Activity.class);
                        bean b = (bean)getActivity().getApplicationContext();
                        b.userId = response.body().getUserId();
                        startActivity(i);
                        getActivity().finish();
                    }
                    if (response.body().getStatus().equals("2"))
                    {
                        progress.setVisibility(View.GONE);
                        Toast.makeText(getActivity() , "Email Already registered, please login to continue" , Toast.LENGTH_SHORT).show();
                    }





                }

                @Override
                public void onFailure(Call<RegisterBean> call, Throwable t) {
                    progress.setVisibility(View.GONE);
                }
            });

        }




    }
















    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0 , R.anim.fade);
    }
}
