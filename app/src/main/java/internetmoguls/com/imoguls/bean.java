package internetmoguls.com.imoguls;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class bean extends Application {


    String userId = "";
    String username = "";


    @Override
    public void onCreate() {
        super.onCreate();



        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

    }
}
