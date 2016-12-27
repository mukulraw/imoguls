package internetmoguls.com.imoguls;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import galleryPOJO.Gallery;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {


    List<Gallery> list = new ArrayList<>();
    Context context;


    public GalleryAdapter(Context context , List<Gallery> list)
    {
        this.context = context;
        this.list = list;
    }

    public void setGridData(List<Gallery> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.gallery_model , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Gallery item = list.get(position);
        ImageLoader loader = ImageLoader.getInstance();
        loader.displayImage(item.getGalleryImage() , holder.image);

        holder.name.setText(item.getGalleryTitle());
        holder.content.setText(Html.fromHtml(item.getGalleryDescription()));



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name , content;
        ImageView image;




        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.gallery_name);
            content = (TextView)itemView.findViewById(R.id.gallery_content);
            image = (ImageView)itemView.findViewById(R.id.gallery_image);

        }
    }
}
