package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Me_PersonalInfoActivity extends AppCompatActivity implements
        View.OnClickListener, View.OnTouchListener {

    ImageView me_info_back;
    LinearLayout me_personal_info_details;
    LinearLayout me_info_scan;
    Button me_login_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_personal_info);

        findViewById();
        Listener();
    }
    private void findViewById(){
        me_info_back = (ImageView) findViewById(R.id.me_info_back);
        me_personal_info_details = (LinearLayout) findViewById(R.id.me_personal_info_details);
        me_info_scan = (LinearLayout) findViewById(R.id.me_info_scan);
        me_login_out = (Button) findViewById(R.id.me_login_out);
    }
    private void Listener(){
        me_info_back.setOnClickListener(this);

        me_personal_info_details.setOnTouchListener(this);
        me_personal_info_details.setOnClickListener(this);

        me_info_scan.setOnTouchListener(this);
        me_info_scan.setOnClickListener(this);

        me_login_out.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_info_back:
                onBackPressed();
                break;
            case R.id.me_login_out:
                showLoginOutDialog();
                break;
            case R.id.me_personal_info_details:
                startActivity(v);
                break;
            case R.id.me_info_scan:
                startActivity(v);
                break;
        }
    }

    private void showLoginOutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("你确定要退出当前账户?\n\n");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(Me_PersonalInfoActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(Me_PersonalInfoActivity.this, "取消", Toast.LENGTH_SHORT).show();
                }
            }
        };
        builder.setPositiveButton("确定", listener);
        builder.setNegativeButton("取消", listener);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void startActivity(View v){
        switch (v.getId()){
            case R.id.me_personal_info_details:
                startActivity(new Intent(this,Me_AccountDetailsActivity.class));
                break;
            case R.id.me_info_scan:
                startActivity(new Intent(this,Me_ScanActivity.class));
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()){
            //触摸屏幕时刻
            case MotionEvent.ACTION_DOWN:  // = 0
                switch (v.getId()){
                    case R.id.me_personal_info_details:
                        me_personal_info_details.setSelected(true);
                        break;
                    case R.id.me_info_scan:
                        me_info_scan.setSelected(true);
                        break;
                }
                break;
            //终止触摸时刻
            case MotionEvent.ACTION_UP:  // = 1
                me_personal_info_details.setSelected(false);
                me_info_scan.setSelected(false);

                onClick(v);
                break;
        }
        return false;
    }
}
