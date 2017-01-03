package internetmoguls.com.imoguls;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import notificationjPOJO.Notification;


class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{

    Context context;
    List<Notification> list = new ArrayList<>();


    public NotificationAdapter(Context context , List<Notification> list)
    {
        this.context = context;
        this.list = list;
    }


    public void setGridData(List<Notification> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.notification_list_model , parent , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Notification item = list.get(position);

        Typeface tf2 = Typeface.createFromAsset(context.getAssets() , "vladmir.TTF");
        Typeface tf = Typeface.createFromAsset(context.getAssets() , "roboto.ttf");

        holder.message.setText(item.getText());
        holder.message.setTypeface(tf2);
        holder.code.setText(item.getName());
        holder.code.setTypeface(tf);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.collapse.getVisibility() == View.VISIBLE)
                {
                    holder.message.setCompoundDrawablesWithIntrinsicBounds(0 , 0 , R.drawable.down_black , 0);
                    holder.collapse.setVisibility(View.GONE);
                }
                else if (holder.collapse.getVisibility() == View.GONE)
                {
                    holder.message.setCompoundDrawablesWithIntrinsicBounds(0 , 0 , R.drawable.up_black , 0);
                    holder.collapse.setVisibility(View.VISIBLE);
                }

            }
        });


        if (Objects.equals(item.getType().toLowerCase(), "offer"))
        {
            ImageLoader loader = ImageLoader.getInstance();
            holder.image.setVisibility(View.VISIBLE);
            loader.displayImage(item.getImage() , holder.image);
        }
        if (Objects.equals(item.getType().toLowerCase(), "voucher"))
        {
            //ImageLoader loader = ImageLoader.getInstance();
            holder.image.setVisibility(View.GONE);
            //loader.displayImage(item.getImage() , holder.image);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        TextView message , code;
        LinearLayout collapse;
        ImageView image;


        ViewHolder(View itemView) {
            super(itemView);

            message = (TextView)itemView.findViewById(R.id.message);
            image = (ImageView)itemView.findViewById(R.id.image);
            collapse = (LinearLayout)itemView.findViewById(R.id.collapse);
            code = (TextView)itemView.findViewById(R.id.code);


        }
    }


}
