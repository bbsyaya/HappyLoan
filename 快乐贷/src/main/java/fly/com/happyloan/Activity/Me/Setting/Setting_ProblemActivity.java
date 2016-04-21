package fly.com.happyloan.Activity.Me.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fly.com.happyloan.R;

public class Setting_ProblemActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView me_setting_problem_list;
    SimpleAdapter simpleAdapter;
    List<HashMap<String,String>> datas = new ArrayList<>();
    private String[] title = {"借入","借出","赚利差","注册、登录认证和关联银行卡","关于充值、提现和转账","关于快乐贷等级","悬赏发布规则",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_problem);
        //
        me_setting_problem_list = (ListView) findViewById(R.id.me_setting_problem_list);
        initData();
        String[] from = {"title"};
        int[] to = {R.id.tv_title};
        simpleAdapter = new SimpleAdapter(this,datas,R.layout.me_setting_problem_list,from,to);
        me_setting_problem_list.setAdapter(simpleAdapter);
        me_setting_problem_list.setOnItemClickListener(this);
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
        Toast.makeText(Setting_ProblemActivity.this, "我是"+title[position], Toast.LENGTH_SHORT).show();
    }

    public void back(View view){
        finish();
    }

}
