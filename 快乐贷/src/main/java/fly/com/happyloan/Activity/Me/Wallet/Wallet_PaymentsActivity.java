package fly.com.happyloan.Activity.Me.Wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import fly.com.happyloan.R;

public class Wallet_PaymentsActivity extends AppCompatActivity {

    ListView me_wallet_payments_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_payments);

        me_wallet_payments_list = (ListView) findViewById(R.id.me_wallet_payments_list);
    }

    public void Back(View view){
        finish();
    }
}
