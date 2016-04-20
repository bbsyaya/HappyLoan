package fly.com.happyloan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fly.com.happyloan.R;

/**
 * Created by WINPC on 2016/4/19.
 */
public class FindsAdapter extends BaseAdapter {

    ArrayList<HashMap<String,Object>> list = new ArrayList<>();
    Context context;



    public FindsAdapter(ArrayList<HashMap<String,Object>> list,Context context){
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class FindsView {
        ImageView header;
        TextView name;
        TextView desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FindsView view =null;
        if (convertView ==null){
            view = new FindsView();
            convertView = LayoutInflater.from(context).inflate(R.layout.simple_item,parent,false);
            view.header = (ImageView) convertView.findViewById(R.id.header);
            view.name = (TextView) convertView.findViewById(R.id.name);
            view.desc = (TextView) convertView.findViewById(R.id.desc);
            convertView.setTag(view);
        }else {
            view = (FindsView) convertView.getTag();
        }
        view.header.setImageResource(Integer.parseInt(list.get(position).get("icon").toString()));
        view.name.setText(list.get(position).get("name").toString());
        view.desc.setText(list.get(position).get("desc").toString());
        return convertView;
    }
}
