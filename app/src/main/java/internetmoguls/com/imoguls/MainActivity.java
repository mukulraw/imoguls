package internetmoguls.com.imoguls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    CardView asiana , elite , continental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asiana = (CardView)findViewById(R.id.asiana);
        elite = (CardView)findViewById(R.id.elite);
        continental = (CardView)findViewById(R.id.continental);




        asiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext() , Asiana.class);
                startActivity(i);
            }
        });

        elite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext() , Elite.class);
                startActivity(i);

            }
        });

        continental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext() , Continental.class);
                startActivity(i);

            }
        });




    }


}
