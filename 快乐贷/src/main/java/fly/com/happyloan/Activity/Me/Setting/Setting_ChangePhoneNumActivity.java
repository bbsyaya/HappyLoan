package fly.com.happyloan.Activity.Me.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Setting_ChangePhoneNumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_chang_phone_num);
    }

    public void Portrait(View view){
        //肖像认证
        Toast.makeText(Setting_ChangePhoneNumActivity.this, "肖像认证", Toast.LENGTH_SHORT).show();
    }

    public void BankCard(View view){
        //银行卡认证
        Toast.makeText(Setting_ChangePhoneNumActivity.this, "银行卡认证", Toast.LENGTH_SHORT).show();
    }

    public void back(View view){
        //返回
        finish();
    }

}
