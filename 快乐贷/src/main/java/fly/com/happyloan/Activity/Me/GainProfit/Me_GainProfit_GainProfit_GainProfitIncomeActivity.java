package fly.com.happyloan.Activity.Me.GainProfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Me_GainProfit_GainProfit_GainProfitIncomeActivity extends AppCompatActivity {

    TextView me_GainProfit_GainProfitIncome_Incomecount;//收益总额的金额
    TextView me_GainProfit_GainProfitIncome_OneAvgIncome;//单笔平均收益
    ListView me_GainProfit_GainProfitIncome_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_gain_profit_gain_profit_gain_profit_income);
        me_GainProfit_GainProfitIncome_Incomecount = (TextView) findViewById(R.id.me_GainProfit_GainProfitIncome_Incomecount);
        me_GainProfit_GainProfitIncome_OneAvgIncome = (TextView) findViewById(R.id.me_GainProfit_GainProfitIncome_OneAvgIncome);
        me_GainProfit_GainProfitIncome_list = (ListView) findViewById(R.id.me_GainProfit_GainProfitIncome_list);
    }

    public void back(View view){
        finish();
    }

}
