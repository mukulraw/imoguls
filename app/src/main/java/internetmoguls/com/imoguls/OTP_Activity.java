package internetmoguls.com.imoguls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import INTERFACES.Register;
import POJO.RegisterBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class OTP_Activity extends AppCompatActivity {

    EditText otp_text;
    Button otp_button;

    String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_);

        bean b = (bean)getApplicationContext();

        userId = b.userId;

        otp_text = (EditText)findViewById(R.id.otp_text);
        otp_button = (Button)findViewById(R.id.otp_button);



        otp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String otp = otp_text.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://nationproducts.in/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Register cr = retrofit.create(Register.class);

                Call<RegisterBean> call = cr.verify(userId , otp);

                call.enqueue(new Callback<RegisterBean>() {
                    @Override
                    public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {

                        if (response.body().getStatus().equals("1"))
                        {
                            Toast.makeText(getBaseContext() , "Account activated, please login to continue" , Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getBaseContext() , LoginActivity.class);
                            startActivity(i);
                            finish();
                        }
                        if (response.body().getStatus().equals("2"))
                        {
                            Toast.makeText(getBaseContext() , "Invalid Verification code" , Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<RegisterBean> call, Throwable t) {

                    }
                });


            }
        });




    }




}
