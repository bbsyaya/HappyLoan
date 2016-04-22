package fly.com.happyloan.Activity.Me.About.Privacy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fly.com.happyloan.R;

public class About_PersonalMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_personal_message);
    }

    public void back(View view){
        finish();
    }
}
