package fly.com.happyloan.Activity.Me.BorrowOut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.Activity.Me.BorrowCome.Me_BorrowComeActivity;
import fly.com.happyloan.Activity.Me.BorrowCome.Me_BorrowCome_BorrowCome_HistoryActivity;
import fly.com.happyloan.R;

public class Me_BorrowOutActivity extends Activity implements View.OnClickListener {

    TextView me_borrowOute_borrowOut;//借出的金额
    TextView me_borrowOut_Incomeinterest;//应收利息的金额
    TextView me_borrowCome_interestIncomeCount;//利息收入总额的金额
    TextView borrowOut_history;
    LinearLayout me_borrowOut_interest;
    ListView me_borrowOut_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_borrow_out);
        me_borrowOute_borrowOut = (TextView) findViewById(R.id.me_borrowOute_borrowOut);
        me_borrowOut_Incomeinterest = (TextView) findViewById(R.id.me_borrowOut_Incomeinterest);
        me_borrowCome_interestIncomeCount = (TextView) findViewById(R.id.me_borrowCome_interestIncomeCount);
        borrowOut_history = (TextView) findViewById(R.id.borrowOut_history);
        me_borrowOut_interest = (LinearLayout) findViewById(R.id.me_borrowOut_interest);
        me_borrowOut_listView = (ListView) findViewById(R.id.me_borrowOut_listView);
        listener();
    }

    public void listener(){
        borrowOut_history.setOnClickListener(this);
        me_borrowOut_interest.setOnClickListener(this);
    }

    public void back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.borrowOut_history:
                Toast.makeText(Me_BorrowOutActivity.this, "历史记录", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Me_BorrowOut_BorrowOut_HistoryActivity.class));
                break;
            case R.id.me_borrowOut_interest:
                Toast.makeText(Me_BorrowOutActivity.this, "利息支出总额", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Me_BorrowOut_BorrowOut_InterestActivity.class));
                break;
        }
    }
}
