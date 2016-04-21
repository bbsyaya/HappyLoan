package fly.com.happyloan.Activity.Me.BorrowCome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Me_BorrowCome_BorrowCome_HistoryActivity extends AppCompatActivity {

    TextView me_borrowCome_history_borrowCome;//借入的金额
    TextView me_borrowCome_history_interestPay;//利息支出的金额
    ListView me_borrowCome_history_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_borrow_come_borrow_come_history);
        me_borrowCome_history_borrowCome = (TextView) findViewById(R.id.me_borrowCome_history_borrowCome);
        me_borrowCome_history_interestPay = (TextView) findViewById(R.id.me_borrowCome_history_interestPay);
        me_borrowCome_history_listView = (ListView) findViewById(R.id.me_borrowCome_history_listView);
    }

    public void back(View view){
        finish();
    }
}
