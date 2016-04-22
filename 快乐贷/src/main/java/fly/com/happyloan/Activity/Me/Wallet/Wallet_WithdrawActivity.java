package fly.com.happyloan.Activity.Me.Wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Wallet_WithdrawActivity extends AppCompatActivity {

    LinearLayout me_bankcard_withdraw_messages;
    TextView me_wallet_withdraw_messages;
    EditText edt_withdraw_money_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet__withdraw);

        me_bankcard_withdraw_messages = (LinearLayout) findViewById(R.id.me_bankcard_withdraw_messages);
        me_wallet_withdraw_messages = (TextView) findViewById(R.id.me_wallet_withdraw_messages);
        edt_withdraw_money_number = (EditText) findViewById(R.id.edt_withdraw_money_number);
    }
    public void Back(View view){
        finish();
    }
    public void Withdraw(View view){
        Toast.makeText(this, "提现成功！", Toast.LENGTH_SHORT).show();
    }
}
