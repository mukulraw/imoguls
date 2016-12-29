package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.Intent;
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

import propertiesPOJO.HotelDetail;


class PropertyAdapter  extends RecyclerView.Adapter<PropertyAdapter.ViewHolder>{

    List<HotelDetail> list = new ArrayList<>();
    Context context;



    public PropertyAdapter(Context context , List<HotelDetail> list)
    {
        this.context = context;
        this.list = list;
    }


    public void setGridData(List<HotelDetail> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.hotel_property_model , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        HotelDetail item = list.get(position);

        ImageLoader loader = ImageLoader.getInstance();

        loader.displayImage(item.getHotelImage() , holder.propertyImage);
        holder.propertyName.setText(item.getHotelName());
        holder.propertyDesc.setText(item.getHotelDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        ImageView propertyImage;
        TextView propertyName , propertyDesc;


        ViewHolder(View itemView) {
            super(itemView);

            propertyName = (TextView)itemView.findViewById(R.id.property_name);
            propertyDesc = (TextView)itemView.findViewById(R.id.property_description);
            propertyImage = (ImageView)itemView.findViewById(R.id.property_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(context , DefaultPage.class);
                    i.putExtra("form" , list.get(getAdapterPosition()).getHotelId());
                    i.putExtra("name" , list.get(getAdapterPosition()).getHotelName());
                    i.putExtra("addr" , list.get(getAdapterPosition()).getHotelDescription());
                    context.startActivity(i);

                }
            });


        }
    }


}
