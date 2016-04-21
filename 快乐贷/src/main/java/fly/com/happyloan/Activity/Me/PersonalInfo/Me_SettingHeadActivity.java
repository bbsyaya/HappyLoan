package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fly.com.happyloan.R;

public class Me_SettingHeadActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView me_setting_head_listView;
    SimpleAdapter simpleAdapter;
    List<HashMap<String,String>> datas = new ArrayList<>();
    private String[] title = {"从相册选一张","拍一张照片"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__setting_head);
        me_setting_head_listView = (ListView) findViewById(R.id.me_setting_head_listView);
        initData();

        String[] from = {"title"};
        int[] to = {R.id.tv_title};
        simpleAdapter = new SimpleAdapter(this,datas,R.layout.me_setting_problem_list,from,to);
        me_setting_head_listView.setAdapter(simpleAdapter);
        me_setting_head_listView.setOnItemClickListener(this);
    }
    public void initData(){

        datas.clear();
        for (int i = 0;i<title.length;i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("title",title[i]);
            datas.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, title[position], Toast.LENGTH_SHORT).show();
    }
    public void Back(View view){
        finish();
    }
}
