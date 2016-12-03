package internetmoguls.com.imoguls;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{





        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
