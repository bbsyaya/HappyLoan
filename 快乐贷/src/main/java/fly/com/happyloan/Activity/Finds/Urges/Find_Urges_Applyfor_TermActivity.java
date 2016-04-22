package fly.com.happyloan.Activity.Finds.Urges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.R;

public class Find_Urges_Applyfor_TermActivity extends AppCompatActivity {

    ListView urges_Applyfor_term_listView;
    private int[] Icon = {R.drawable.finds_reward,R.drawable.
            finds_reward,R.drawable.finds_reward,R.drawable.finds_reward};
    private String[] Title = {
            "具备实际催收经验，熟悉催收业务正规流程，具有相应的法律风险控制意识。",
            "在自选催收区域内拥有能支持催收业务的各类资源，保证高效催收。",
            "具备完全民事行为能力，无涉黑或暴力犯罪前科。",
            "熟练运用快乐贷手机客户端各项功能。"};
    SimpleAdapter adapter;
    ArrayList<HashMap<String ,Object>> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_urges_applyfor_term);
        urges_Applyfor_term_listView = (ListView) findViewById(R.id.urges_Applyfor_term_listView);
        initDate();
        String from[] = {"icon","title"};
        int to[] = {R.id.listView_icon,R.id.listView_title};
        adapter = new SimpleAdapter(this,datas,R.layout.find_urges_applyfor_term_list,from,to);
        urges_Applyfor_term_listView.setAdapter(adapter);
        urges_Applyfor_term_listView.setEnabled(false);
    }

    public void initDate(){
        for (int i=0;i<Icon.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("icon",Icon[i]);
            map.put("title",Title[i]);
            datas.add(map);
        }
    }

    public void back(View view){
        finish();
    }

}
