package fly.com.happyloan.Activity.Finds;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Finds_NoticeActivity extends Activity implements View.OnClickListener {

    TextView notice_compile;//编辑
    ListView notice_listView;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_notice);
        notice_compile = (TextView) findViewById(R.id.notice_compile);
        notice_listView = (ListView) findViewById(R.id.notice_listView);
        listener();
    }

    public void back(View view){
        finish();
    }

    public void listener(){
        notice_compile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(Finds_NoticeActivity.this, "编辑！", Toast.LENGTH_SHORT).show();
    }
}
