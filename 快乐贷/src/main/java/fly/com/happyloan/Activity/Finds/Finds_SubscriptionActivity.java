package fly.com.happyloan.Activity.Finds;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Finds_SubscriptionActivity extends Activity implements View.OnClickListener {

    ListView subscription_listView;//
    TextView subscription_subscription;//订阅

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_subscription);
        subscription_listView = (ListView) findViewById(R.id.subscription_listView);
        subscription_subscription = (TextView) findViewById(R.id.subscription_subscription);
        listener();
    }

    public void listener(){
        subscription_subscription.setOnClickListener(this);
    }

    public void back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        AlertDialog alert_dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("借款订阅");//设置标题
        builder.setIcon(R.drawable.finds_subscription);//设置标题图标
        builder.setMessage("是否订阅？");//设置消息内容
        builder.setCancelable(false);//是否点击返回键能取消
        builder.setPositiveButton("是", null);//确定按钮
        builder.setNegativeButton("否", null);//取消按钮

        alert_dialog = builder.create();//创建出对话框
        alert_dialog.show();//显示出对话框
    }
}
