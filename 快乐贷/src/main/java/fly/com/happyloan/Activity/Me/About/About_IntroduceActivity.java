package fly.com.happyloan.Activity.Me.About;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fly.com.happyloan.R;

public class About_IntroduceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_introduce);
    }

    public void back(View view){
        finish();
    }
}
