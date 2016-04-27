package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

public class Me_NicknameActivity extends AppCompatActivity {

    EditText edt_nickname;
    Happy_user user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__nickname);

        user = BmobUser.getCurrentUser(this,Happy_user.class);

        edt_nickname = (EditText) findViewById(R.id.edt_nickname);
        String nickname = getIntent().getStringExtra("nickname");
        edt_nickname.setText(nickname);
    }

    public void Save(View v){
        String nickname = edt_nickname.getText().toString();
        user.setNickname(nickname);
        user.update(this, user.getObjectId(), new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("更新", "更新成功！");
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("更新", "更新失败" + s);
            }
        });
    }
    public void Back(View v){
        finish();
    }
}
