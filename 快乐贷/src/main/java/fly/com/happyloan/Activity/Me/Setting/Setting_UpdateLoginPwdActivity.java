package fly.com.happyloan.Activity.Me.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Setting_UpdateLoginPwdActivity extends AppCompatActivity {

    EditText updateloginpwd_oldpwd;
    EditText updateloginpwd_newpwd;
    EditText updateloginpwd_againnewpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_update_login_pwd);
    }

    public void back(View view){
        finish();
    }

    public void submit(View view){
        Toast.makeText(Setting_UpdateLoginPwdActivity.this, "提交按钮！", Toast.LENGTH_SHORT).show();
    }

}
