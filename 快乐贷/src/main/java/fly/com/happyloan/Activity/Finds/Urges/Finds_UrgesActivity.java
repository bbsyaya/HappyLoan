package fly.com.happyloan.Activity.Finds.Urges;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.R;

public class Finds_UrgesActivity extends Activity implements View.OnClickListener {

    ListView urges_listView;//
    private int[] Icon = {R.drawable.finds_reward,R.drawable.
            finds_reward,R.drawable.finds_reward,R.drawable.finds_reward};
    private String[] Title = {"所在属地接单，定区域，抢任务","工作时间自选，我拘束，想自由",
            "薪酬实时计算，高提成，快结算","只可线上收款，无纠纷，零风险"};
    SimpleAdapter adapter;
    ArrayList<HashMap<String ,Object>> datas = new ArrayList<>();
    TextView urges_Applyfor_term;//申请条件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_urges);
        urges_listView = (ListView) findViewById(R.id.urges_listView);
        urges_Applyfor_term = (TextView) findViewById(R.id.urges_Applyfor_term);
        initDate();
        String from[] = {"icon","title"};
        int to[] = {R.id.listView_icon,R.id.listView_title};
        adapter = new SimpleAdapter(this,datas,R.layout.find_urges_list,from,to);
        urges_listView.setAdapter(adapter);
        urges_listView.setEnabled(false);
        listener();
    }

    public void listener(){
        urges_Applyfor_term.setOnClickListener(this);
    }

    public void initDate(){
        for (int i=0;i<Icon.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("icon",Icon[i]);
            map.put("title",Title[i]);
            datas.add(map);
        }
    }

    public void Applyfor(View view){
        Toast.makeText(Finds_UrgesActivity.this, "立即申请！", Toast.LENGTH_SHORT).show();
    }

    public void back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(Finds_UrgesActivity.this, "申请条件！", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,Find_Urges_Applyfor_TermActivity.class));
    }

}
