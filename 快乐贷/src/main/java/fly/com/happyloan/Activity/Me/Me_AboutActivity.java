package fly.com.happyloan.Activity.Me;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fly.com.happyloan.Activity.Me.About.About_IntroduceActivity;
import fly.com.happyloan.Activity.Me.About.About_PrivacyPolicyActivity;
import fly.com.happyloan.R;

public class Me_AboutActivity extends Activity implements AdapterView.OnItemClickListener{

    List<Map<String,String>> listItems = new ArrayList<>();
    SimpleAdapter adapter;
    String[] strings = {"关于我们","检测更新","快乐贷隐私权政策"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_about);
        initData();

        listView = (ListView) findViewById(R.id.me_about_listView);

        String[] from = {"header"};
        int[] to = {R.id.tv_names};
        adapter = new SimpleAdapter(this,listItems,R.layout.me_about_list,from,to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    public void back(View view){
        finish();
    }

    private void initData(){
        listItems.clear();

        for (int i=0;i<strings.length;i++){
            Map<String,String> listItem = new HashMap<>();
            listItem.put("header",strings[i]);
            listItems.add(listItem);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this,About_IntroduceActivity.class));
                break;
            case 1:
                Versions();
                break;
            case 2:
                startActivity(new Intent(this,About_PrivacyPolicyActivity.class));
                break;
        }
    }
    public void Versions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("版本更新");
        builder.setMessage("\t\n当前版本：16.04.21\t\n已是最新版本\t\n");
        builder.setPositiveButton("确定",null);
        builder.setNegativeButton("取消",null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
