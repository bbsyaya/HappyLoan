package fly.com.happyloan.Activity.Finds;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindCallback;
import cn.bmob.v3.listener.FindListener;
import fly.com.happyloan.Adapter.Finds_NoticAdapter;
import fly.com.happyloan.Object.Happy_notice;
import fly.com.happyloan.Object.Happy_reward;
import fly.com.happyloan.R;

public class Finds_NoticeActivity extends Activity{

    TextView notice_compile;//编辑
    ListView notice_listView;//
    //
    List<HashMap<String,Object>> lists = new ArrayList<>();
//    SimpleAdapter adapter;
    Finds_NoticAdapter adapter;
    //
    Happy_notice notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_notice);
        notice_listView = (ListView) findViewById(R.id.notice_listView);
        //

        //
        notice = new Happy_notice();
        BmobQuery<Happy_notice> query = new BmobQuery<>();
        query.findObjects(this, new FindListener<Happy_notice>() {
            @Override
            public void onSuccess(List<Happy_notice> list) {
                Log.i("查询结果：","查询结果："+list.size());
                for (Happy_notice happy_notice : list){
                    HashMap<String,Object> map = new HashMap<String, Object>();
                    map.put("title", happy_notice.getTitle());//标题
//                    ImageView imageView = ImageLoader.getInstance()
//                            .displayImage( .getNoticeImages().getUrl(),noticeImages);
                    map.put("noticeImages", happy_notice.getNoticeImages().getUrl());//公告图片
                    map.put("content", happy_notice.getContent());//公告内容
                    map.put("noticeTime", happy_notice.getNoticeTime().getDate());//发布时间
                    lists.add(map);
                }
//                String from[] = {"title","noticeImages","content","noticeTime"};
//                int to[] = {R.id.list_title,R.id.list_noticeImages,R.id.list_content,R.id.list_NoticeTime};
//                adapter = new SimpleAdapter(Finds_NoticeActivity.this,lists,R.layout.find_notice_listview,from,to);
                adapter = new Finds_NoticAdapter(lists,Finds_NoticeActivity.this);
                notice_listView.setAdapter(adapter);
            }

            @Override
            public void onError(int i, String s) {
                Log.i("失败：","失败："+s);
            }
        });
    }

    public void back(View view){
        finish();
    }
}
