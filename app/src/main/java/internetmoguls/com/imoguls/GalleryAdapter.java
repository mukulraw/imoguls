package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import galleryPOJO.Gallery;



public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {




    List<Gallery> list = new ArrayList<>();
    Context context;
    List<Bitmap> l2 = new ArrayList<>();


    GalleryAdapter(Context context, List<Gallery> list)
    {
        this.context = context;
        this.list = list;
    }

    GalleryAdapter()
    {

    }




    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.gallery_model , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Gallery item = list.get(position);
        final ImageLoader loader = ImageLoader.getInstance();
//                loader.displayImage(item.getGalleryImage() , holder.image);

        final Bitmap[] b = new Bitmap[1];

        loader.loadImage(item.getGalleryImage(), new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                b[0] = loadedImage;
                l2.add(loadedImage);
                holder.image.setImageBitmap(b[0]);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

        holder.name.setText(item.getGalleryTitle());

        String htmlText = "<html><body style=\"text-align:justify; background:#f5f5f5; padding:0 2px;\"><font size=\"2\" weight=\"300\" face=\"roboto\" color=\"#808080\"> %s </font></body></Html>";

        holder.content.loadData(String.format(htmlText , item.getGalleryDescription()) , "text/html", null);

        holder.content.setFocusable(false);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(context, ImageViewPager.class);

                Log.d("asdasdclicked" , "Clicked");

                // Show a simple toast message for the item position


                // Send the click position to ImageViewPager.java using intent
                i.putExtra("id", position);

                // Start ImageViewPager
                context.startActivity(i);


            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView image;
        android.webkit.WebView content;



        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.gallery_name);
            content = (android.webkit.WebView) itemView.findViewById(R.id.gallery_content);
            image = (ImageView)itemView.findViewById(R.id.gallery_image);

        }
    }

}
