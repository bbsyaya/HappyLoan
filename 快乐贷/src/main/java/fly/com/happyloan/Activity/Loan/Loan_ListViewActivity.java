package fly.com.happyloan.Activity.Loan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Loan_ListViewActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView loan_listView_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_list_view);
        loan_listView_back = (ImageView) findViewById(R.id.loan_listView_back);
        listener();
    }

    public void listener(){
        loan_listView_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loan_listView_back:
                finish();
                break;
        }
    }

    public void gainInterest(View view){
        Toast.makeText(Loan_ListViewActivity.this, "赚利差！", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,Loan_ListVIew_GainInterestActivity.class));
    }

}
