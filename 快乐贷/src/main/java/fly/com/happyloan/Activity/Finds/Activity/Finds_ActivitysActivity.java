package fly.com.happyloan.Activity.Finds.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;

import fly.com.happyloan.R;

public class Finds_ActivitysActivity extends Activity implements WaterfallAdapter.MyItemClickListener {

    RecyclerView recyclerView;
    WaterfallAdapter adapter;
    ArrayList<Activities> activities_list = new ArrayList<>();

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
        adapter = new WaterfallAdapter(activities_list);
        recyclerView.setAdapter(adapter);
        //设置Item的距离
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);

        adapter.setOnItemClickListener(this);
    }

    private void initData(){
        //初始化数据
        activities_list.clear();
        int[] images = {
                R.drawable.loan_app_icon,R.drawable.loan_app_icon,R.drawable.loan_app_icon,
                R.drawable.loan_app_icon,R.drawable.loan_app_icon,R.drawable.loan_app_icon,
                R.drawable.loan_app_icon,R.drawable.loan_app_icon,R.drawable.loan_app_icon,
                R.drawable.loan_app_icon,R.drawable.loan_app_icon,R.drawable.loan_app_icon,
                };

        for (int i = 0 ; i< images.length ; i++){
            Activities activities = new Activities(images[i],"标题"+i,"内容"+i);
            activities_list.add(activities);
        }
    }

    public void Edit(View view){
        startActivity(new Intent(this,Finds_EditActivity.class));
    }

    public void Back(View view){
        finish();
    }

    @Override
    public void onItemClick(View view, int position) {
        Activities activities = activities_list.get(position);
        if (activities != null){
            startActivity(new Intent(this,Finds_Activity_DetailsActivity.class));
        }
    }
}
