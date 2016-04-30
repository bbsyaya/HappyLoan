package fly.com.happyloan.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.R;

/**
 * Created by Administrator on 2016/4/17 0017.
 */
public class WaterfallAdapter extends RecyclerView.Adapter<WaterfallAdapter.WaterfallViewHolder>{


    ArrayList<HashMap<String,Object>> activities;
    MyItemClickListener listener = null;

    public WaterfallAdapter(ArrayList<HashMap<String,Object>> activities){
        this.activities = activities;
    }

    @Override
    public WaterfallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_activity_recycler,parent,false);

        return new WaterfallViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(WaterfallViewHolder holder, int position) {
        ImageLoader.getInstance()
                .displayImage((String) activities.get(position).get("headImages"),holder.imageView);
        holder.textView.setText(activities.get(position).get("type").toString());
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    public void setOnItemClickListener(MyItemClickListener listener){
        this.listener = listener;
    }

    static class WaterfallViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView;
        private MyItemClickListener listener;

        public WaterfallViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            textView = (TextView) itemView.findViewById(R.id.item_title);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onItemClick(v,getPosition());
            }
        }
    }
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }
}
