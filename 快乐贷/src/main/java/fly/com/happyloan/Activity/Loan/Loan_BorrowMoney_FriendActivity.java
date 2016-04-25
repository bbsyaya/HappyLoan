package fly.com.happyloan.Activity.Loan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Loan_BorrowMoney_FriendActivity extends AppCompatActivity implements View.OnClickListener {
    
    TextView loan_borrowMoney_friend_cancel;
    ListView loan_borrowMoney_friend_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_borrow_money_friend);
        loan_borrowMoney_friend_cancel = (TextView) findViewById(R.id.loan_borrowMoney_friend_cancel);
        loan_borrowMoney_friend_listView = (ListView) findViewById(R.id.loan_borrowMoney_friend_listView);
        listener();
    }
    
    public void listener(){
        loan_borrowMoney_friend_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loan_borrowMoney_friend_cancel:
                finish();
                break;
        }
    }
}
