package internetmoguls.com.imoguls;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import facilityPOJO.facilityBean;

class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder>{


    int id = 0;
    Context context;
    List<facilityBean> list = new ArrayList<>();
    private LayoutInflater inflater;


    FacilityAdapter(Context context, List<facilityBean> list)
    {
        this.list = list;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    void setGridData(List<facilityBean> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.facility_list_model , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        facilityBean item = list.get(position);


        if (id == position)
        {
            holder.replace.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.replace.setVisibility(View.GONE);
        }


        Typeface tf = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");
        Typeface tf2 = Typeface.createFromAsset(context.getAssets(), "vladmir.TTF");

        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(false).build();

        ImageLoader loader = ImageLoader.getInstance();


            //head.setTextColor(context.getResources().getColor(R.color.colorAccent));

        holder.title.setText(item.getHeading());

            holder.title.setTypeface(tf2);

            holder.title.setTextSize(30);

            holder.replace.removeAllViews();

            for (int j = 0 ; j < item.getFacilityData().size() ; j++)
            {

                View v = inflater.inflate(R.layout.facility_model , null);

                ImageView image = (ImageView)v.findViewById(R.id.image);
                TextView name = (TextView)v.findViewById(R.id.name);

                name.setTypeface(tf);

                loader.displayImage(item.getFacilityData().get(j).getFacilityImage() , image , options);

                name.setText(item.getFacilityData().get(j).getFacilityName());

                holder.replace.addView(v);
            }



            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (holder.replace.getVisibility() == View.VISIBLE)
                    {
                        id = -1;
                        notifyDataSetChanged();
                    }
                    else if (holder.replace.getVisibility() == View.GONE)
                    {
                        id = position;
                        notifyDataSetChanged();
                    }

                }


            }
            );




    }







    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        TextView title;
        LinearLayout replace;


        ViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.name);
            replace = (LinearLayout)itemView.findViewById(R.id.replace);

        }
    }


}
