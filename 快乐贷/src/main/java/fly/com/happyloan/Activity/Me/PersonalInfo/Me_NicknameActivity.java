package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Me_NicknameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__nickname);
    }

    public void Save(View v){
        Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
    }
    public void Back(View v){
        finish();
    }
}
