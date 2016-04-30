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
public class FriendsAdapter extends BaseAdapter{

    List<HashMap<String,String>> lists = new ArrayList<>();
    Context context;

    public FriendsAdapter(List<HashMap<String, String>> lists, Context context) {
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
        ImageView friends_listview_headimage;
        TextView friends_listview_name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.friends_listview,parent,false);
            holder.friends_listview_headimage = (ImageView) convertView.findViewById(R.id.friends_listview_headimage);
            holder.friends_listview_name = (TextView) convertView.findViewById(R.id.friends_listview_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(
                lists.get(position).get("headimage"),
                holder.friends_listview_headimage);
        holder.friends_listview_name.setText(lists.get(position).get("name"));
        return convertView;
    }
}
