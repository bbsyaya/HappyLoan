package fly.com.happyloan.Activity.Me.BorrowOut;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Me_BorrowOut_BorrowOut_HistoryActivity extends AppCompatActivity {

    TextView me_borrowOut_history_borrowOut;//借入的金额
    TextView me_borrowOut_history_interestIncome;//利息支出的金额
    ListView me_borrowOut_history_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_borrow_out_borrow_out_history);
        me_borrowOut_history_borrowOut = (TextView) findViewById(R.id.me_borrowOut_history_borrowOut);
        me_borrowOut_history_interestIncome = (TextView) findViewById(R.id.me_borrowOut_history_interestIncome);
        me_borrowOut_history_listView = (ListView) findViewById(R.id.me_borrowOut_history_listView);
    }

    public void back(View view){
        finish();
    }
}
