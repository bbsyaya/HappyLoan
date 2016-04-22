package fly.com.happyloan.Activity.Me.GainProfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Me_GainProfit_GainProfit_HistoryActivity extends AppCompatActivity {

    TextView me_GainProfit_history_GainProfit;//赚利差的金额
    TextView me_GainProfit_history_ProfitIncome;//利差收益的金额
    ListView me_GainProfit_history_listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_gain_profit_gain_profit_history);
        me_GainProfit_history_GainProfit = (TextView) findViewById(R.id.me_GainProfit_history_GainProfit);
        me_GainProfit_history_ProfitIncome = (TextView) findViewById(R.id.me_GainProfit_history_ProfitIncome);
        me_GainProfit_history_listView = (ListView) findViewById(R.id.me_GainProfit_history_listView);
    }

    public void back(View view){
        finish();
    }

}
