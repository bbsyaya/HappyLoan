package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Me_SignatureActivity extends AppCompatActivity {

    EditText edt_signature;
    TextView edt_txt_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__signature);

        edt_signature = (EditText) findViewById(R.id.edt_signature);
        edt_txt_number = (TextView) findViewById(R.id.edt_txt_number);
    }
    public void Save(View v){
        Toast.makeText(this, "完成保存", Toast.LENGTH_SHORT).show();
    }
    public void Back(View v){
        finish();
    }
}
