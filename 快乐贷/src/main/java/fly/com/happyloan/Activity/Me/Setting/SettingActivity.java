package fly.com.happyloan.Activity.Me.Setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import fly.com.happyloan.R;

public class SettingActivity extends AppCompatActivity implements
        View.OnClickListener, View.OnTouchListener {

    LinearLayout me_setting_updateloginpwd;//修改登录密码
    LinearLayout me_setting_updatetradepwd;//修改交易密码
    LinearLayout me_setting_gesture;//手势设置
    LinearLayout me_setting_changephonenum;//更换手机号
    LinearLayout me_setting_pay;//支付设置
    LinearLayout me_setting_message;//消息推送
    LinearLayout me_setting_privacy;//隐私设置
    LinearLayout me_setting_clearcache;//清理缓存
    LinearLayout me_setting_feedback;//意见反馈
    LinearLayout me_setting_problem;//常见问题


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViewById();
        Listener();
    }


    public void findViewById(){
        //每项的显示
        me_setting_updateloginpwd = (LinearLayout) findViewById(R.id.me_setting_updateloginpwd);
        me_setting_updatetradepwd = (LinearLayout) findViewById(R.id.me_setting_updatetradepwd);
        me_setting_gesture = (LinearLayout) findViewById(R.id.me_setting_gesture);
        me_setting_changephonenum = (LinearLayout) findViewById(R.id.me_setting_changephonenum);
        me_setting_pay = (LinearLayout) findViewById(R.id.me_setting_pay);
        me_setting_message = (LinearLayout) findViewById(R.id.me_setting_message);
        me_setting_privacy = (LinearLayout) findViewById(R.id.me_setting_privacy);
        me_setting_clearcache = (LinearLayout) findViewById(R.id.me_setting_clearcache);
        me_setting_feedback = (LinearLayout) findViewById(R.id.me_setting_feedback);
        me_setting_problem = (LinearLayout) findViewById(R.id.me_setting_problem);
    }

    private void Listener(){
        me_setting_updateloginpwd.setOnClickListener(this);
        me_setting_updateloginpwd.setOnTouchListener(this);

        me_setting_updatetradepwd.setOnClickListener(this);
        me_setting_updatetradepwd.setOnTouchListener(this);

        me_setting_gesture.setOnClickListener(this);
        me_setting_gesture.setOnTouchListener(this);

        me_setting_changephonenum.setOnClickListener(this);
        me_setting_changephonenum.setOnTouchListener(this);

        me_setting_pay.setOnClickListener(this);
        me_setting_pay.setOnTouchListener(this);

        me_setting_message.setOnClickListener(this);
        me_setting_message.setOnTouchListener(this);

        me_setting_privacy.setOnClickListener(this);
        me_setting_privacy.setOnTouchListener(this);

        me_setting_clearcache.setOnClickListener(this);
        me_setting_clearcache.setOnTouchListener(this);

        me_setting_feedback.setOnClickListener(this);
        me_setting_feedback.setOnTouchListener(this);

        me_setting_problem.setOnClickListener(this);
        me_setting_problem.setOnTouchListener(this);
    }

    public void back(View view){
        finish();
    }

    private void startActivity(View v){
        switch (v.getId()){
            case R.id.me_setting_updateloginpwd:
                startActivity(new Intent(this,Setting_UpdateLoginPwdActivity.class));
                break;
            case R.id.me_setting_updatetradepwd:
                startActivity(new Intent(this,Setting_UpdateTradePwdActivity.class));
                break;
            case R.id.me_setting_gesture:
                startActivity(new Intent(this,Setting_GestureActivity.class));
                break;
            case R.id.me_setting_changephonenum:
                startActivity(new Intent(this,Setting_ChangePhoneNumActivity.class));
                break;
            case R.id.me_setting_pay:
                startActivity(new Intent(this,Setting_PayActivity.class));
                break;
            case R.id.me_setting_message:
                startActivity(new Intent(this,Setting_MessageActivity.class));
                break;
            case R.id.me_setting_privacy:
                startActivity(new Intent(this,Setting_PrivacyActivity.class));
                break;
            case R.id.me_setting_clearcache:
                startActivity(new Intent(this, Setting_ClearCacheActivity.class));
                break;
            case R.id.me_setting_feedback:
                startActivity(new Intent(this, Setting_FeedBackActivity.class));
                break;
            case R.id.me_setting_problem:
                startActivity(new Intent(this, Setting_ProblemActivity.class));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(v);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            //触摸屏幕时刻
            case MotionEvent.ACTION_DOWN:  // = 0
                switch (v.getId()){
                    case R.id.me_setting_updateloginpwd:
                        me_setting_updateloginpwd.setSelected(true);
                        break;
                    case R.id.me_setting_updatetradepwd:
                        me_setting_updatetradepwd.setSelected(true);
                        break;
                    case R.id.me_setting_gesture:
                        me_setting_gesture.setSelected(true);
                        break;
                    case R.id.me_setting_changephonenum:
                        me_setting_changephonenum.setSelected(true);
                        break;
                    case R.id.me_setting_pay:
                        me_setting_pay.setSelected(true);
                        break;
                    case R.id.me_setting_message:
                        me_setting_message.setSelected(true);
                        break;
                    case R.id.me_setting_privacy:
                        me_setting_privacy.setSelected(true);
                        break;
                    case R.id.me_setting_clearcache:
                        me_setting_clearcache.setSelected(true);
                        break;
                    case R.id.me_setting_feedback:
                        me_setting_feedback.setSelected(true);
                        break;
                    case R.id.me_setting_problem:
                        me_setting_problem.setSelected(true);
                        break;
                }
                break;
            //终止触摸时刻
            case MotionEvent.ACTION_UP:  // = 1
                me_setting_updateloginpwd.setSelected(false);
                me_setting_updatetradepwd.setSelected(false);
                me_setting_gesture.setSelected(false);
                me_setting_changephonenum.setSelected(false);
                me_setting_pay.setSelected(false);
                me_setting_message.setSelected(false);
                me_setting_privacy.setSelected(false);
                me_setting_clearcache.setSelected(false);
                me_setting_feedback.setSelected(false);
                me_setting_problem.setSelected(false);

                onClick(v);
                break;
        }
        return false;
    }
}
