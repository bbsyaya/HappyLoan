package fly.com.happyloan.Activity.Me.BorrowCome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Me_BorrowCome_BorrowCome_InterestActivity extends AppCompatActivity {

    ListView me_BorrowCome_BorrowComeInterest_list;
    TextView me_borrowCome_interest_countinterest;//利息总支出的金额
    TextView me_borrowCome_interest_avg;//平均利率的金额

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_borrow_come_borrow_come_interest);
        me_BorrowCome_BorrowComeInterest_list = (ListView) findViewById(R.id.me_BorrowCome_BorrowComeInterest_list);
        me_borrowCome_interest_countinterest = (TextView) findViewById(R.id.me_borrowCome_interest_countinterest);
        me_borrowCome_interest_avg = (TextView) findViewById(R.id.me_borrowCome_interest_avg);
    }

    public void back(View view){
        finish();
    }

}
