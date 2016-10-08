package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import POJO.Post;
import POJO.fnbBean;


public class FnBListAdapter extends RecyclerView.Adapter<FnBListAdapter.ViewHolder> {


    List<Post> list = new ArrayList<>();
    Context context;


    public FnBListAdapter(Context context , List<Post> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public FnBListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.fnb_list_item , parent , false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Post item = list.get(position);

        holder.title.setText(item.getPost().getOfferName());
        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage(item.getPost().getImage() , holder.banner);


        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (item.getPost().getHotelName().equals("1"))
                {
                    Intent i = new Intent(context , WebView.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("url" , "http://www.axisrooms.com/beV2/home1.html?bookingEngineId=1792");
                    context.startActivity(i);
                }

                if (item.getPost().getHotelName().equals("2"))
                {
                    Intent i = new Intent(context , WebView.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("url" , "https://www.yourreservation.net/tb3/index.cfm?bf=HABOMCON&arrivaldate=&departuredate=&adult=1%20Adult&child=0%20Child&plprun=1&_=1475668601020");
                    context.startActivity(i);
                }

                if (item.getPost().getHotelName().equals("3"))
                {
                    Intent i = new Intent(context , WebView.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("url" , "https://www.yourreservation.net/tb3/index.cfm?bf=HABOMELI&arrivaldate=undefined-undefined-&departuredate=undefined-undefined-&adults=1&children=0&plprun=1&_=1475668637295");
                    context.startActivity(i);
                }



            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView banner;
        TextView title;
        Button book;

        public ViewHolder(View itemView) {
            super(itemView);

            banner = (ImageView)itemView.findViewById(R.id.fnb_image);
            title = (TextView)itemView.findViewById(R.id.fnb_name);
            book = (Button) itemView.findViewById(R.id.book_fnb);

        }
    }
}
