package fly.com.happyloan.Activity.Finds.Reward;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;

import fly.com.happyloan.R;

public class Finds_Reward_ListViewActivity extends AppCompatActivity {

    ImageView finds_reward_listView_headimage;//头像
    TextView finds_reward_listView_name;//名字
    TextView finds_reward_listView_time;//时间
    TextView finds_reward_listView_content;//内容
    ListView finds_reward_listView_listView;
    HashMap<String,Object> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_reward_list_view);
        finds_reward_listView_headimage = (ImageView) findViewById(R.id.finds_reward_listView_headimage);
        finds_reward_listView_name = (TextView) findViewById(R.id.finds_reward_listView_name);
        finds_reward_listView_time = (TextView) findViewById(R.id.finds_reward_listView_time);
        finds_reward_listView_content = (TextView) findViewById(R.id.finds_reward_listView_content);
        finds_reward_listView_listView = (ListView) findViewById(R.id.finds_reward_listView_listView);
        receiveData();
    }

    public void receiveData(){//意图接收数据
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        datas = (HashMap<String, Object>) bundle.get("finds_reward_listview");
        ImageLoader.getInstance().displayImage((String) datas.get("headimage"), finds_reward_listView_headimage);
        finds_reward_listView_name.setText(datas.get("name").toString());
        finds_reward_listView_time.setText(datas.get("time").toString());
        finds_reward_listView_content.setText(datas.get("content").toString());
    }

    public void back(View view){
        finish();
    }

}
