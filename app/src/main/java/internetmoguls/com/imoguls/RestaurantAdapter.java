package internetmoguls.com.imoguls;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.*;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.text.Text;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import restaurantPOJO.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder>{


    List<Restaurant> list = new ArrayList<>();
    Context context;


    public RestaurantAdapter(Context context , List<Restaurant> list)
    {
        this.context = context;
        this.list = list;
    }


    public void setGridData(List<Restaurant> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.restaurant_model , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Restaurant item = list.get(position);

        ImageLoader loader = ImageLoader.getInstance();
        loader.displayImage(item.getRestaurantImage() , holder.image);

        String htmlText = "<html><body style=\"text-align:justify; background:#ffffff; padding:0 10px;\"><font size=\"3\" weight=\"300\" face=\"roboto\" color=\"#808080\"> %s </font></body></Html>";

        holder.description.loadData(String.format(htmlText , item.getRestaurantDescription()) , "text/html", null);

        holder.description.setFocusable(false);

        //holder.description.setText(Html.fromHtml(item.getRestaurantDescription()));
        holder.name.setText(item.getRestaurantName());
        holder.title.setText(item.getRestaurantTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name , title;

        android.webkit.WebView description;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (WebView) itemView.findViewById(R.id.desc);
            image = (ImageView)itemView.findViewById(R.id.image);

        }
    }

}
