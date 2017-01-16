package internetmoguls.com.imoguls;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ImageViewPager extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_pager);

        Intent p = getIntent();
        position = p.getExtras().getInt("id");

        DefaultPage.AsianaFragment.gallery.GalleryAdapter imageAdapter = new DefaultPage.AsianaFragment.gallery.GalleryAdapter(this);
        List<ImageView> images = new ArrayList<ImageView>();

        // Retrieve all the images
        for (int i = 0; i < imageAdapter.getItemCount(); i++) {
            ImageView imageView = new ImageView(this);

            ImageLoader loader = ImageLoader.getInstance();

            loader.displayImage(imageAdapter.list.get(i).getGalleryImage() , imageView);

            //imageView.setImageBitmap(imageAdapter.l2.get(i));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            images.add(imageView);
        }

        // Set the images into ViewPager
        ImagePagerAdapter pageradapter = new ImagePagerAdapter(images);
        ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
        viewpager.setAdapter(pageradapter);
        // Show images following the position
        viewpager.setCurrentItem(position);
    }


}
