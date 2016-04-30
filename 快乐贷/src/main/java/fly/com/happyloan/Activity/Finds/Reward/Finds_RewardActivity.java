package fly.com.happyloan.Activity.Finds.Reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import fly.com.happyloan.Adapter.Finds_RewardAdapter;
import fly.com.happyloan.Object.Happy_reward;
import fly.com.happyloan.R;

public class Finds_RewardActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener {

    ImageView finds_reward_me;
    ImageView finds_reward_compile;
    ListView finds_reward_listView;
    //
    List<HashMap<String,Object>> lists = new ArrayList<>();
    Finds_RewardAdapter adapter = null;
    Happy_reward reward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_reward);
        finds_reward_me = (ImageView) findViewById(R.id.finds_reward_me);
        finds_reward_compile = (ImageView) findViewById(R.id.finds_reward_compile);
        finds_reward_listView = (ListView) findViewById(R.id.finds_reward_listView);
        listener();
        //
        reward = new Happy_reward();
        BmobQuery<Happy_reward> query = new BmobQuery<>();
        query.findObjects(this, new FindListener<Happy_reward>() {
            @Override
            public void onSuccess(List<Happy_reward> list) {
                Log.i("查询结果：","查询结果："+list.size());
                for (Happy_reward happy_reward:list){
                    HashMap<String,Object> map = new HashMap<String, Object>();
                    map.put("headimage",happy_reward.getHeadImage());
                    map.put("name",happy_reward.getName());
                    map.put("time",happy_reward.getTime());
                    map.put("content",happy_reward.getContent());
                    lists.add(map);
                }
                adapter = new Finds_RewardAdapter(lists,Finds_RewardActivity.this);
                finds_reward_listView.setAdapter(adapter);
                finds_reward_listView.setOnItemClickListener(Finds_RewardActivity.this);
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

    public void listener(){
        finds_reward_me.setOnClickListener(this);
        finds_reward_compile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finds_reward_me:
                Toast.makeText(Finds_RewardActivity.this, "我的！", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Finds_Reward_MeActivity.class));
                break;
            case R.id.finds_reward_compile:
                Toast.makeText(Finds_RewardActivity.this, "编辑！", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Finds_Reward_CompileActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(Finds_RewardActivity.this, position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Finds_Reward_ListViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("finds_reward_listview",lists.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
