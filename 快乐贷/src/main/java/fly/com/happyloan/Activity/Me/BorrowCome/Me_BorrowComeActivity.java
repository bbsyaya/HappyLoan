package fly.com.happyloan.Activity.Me.BorrowCome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Me_BorrowComeActivity extends Activity implements View.OnClickListener {

    TextView borrowCom_history;
    LinearLayout me_borrowCome_interest;
    ListView me_borrowCome_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_borrow_come);
        //
        borrowCom_history = (TextView) findViewById(R.id.borrowCom_history);
        me_borrowCome_interest = (LinearLayout) findViewById(R.id.me_borrowCome_interest);
        me_borrowCome_listView = (ListView) findViewById(R.id.me_borrowCome_listView);
        listener();
    }

    public void listener(){
        borrowCom_history.setOnClickListener(this);
        me_borrowCome_interest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.borrowCom_history:
                startActivity(new Intent(this,Me_BorrowCome_BorrowCome_HistoryActivity.class));
                Toast.makeText(Me_BorrowComeActivity.this, "历史记录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_borrowCome_interest:
                startActivity(new Intent(this,Me_BorrowCome_BorrowCome_InterestActivity.class));
                Toast.makeText(Me_BorrowComeActivity.this, "利息支出总额", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void back(View view){
        finish();
    }
}
