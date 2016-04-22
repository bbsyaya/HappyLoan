package fly.com.happyloan.Activity.Me.Wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Me_WalletActivity extends Activity implements View.OnClickListener {

    TextView me_wallet_payments;
    TextView me_wallet_recharge;
    TextView me_wallet_withdraw;
    LinearLayout me_wallet_add_bankcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_wallet);

        findViewById();
        Listener();
    }
    private void findViewById(){
        me_wallet_payments = (TextView) findViewById(R.id.me_wallet_payments);
        me_wallet_recharge = (TextView) findViewById(R.id.me_wallet_recharge);
        me_wallet_withdraw = (TextView) findViewById(R.id.me_wallet_withdraw);
        me_wallet_add_bankcard = (LinearLayout) findViewById(R.id.me_wallet_add_bankcard);
    }
    private void Listener(){
        me_wallet_payments.setOnClickListener(this);
        me_wallet_recharge.setOnClickListener(this);
        me_wallet_withdraw.setOnClickListener(this);
        me_wallet_add_bankcard.setOnClickListener(this);
    }
    public void Back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_wallet_payments:
                startActivity(new Intent(this,Wallet_PaymentsActivity.class));
                break;
            case R.id.me_wallet_recharge:
                startActivity(new Intent(this,Wallet_RechargeActivity.class));
                break;
            case R.id.me_wallet_withdraw:
                startActivity(new Intent(this,Wallet_WithdrawActivity.class));
                break;
            case R.id.me_wallet_add_bankcard:
                startActivity(new Intent(this,Wallet_Add_BankcardActivity.class));
                break;
        }
    }
}
