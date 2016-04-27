package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import cn.bmob.v3.BmobUser;
import fly.com.happyloan.Object.Happy_user;
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

    Happy_user user;
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

        initDate();
    }

    private void initDate(){

        user = BmobUser.getCurrentUser(this,Happy_user.class);
        String image_url = user.getHeadImage().getUrl();
        ImageLoader.getInstance().displayImage(image_url,me_account_head_image);

        me_account_nickname.setText(user.getNickname());
        me_account_signature.setText(user.getSignature());
        me_account_Email.setText(user.getEmail());
        me_account_phone.setText(user.getUsername());
        me_account_identity.setText(user.getName());

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

        Intent intent;
        switch (v.getId()){
            case R.id.me_account_head_linear:
                intent = new Intent(this,Me_SettingHeadActivity.class);
                startActivity(intent);
                break;
            case R.id.me_account_nickname_linear:
                intent = new Intent(this,Me_NicknameActivity.class);
                intent.putExtra("nickname", me_account_nickname.getText());
                startActivity(intent);
                break;
            case R.id.me_account_signature_linear:
                intent = new Intent(this,Me_SignatureActivity.class);
                intent.putExtra("signature", me_account_signature.getText());
                startActivity(intent);
                break;
            case R.id.me_account_identity_linear:
                intent = new Intent(this,Me_IdentityActivity.class);
                intent.putExtra("name",me_account_identity.getText());
                intent.putExtra("IDCard",user.getIDCard());
                startActivity(intent);
                break;
        }
    }
}
