package fly.com.happyloan.Activity.Me.GainProfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Me_GainProfitActivity extends Activity implements View.OnClickListener {

    TextView me_GainProfit_GainProfit;//赚利差的金额
    TextView me_GainProfit_StayRealizeIncome;//待实现收益的金额
    TextView me_GainProfit_GainProfitIncome;//赚利差总收益的金特
    TextView me_GainProfit_history;
    LinearLayout me_GainProfit_GainProfitIncomes;
    ListView me_GainProfit_listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_profit);

        me_GainProfit_GainProfit = (TextView) findViewById(R.id.me_GainProfit_GainProfit);
        me_GainProfit_history = (TextView) findViewById(R.id.me_GainProfit_history);
        me_GainProfit_StayRealizeIncome = (TextView) findViewById(R.id.me_GainProfit_StayRealizeIncome);
        me_GainProfit_GainProfitIncome = (TextView) findViewById(R.id.me_GainProfit_GainProfitIncome);
        me_GainProfit_GainProfitIncomes = (LinearLayout) findViewById(R.id.me_GainProfit_GainProfitIncomes);
        me_GainProfit_listView = (ListView) findViewById(R.id.me_GainProfit_listView);
        listener();
    }

    public void back(View view){
        finish();
    }

    public void listener(){
        me_GainProfit_history.setOnClickListener(this);
        me_GainProfit_GainProfitIncomes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_GainProfit_history:
                Toast.makeText(Me_GainProfitActivity.this, "历史记录！", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Me_GainProfit_GainProfit_HistoryActivity.class));
                break;
            case R.id.me_GainProfit_GainProfitIncomes:
                Toast.makeText(Me_GainProfitActivity.this, "赚利差总收益！", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Me_GainProfit_GainProfit_GainProfitIncomeActivity.class));
                break;
        }
    }
}
