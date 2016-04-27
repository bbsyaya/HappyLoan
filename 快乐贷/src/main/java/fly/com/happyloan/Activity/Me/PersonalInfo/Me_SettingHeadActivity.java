package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.BmobUser;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

public class Me_SettingHeadActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView me_setting_head_listView;
    SimpleAdapter simpleAdapter;
    ImageView me_setting_head_image;
    List<HashMap<String,String>> datas = new ArrayList<>();
    private String[] title = {"从相册选一张","拍一张照片"};

    Happy_user user;
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

        me_setting_head_image = (ImageView) findViewById(R.id.me_setting_head_image);
        user = BmobUser.getCurrentUser(this,Happy_user.class);
        ImageLoader.getInstance().displayImage(user.getHeadImage().getUrl(),me_setting_head_image);

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
