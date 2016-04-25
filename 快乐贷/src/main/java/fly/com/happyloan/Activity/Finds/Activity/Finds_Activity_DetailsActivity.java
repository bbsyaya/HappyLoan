package fly.com.happyloan.Activity.Finds.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Finds_Activity_DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_activity_details);
    }

    public void Attend(View view){
        Toast.makeText(this, "参加", Toast.LENGTH_SHORT).show();
    }
    public void Back(View view){
        finish();
    }
}
