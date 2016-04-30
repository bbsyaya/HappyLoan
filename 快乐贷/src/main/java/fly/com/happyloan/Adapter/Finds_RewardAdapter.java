package fly.com.happyloan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fly.com.happyloan.R;

/**
 * Created by Candy-X on 2016/4/28/0028.
 */
public class Finds_RewardAdapter extends BaseAdapter{

    List<HashMap<String,Object>> lists = new ArrayList<>();
    Context context;

    public Finds_RewardAdapter(List<HashMap<String, Object>> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        ImageView reward_listview_headimage;
        TextView reward_listview_name;
        TextView reward_listview_time;
        TextView reward_listview_content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.finds_reward_listview,parent,false);
            holder.reward_listview_headimage = (ImageView) convertView.findViewById(R.id.reward_listview_headimage);
            holder.reward_listview_name = (TextView) convertView.findViewById(R.id.reward_listview_name);
            holder.reward_listview_time = (TextView) convertView.findViewById(R.id.reward_listview_time);
            holder.reward_listview_content = (TextView) convertView.findViewById(R.id.reward_listview_content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(
                (String) lists.get(position).get("headimage"),
                holder.reward_listview_headimage);
        holder.reward_listview_name.setText(lists.get(position).get("name").toString());
        holder.reward_listview_time.setText(lists.get(position).get("time").toString());
        holder.reward_listview_content.setText(lists.get(position).get("content").toString());
        return convertView;
    }

}
