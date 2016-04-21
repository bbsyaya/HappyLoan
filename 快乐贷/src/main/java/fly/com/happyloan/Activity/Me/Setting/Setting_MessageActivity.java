package fly.com.happyloan.Activity.Me.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import fly.com.happyloan.R;

public class Setting_MessageActivity extends AppCompatActivity {

    LinearLayout me_message_newMessage;
    Switch switch_notice;//公告开关
    Switch switch_subscription;//借款订阅开关
    Switch switch_friend;//好友相关开关

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_message);
        //
        me_message_newMessage = (LinearLayout) findViewById(R.id.me_message_newMessage);
        switch_notice = (Switch) findViewById(R.id.switch_notice);
        switch_subscription = (Switch) findViewById(R.id.switch_subscription);
        switch_friend = (Switch) findViewById(R.id.switch_friend);
    }

    public void back(View view){
        //返回按钮
        finish();
    }

}
