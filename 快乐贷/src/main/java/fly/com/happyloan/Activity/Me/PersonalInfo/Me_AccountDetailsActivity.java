package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fly.com.happyloan.R;

public class Me_AccountDetailsActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    LinearLayout me_account_head_linear;
    LinearLayout me_account_nickname_linear;
    LinearLayout me_account_signature_linear;
    LinearLayout me_account_identity_linear;

    ImageView me_account_head_image;
    TextView me_account_nickname;
    TextView me_account_signature;
    TextView me_account_Email;
    TextView me_account_phone;
    TextView me_account_identity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_account_details);
        findViewById();
        Listener();
    }

    private void findViewById(){
        me_account_head_linear = (LinearLayout) findViewById(R.id.me_account_head_linear);
        me_account_nickname_linear = (LinearLayout) findViewById(R.id.me_account_nickname_linear);
        me_account_signature_linear = (LinearLayout) findViewById(R.id.me_account_signature_linear);
        me_account_identity_linear = (LinearLayout) findViewById(R.id.me_account_identity_linear);

        me_account_head_image = (ImageView) findViewById(R.id.me_account_head_image);
        me_account_nickname = (TextView) findViewById(R.id.me_account_nickname);
        me_account_signature = (TextView) findViewById(R.id.me_account_signature);
        me_account_Email = (TextView) findViewById(R.id.me_account_Email);
        me_account_phone = (TextView) findViewById(R.id.me_account_phone);
        me_account_identity = (TextView) findViewById(R.id.me_account_identity);
    }
    private void Listener(){
        me_account_head_linear.setOnTouchListener(this);
        me_account_head_linear.setOnClickListener(this);

        me_account_nickname_linear.setOnTouchListener(this);
        me_account_nickname_linear.setOnClickListener(this);

        me_account_signature_linear.setOnTouchListener(this);
        me_account_signature_linear.setOnClickListener(this);

        me_account_identity_linear.setOnTouchListener(this);
        me_account_identity_linear.setOnClickListener(this);


    }

    public void Back(View v){
        finish();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            //触摸屏幕时刻
            case MotionEvent.ACTION_DOWN:  // = 0
                switch (v.getId()){
                    case R.id.me_account_head_linear:
                        me_account_head_linear.setSelected(true);
                        break;
                    case R.id.me_account_nickname_linear:
                        me_account_nickname_linear.setSelected(true);
                        break;
                    case R.id.me_account_signature_linear:
                        me_account_signature_linear.setSelected(true);
                        break;
                    case R.id.me_account_identity_linear:
                        me_account_identity_linear.setSelected(true);
                        break;
                }
                break;
            //终止触摸时刻
            case MotionEvent.ACTION_UP:  // = 1
                me_account_head_linear.setSelected(false);
                me_account_nickname_linear.setSelected(false);
                me_account_signature_linear.setSelected(false);
                me_account_identity_linear.setSelected(false);

                onClick(v);
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        startActivity(v);
    }

    private void startActivity(View v){
        switch (v.getId()){
            case R.id.me_account_head_linear:
                startActivity(new Intent(this,Me_SettingHeadActivity.class));
                break;
            case R.id.me_account_nickname_linear:
                startActivity(new Intent(this,Me_NicknameActivity.class));
                break;
            case R.id.me_account_signature_linear:
                startActivity(new Intent(this,Me_SignatureActivity.class));
                break;
            case R.id.me_account_identity_linear:
                startActivity(new Intent(this,Me_IdentityActivity.class));
                break;
        }
    }
}
