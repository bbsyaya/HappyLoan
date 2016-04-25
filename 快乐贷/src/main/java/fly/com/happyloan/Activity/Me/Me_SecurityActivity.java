package fly.com.happyloan.Activity.Me;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Me_SecurityActivity extends Activity implements View.OnClickListener {

    Switch aSwitch;
    TextView textView;
    TextView me_security_edit;//编辑

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_security);

        aSwitch = (Switch) findViewById(R.id.me_security_switch);
        textView = (TextView) findViewById(R.id.equipment_type);
        me_security_edit = (TextView) findViewById(R.id.me_security_edit);
        intoType();
        init();
        listener();
    }

    public void back(View view){
        finish();
    }
    private void init(){
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    aSwitch.setChecked(true);
                    Toast.makeText(Me_SecurityActivity.this, "开关已打开，开始保护账号安全",Toast.LENGTH_SHORT).show();
                }else {
                    aSwitch.setChecked(false);
                    Toast.makeText(Me_SecurityActivity.this, "开关已关闭，不再保护账号安全", Toast.LENGTH_SHORT).show();
                }
            }
        };
        aSwitch.setOnCheckedChangeListener(listener);
    }

    private void intoType(){
        textView.setText("手机型号: " + android.os.Build.MODEL + "\n"
                + "API:" + android.os.Build.VERSION.SDK + "\n"
                + "安卓版本:" + android.os.Build.VERSION.RELEASE);
    }

    public void listener(){
        me_security_edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(Me_SecurityActivity.this, "编辑！", Toast.LENGTH_SHORT).show();
    }
}
