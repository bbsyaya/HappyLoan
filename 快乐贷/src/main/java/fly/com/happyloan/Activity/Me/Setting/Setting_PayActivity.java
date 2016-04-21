package fly.com.happyloan.Activity.Me.Setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import fly.com.happyloan.R;

public class Setting_PayActivity extends AppCompatActivity implements View.OnClickListener {

    Switch switch_freePwdPay;//小额免密支付开关
    LinearLayout me_setting_pay_freePwdMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_pay);
        me_setting_pay_freePwdMoney = (LinearLayout) findViewById(R.id.me_setting_pay_freePwdMoney);
        switch_freePwdPay = (Switch) findViewById(R.id.switch_freePwdPay);
        Onclick();
    }

    public void Onclick(){
        me_setting_pay_freePwdMoney.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, Setting_Pay_FreePwdMoneyActivity.class));
    }

    public void back(View view){
        //返回
        finish();
    }

}
