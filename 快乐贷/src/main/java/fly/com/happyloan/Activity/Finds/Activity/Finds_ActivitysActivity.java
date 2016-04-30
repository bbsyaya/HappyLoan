package fly.com.happyloan.Activity.Finds.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import fly.com.happyloan.Adapter.WaterfallAdapter;
import fly.com.happyloan.Object.Happy_activity;
import fly.com.happyloan.R;

public class Finds_ActivitysActivity extends Activity implements WaterfallAdapter.MyItemClickListener {

    RecyclerView recyclerView;
    WaterfallAdapter adapter;
    public static ArrayList<HashMap<String,Object>> activities_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_activitys);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        SettingRecyclerView();
    }

    private void SettingRecyclerView(){
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        initData();

        //设置Item的距离
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);

    }

    private void initData(){
        //初始化数据
        activities_list.clear();
        BmobQuery<Happy_activity> query = new BmobQuery<>();
        final ProgressDialog progressDialog = new ProgressDialog(Finds_ActivitysActivity.this);
        progressDialog.setMessage("正在加载......");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        query.findObjects(this, new FindListener<Happy_activity>() {
            @Override
            public void onSuccess(List<Happy_activity> list) {
                Log.i("查询正确", "数据" + list.size());

                for (Happy_activity activity : list) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("name", activity.getName());
                    map.put("type", activity.getType());
                    map.put("time",activity.getTime());
                    map.put("address",activity.getAddress());
                    map.put("count",activity.getCount());
                    //photos jojName
                    //map.put("photos",activity.getPhotos());
                    map.put("headImages",activity.getHeadImage());
                    activities_list.add(map);
                    System.out.println(activity.getName());
                }
                adapter = new WaterfallAdapter(activities_list);
                recyclerView.setAdapter(adapter);
                //设置点击事件
                adapter.setOnItemClickListener(Finds_ActivitysActivity.this);
                progressDialog.dismiss();
            }

            @Override
            public void onError(int i, String s) {
                Log.i("查询错误", s);
            }
        });
    }

    public void Edit(View view){
        startActivity(new Intent(this,Finds_EditActivity.class));
    }

    public void Back(View view){
        finish();
    }

    @Override
    public void onItemClick(View view, int position) {
        if (activities_list != null){
            Toast.makeText(this, "点击了"+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Finds_Activity_DetailsActivity.class);
            intent.putExtra("position",position);
            startActivity(intent);
        }
    }
}
