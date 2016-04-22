package fly.com.happyloan.Activity.Me.BorrowOut;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Me_BorrowOut_BorrowOut_InterestActivity extends AppCompatActivity {

    ListView me_BorrowOut_BorrowOutInterest_list;
    TextView me_borrowOut_interest_countinterest;//利息总收入的金额
    TextView me_borrowOut_interest_avg;//平均利率的金额

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_borrow_out_borrow_out_interest);
        me_BorrowOut_BorrowOutInterest_list = (ListView) findViewById(R.id.me_BorrowOut_BorrowOutInterest_list);
        me_borrowOut_interest_countinterest = (TextView) findViewById(R.id.me_borrowOut_interest_countinterest);
        me_borrowOut_interest_avg = (TextView) findViewById(R.id.me_borrowOut_interest_avg);
    }

    public void back(View view){
        finish();
    }

}
