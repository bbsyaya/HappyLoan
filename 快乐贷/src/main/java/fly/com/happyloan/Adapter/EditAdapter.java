package fly.com.happyloan.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import fly.com.happyloan.R;

/**
 * Created by Administrator on 2016/4/28 0028.
 */
public class EditAdapter extends BaseAdapter{

    Context context;
    ArrayList<Bitmap> bitmaps;
    public EditAdapter(Context context,ArrayList<Bitmap> bitmaps){
        this.context = context;
        this.bitmaps = bitmaps;
    }

    @Override
    public int getCount() {
        return bitmaps.size();
    }

    @Override
    public Object getItem(int position) {
        return bitmaps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.find_activity_edit_list,parent,false);
            holder.imageView = (ImageView) convertView.findViewById(R.id.edit_image);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView.setImageBitmap(bitmaps.get(position));
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
    }
}
