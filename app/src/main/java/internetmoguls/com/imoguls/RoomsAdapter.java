package internetmoguls.com.imoguls;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.*;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.List;

import roomsPOJO.Room;

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.ViewHolder>{



    List<Room> list = new ArrayList<>();
    Context context;


    public RoomsAdapter(Context context , List<Room> list)
    {
        this.list = list;
        this.context = context;
    }


    public void setGridData(List<Room> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.rooms_model , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Typeface tf2 = Typeface.createFromAsset(context.getAssets(), "vladmir.TTF");
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");

        Room item = list.get(position);

        ImageLoader loader = ImageLoader.getInstance();

        loader.displayImage(item.getRoomImage() , holder.image);

        holder.name.setText(item.getRoomName());

        holder.name.setTypeface(tf2);

        String htmlText = "<html><body style=\"text-align:justify\"><font size=\"3\" weight=\"300\" face=\"roboto\" color=\"#808080\"> %s </font></body></Html>";

        holder.desc.loadData(String.format(htmlText , item.getRoomDescription()) , "text/html", null);
        holder.desc.setFocusable(false);

        //holder.desc.setTypeface(tf);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        android.webkit.WebView desc;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.rooms_image);
            name = (TextView)itemView.findViewById(R.id.rooms_name);
            desc = (WebView) itemView.findViewById(R.id.rooms_description);

        }
    }

}
