package fly.com.happyloan.Activity.Loan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import fly.com.happyloan.R;

public class Loan_KnockdownActivity extends AppCompatActivity {

    ListView loan_knockdown_konckdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_knockdown);
        loan_knockdown_konckdown = (ListView) findViewById(R.id.loan_knockdown_konckdown);
    }

    public void back(View view){
        finish();
    }

}
