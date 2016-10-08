package internetmoguls.com.imoguls;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Intent i = new Intent(getBaseContext() , LoginActivity.class);

                startActivity(i);

                finish();

            }
        } , 1500);

    }
}
