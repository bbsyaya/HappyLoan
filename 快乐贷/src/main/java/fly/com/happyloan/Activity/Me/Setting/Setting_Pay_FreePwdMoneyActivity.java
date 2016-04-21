package fly.com.happyloan.Activity.Me.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Setting_Pay_FreePwdMoneyActivity extends AppCompatActivity implements View.OnClickListener {

    TextView me_setting_pay_freePwdMoney_one;
    TextView me_setting_pay_freePwdMoney_two;
    TextView me_setting_pay_freePwdMoney_three;
    TextView me_setting_pay_freePwdMoney_four;
    TextView me_setting_pay_freePwdMoney_five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_pay_free_pwd_money);
        me_setting_pay_freePwdMoney_one = (TextView) findViewById(R.id.me_setting_pay_freePwdMoney_one);
        me_setting_pay_freePwdMoney_two = (TextView) findViewById(R.id.me_setting_pay_freePwdMoney_two);
        me_setting_pay_freePwdMoney_three = (TextView) findViewById(R.id.me_setting_pay_freePwdMoney_three);
        me_setting_pay_freePwdMoney_four = (TextView) findViewById(R.id.me_setting_pay_freePwdMoney_four);
        me_setting_pay_freePwdMoney_five = (TextView) findViewById(R.id.me_setting_pay_freePwdMoney_five);
        linstener();
    }

    public void linstener(){
        me_setting_pay_freePwdMoney_one.setOnClickListener(this);
        me_setting_pay_freePwdMoney_two.setOnClickListener(this);
        me_setting_pay_freePwdMoney_three.setOnClickListener(this);
        me_setting_pay_freePwdMoney_four.setOnClickListener(this);
        me_setting_pay_freePwdMoney_five.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_setting_pay_freePwdMoney_one:
                Toast.makeText(Setting_Pay_FreePwdMoneyActivity.this, "100元/笔", Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_setting_pay_freePwdMoney_two:
                Toast.makeText(Setting_Pay_FreePwdMoneyActivity.this, "200元/笔", Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_setting_pay_freePwdMoney_three:
                Toast.makeText(Setting_Pay_FreePwdMoneyActivity.this, "300元/笔", Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_setting_pay_freePwdMoney_four:
                Toast.makeText(Setting_Pay_FreePwdMoneyActivity.this, "400元/笔", Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_setting_pay_freePwdMoney_five:
                Toast.makeText(Setting_Pay_FreePwdMoneyActivity.this, "500元/笔", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void back(View view){
        //返回
        finish();
    }
}
