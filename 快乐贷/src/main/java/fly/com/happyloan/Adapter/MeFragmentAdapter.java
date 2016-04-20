package fly.com.happyloan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.R;

/**
 * Created by Candy-X on 2016/4/19/0019.
 */
public class MeFragmentAdapter extends BaseAdapter{

    ArrayList<HashMap<String,Object>> list = new ArrayList<>();
    Context context;

    public MeFragmentAdapter(ArrayList<HashMap<String, Object>> list, Context context) {
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

    class ViewHolder{
        ImageView image_icon;
        TextView tv_borrow;
        TextView tv_menoy;
        ImageView image_come;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_me_list,parent,false);
            holder.image_icon = (ImageView) convertView.findViewById(R.id.image_icon);
            holder.tv_borrow = (TextView) convertView.findViewById(R.id.tv_borrow);
            holder.tv_menoy = (TextView) convertView.findViewById(R.id.tv_menoy);
            holder.image_come = (ImageView) convertView.findViewById(R.id.image_come);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.image_icon.setImageResource(Integer.parseInt(list.get(position).get("icon").toString()));
        holder.tv_borrow.setText(list.get(position).get("borrow").toString());
        holder.tv_menoy.setText(list.get(position).get("money").toString());
        holder.image_come.setImageResource(Integer.parseInt(list.get(position).get("come").toString()));
        return convertView;
    }
}
