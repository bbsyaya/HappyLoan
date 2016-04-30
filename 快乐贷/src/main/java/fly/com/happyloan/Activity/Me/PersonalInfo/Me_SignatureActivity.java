package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

public class Me_SignatureActivity extends AppCompatActivity {

    EditText edt_signature;
    TextView edt_txt_number;
    Happy_user user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_signature);

        user = BmobUser.getCurrentUser(this,Happy_user.class);

        edt_signature = (EditText) findViewById(R.id.edt_signature);
        edt_txt_number = (TextView) findViewById(R.id.edt_txt_number);

        //意图接收
        String signature = getIntent().getStringExtra("signature");
        edt_signature.setText(signature);
        edt_txt_number.setText(String.valueOf(30 - signature.length()));
    }
    public void Save(View v){

        String signature = edt_signature.getText().toString();
        user.setSignature(signature);
        user.update(this, user.getObjectId(), new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("更新","更新成功！");
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("更新","更新失败"+s);
            }
        });
    }
    public void Back(View v){
        finish();
    }
}
