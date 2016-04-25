package fly.com.happyloan.Activity.Me.About;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fly.com.happyloan.Activity.Me.About.Privacy.About_PersonalMessageActivity;
import fly.com.happyloan.Activity.Me.About.Privacy.About_ContactMeActivity;
import fly.com.happyloan.Activity.Me.About.Privacy.About_SharePersonalMessageActivity;
import fly.com.happyloan.Activity.Me.About.Privacy.About_Summarize_StatementActivity;
import fly.com.happyloan.Activity.Me.About.Privacy.UsePersonalMessageActivity;
import fly.com.happyloan.R;

public class About_PrivacyPolicyActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String[] strings = {"总结和声明","如何收集个人资料",
            "如何使用个信息","如何分享个人信息","联系我们"};
    List<Map<String,String>> lists = new ArrayList<>();
    SimpleAdapter adapter;
    ListView about_privacy_policy_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_privacy_policy);
        initData();

        about_privacy_policy_list = (ListView) findViewById(R.id.about_privacy_policy_list);

        String[] from = {"header"};
        int[] to = {R.id.tv_names};
        adapter = new SimpleAdapter(this,lists,R.layout.me_about_list,from,to);
        about_privacy_policy_list.setAdapter(adapter);

        about_privacy_policy_list.setOnItemClickListener(this);
    }


    public void back(View view){
        finish();
    }

    private void initData(){

        lists.clear();
        for (int i=0;i<strings.length;i++){
            Map<String,String> map = new HashMap<>();
            map.put("header",strings[i]);
            lists.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this,About_Summarize_StatementActivity.class));
                break;
            case 1:
                startActivity(new Intent(this,About_PersonalMessageActivity.class));
                break;
            case 2:
                startActivity(new Intent(this,UsePersonalMessageActivity.class));
                break;
            case 3:
                startActivity(new Intent(this,About_SharePersonalMessageActivity.class));
                break;
            case 4:
                startActivity(new Intent(this,About_ContactMeActivity.class));
                break;
        }
    }
}
