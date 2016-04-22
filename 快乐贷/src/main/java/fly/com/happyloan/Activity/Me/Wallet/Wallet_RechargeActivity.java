package fly.com.happyloan.Activity.Me.Wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Wallet_RechargeActivity extends AppCompatActivity {

    LinearLayout me_bankcard_recharge_messages;
    TextView me_wallet_recharge_messages;
    EditText edt_recharge_money_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet__recharge);

        me_bankcard_recharge_messages = (LinearLayout) findViewById(R.id.me_bankcard_recharge_messages);
        me_wallet_recharge_messages = (TextView) findViewById(R.id.me_wallet_recharge_messages);
        edt_recharge_money_number = (EditText) findViewById(R.id.edt_recharge_money_number);
    }

    public void Back(View view){
        finish();
    }
    public void Recharge(View view){
        Toast.makeText(this, "充值成功", Toast.LENGTH_SHORT).show();
    }
}
