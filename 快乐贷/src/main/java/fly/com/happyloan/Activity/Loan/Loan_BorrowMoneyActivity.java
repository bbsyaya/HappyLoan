package fly.com.happyloan.Activity.Loan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import fly.com.happyloan.R;

public class Loan_BorrowMoneyActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView loan_borrowMoney_AboutborrowMoney;
    EditText edt_BorrowMoney;//借款金额
    TextView tv_RefundData;//还款日期
    EditText edt_YearInterest;//年利率
    TextView tv_Firend;//指定好友
    Button loan_borrowMoney_submit;
    LinearLayout loan_borrowMoney_friend;
    LinearLayout loan_borrowMoney_RefundData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_borrow_money);
        loan_borrowMoney_AboutborrowMoney = (ImageView) findViewById(R.id.loan_borrowMoney_AboutborrowMoney);
        edt_BorrowMoney = (EditText) findViewById(R.id.edt_BorrowMoney);
        tv_RefundData = (TextView) findViewById(R.id.tv_RefundData);
        edt_YearInterest = (EditText) findViewById(R.id.edt_YearInterest);
        tv_Firend = (TextView) findViewById(R.id.tv_Firend);
        loan_borrowMoney_submit = (Button) findViewById(R.id.loan_borrowMoney_submit);
        loan_borrowMoney_friend = (LinearLayout) findViewById(R.id.loan_borrowMoney_friend);
        loan_borrowMoney_RefundData = (LinearLayout) findViewById(R.id.loan_borrowMoney_RefundData);
        listener();
    }

    public void listener(){
        loan_borrowMoney_AboutborrowMoney.setOnClickListener(this);
        loan_borrowMoney_friend.setOnClickListener(this);
        loan_borrowMoney_submit.setOnClickListener(this);
        loan_borrowMoney_RefundData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loan_borrowMoney_AboutborrowMoney:
                Toast.makeText(Loan_BorrowMoneyActivity.this, "关于我要借钱!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Loan_BorrowMoney_AboutBorrowMoneyActivity.class));
                break;
            case R.id.loan_borrowMoney_friend:
                startActivity(new Intent(this,Loan_BorrowMoney_FriendActivity.class));
                Toast.makeText(Loan_BorrowMoneyActivity.this, "指定好友!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.loan_borrowMoney_submit:
                Toast.makeText(Loan_BorrowMoneyActivity.this, "提交！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.loan_borrowMoney_RefundData:
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp_dialog = new DatePickerDialog(this,null,year,month,day);
                dp_dialog.show();
                break;
        }
    }

    public void back (View view){
        finish();
    }

}
