package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Me_IdentityActivity extends AppCompatActivity {

    TextView me_authentication_name;
    TextView me_id_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__identity);

        me_authentication_name = (TextView) findViewById(R.id.me_authentication_name);
        me_id_card = (TextView) findViewById(R.id.me_id_card);
    }

    public void Validate(View view){
        Toast.makeText(this, "正在验证", Toast.LENGTH_SHORT).show();
    }

    public void Back(View view){
        finish();
    }
}
