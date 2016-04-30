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
public class Finds_NoticAdapter extends BaseAdapter{

    List<HashMap<String,Object>> lists = new ArrayList<>();
    Context context;

    public Finds_NoticAdapter(List<HashMap<String, Object>> lists, Context context) {
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
        TextView list_title;
        ImageView list_noticeImages;
        TextView list_content;
        TextView list_NoticeTime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.find_notice_listview,parent,false);
            holder.list_title = (TextView) convertView.findViewById(R.id.list_title);
            holder.list_noticeImages = (ImageView) convertView.findViewById(R.id.list_noticeImages);
            holder.list_content = (TextView) convertView.findViewById(R.id.list_content);
            holder.list_NoticeTime = (TextView) convertView.findViewById(R.id.list_NoticeTime);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.list_title.setText(lists.get(position).get("title").toString());
        ImageLoader.getInstance().displayImage(
                (String) lists.get(position).get("noticeImages"),
                holder.list_noticeImages);
        holder.list_content.setText(lists.get(position).get("content").toString());
        holder.list_NoticeTime.setText(lists.get(position).get("noticeTime").toString());
        return convertView;
    }
}
