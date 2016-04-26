package fly.com.happyloan.Activity.Loan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import fly.com.happyloan.R;

public class Loan_ListVIew_GainInterestActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout Loan_ListVIew_GainInterest_friend;//指定好友

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_list_view_gain_interest);
        Loan_ListVIew_GainInterest_friend = (LinearLayout) findViewById(R.id.Loan_ListVIew_GainInterest_friend);
        listener();
    }

    private void listener() {
        Loan_ListVIew_GainInterest_friend.setOnClickListener(this);
    }

    public void back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,Loan_BorrowMoney_FriendActivity.class));
    }
}
