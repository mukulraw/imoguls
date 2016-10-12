package internetmoguls.com.imoguls;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import PROMO_POJO.Post;

class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder>{



    List<Post> list = new ArrayList<>();
    Context context;


    public PromoAdapter(Context context , List<Post> list)
    {
        this.context = context;
        this.list = list;
    }


    public void setGridData(List<Post> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.promo_list_model , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Post item = list.get(position);
        holder.code.setText(item.getPost().getVoucherCode());
        holder.desc.setText(item.getPost().getDescription());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        TextView code , desc;


        public ViewHolder(View itemView) {
            super(itemView);

            code = (TextView)itemView.findViewById(R.id.promo_code_id);
            desc = (TextView)itemView.findViewById(R.id.promo_code_desc);
        }
    }

}
