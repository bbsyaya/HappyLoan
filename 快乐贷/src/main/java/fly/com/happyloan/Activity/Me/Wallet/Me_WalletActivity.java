package fly.com.happyloan.Activity.Me.Wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import fly.com.happyloan.Object.Happy_bank;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

public class Me_WalletActivity extends Activity implements View.OnClickListener {

    TextView me_wallet_payments;
    TextView me_wallet_recharge;
    TextView me_wallet_withdraw;
    TextView me_wallet_balance;
    LinearLayout me_wallet_add_bankcard;
    ListView me_wallet_bankcard;

    Happy_user user;
    SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_wallet);

        findViewById();
        initBankCard();
        Listener();
    }
    private void findViewById(){
        me_wallet_payments = (TextView) findViewById(R.id.me_wallet_payments);
        me_wallet_recharge = (TextView) findViewById(R.id.me_wallet_recharge);
        me_wallet_withdraw = (TextView) findViewById(R.id.me_wallet_withdraw);
        me_wallet_balance = (TextView) findViewById(R.id.me_wallet_balance);
        me_wallet_add_bankcard = (LinearLayout) findViewById(R.id.me_wallet_add_bankcard);
        me_wallet_bankcard = (ListView) findViewById(R.id.me_wallet_bankcard);

        user = BmobUser.getCurrentUser(this, Happy_user.class);
        me_wallet_balance.setText(user.getBalance().toString() + "元");
    }

    private void initBankCard(){
        final ArrayList<HashMap<String,String>> banks = new ArrayList<>();
        BmobQuery<Happy_bank> query = new BmobQuery<>();
        query.addWhereEqualTo("username", user.getUsername());
        query.findObjects(this, new FindListener<Happy_bank>() {
            @Override
            public void onSuccess(List<Happy_bank> list) {
                Log.i("查询正确", "数据" + list.size());
                for (Happy_bank bank : list) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("bank_name", bank.getBackType());
                    map.put("bank_number", bank.getCardNo());
                    banks.add(map);
                }

                String[] from = {"bank_name", "bank_number"};
                int[] to = {R.id.bank_name_list, R.id.bank_number_list};
                adapter = new SimpleAdapter(Me_WalletActivity.this, banks,
                        R.layout.wallet_bank_list, from, to);
                me_wallet_bankcard.setAdapter(adapter);
            }

            @Override
            public void onError(int i, String s) {
                Log.i("查询错误", s);
            }
        });
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
