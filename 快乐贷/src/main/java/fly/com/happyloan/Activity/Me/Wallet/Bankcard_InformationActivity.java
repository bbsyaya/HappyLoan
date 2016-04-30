package fly.com.happyloan.Activity.Me.Wallet;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import fly.com.happyloan.Object.Happy_bank;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;
import fly.com.happyloan.Util.App;

public class Bankcard_InformationActivity extends AppCompatActivity {

    TextView me_bank_name;
    EditText me_bankcard_phone_number;
    Happy_bank bank;
    Happy_user user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankcard_information);

        App.getInstance().addActivity(this);

        me_bank_name = (TextView) findViewById(R.id.me_bank_name);
        me_bankcard_phone_number = (EditText) findViewById(R.id.me_bankcard_phone_number);

    }
    public void Back(View view){
        finish();
    }
    public void Warn(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("手机号说明");
        builder.setPositiveButton("确定", null);
        builder.setMessage("银行预留手机号码是办理该银行卡是所填写的手机号码。" +
                "没有预留、手机号忘记或者已停用，请联系银行客服更新处理。");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void Next(View view){
        user = BmobUser.getCurrentUser(this,Happy_user.class);
        bank = new Happy_bank();
        String bank_num = getIntent().getStringExtra("bank_num");
        bank.setBackType(me_bank_name.getText().toString());
        bank.setCardNo(bank_num);
        bank.setHolder(user.getName());
        bank.setCardType("储蓄卡");
        bank.setUsername(user.getUsername());
        String phone = me_bankcard_phone_number.getText().toString();
        bank.setRservedPhone(phone);

        if (!phone.equals("") && phone.length() == 11) {
            bank.save(this, new SaveListener() {
                @Override
                public void onSuccess() {
                    Log.i("添加数据成功", "ID" + bank.getObjectId());
                }

                @Override
                public void onFailure(int i, String s) {
                    Log.i("添加数据失败", s);
                }
            });
        }
    }
}
