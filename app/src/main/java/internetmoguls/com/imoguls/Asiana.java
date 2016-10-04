package internetmoguls.com.imoguls;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Asiana extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asiana);

        tabs = (TabLayout)findViewById(R.id.tabs_asiana);
        pager = (ViewPager)findViewById(R.id.pager_asiana);







    }
}
