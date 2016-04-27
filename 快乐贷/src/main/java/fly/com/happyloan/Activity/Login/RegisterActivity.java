package fly.com.happyloan.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.RequestSMSCodeListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.VerifySMSCodeListener;
import fly.com.happyloan.Activity.MainActivity;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

public class RegisterActivity extends AppCompatActivity {

    EditText register_phone_number;
    EditText register_pwd;
    EditText register_verification_code;
    Button verification_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_phone_number = (EditText) findViewById(R.id.register_phone_number);
        register_pwd = (EditText) findViewById(R.id.register_pwd);
        register_verification_code = (EditText) findViewById(R.id.register_verification_code);
        verification_code = (Button) findViewById(R.id.verification_code);

//        if (!register_phone_number.equals("") && !register_pwd.equals("")) {
//            verification_code.setEnabled(true);
//        }

    }

    public void VerificationCode(View view) {
        BmobSMS.requestSMSCode(this, register_phone_number.getText().toString(), "注册验证码",
                new RequestSMSCodeListener() {
            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {//验证码发送成功
                    Log.i("smile", "短信id：" + integer);//用于查询本次短信发送详情
                }
            }
        });
    }

    public void Register(View view) {

        final String username = register_phone_number.getText().toString();
        final String userpwd = register_pwd.getText().toString();
        String verification_code = register_verification_code.getText().toString();

        BmobSMS.verifySmsCode(this, username, verification_code,
                new VerifySMSCodeListener() {

            @Override
            public void done(BmobException ex) {

                if (ex == null) {//短信验证码已验证成功
                    Log.i("快乐贷", "验证通过");
                    Happy_user user = new Happy_user();
                    user.setUsername(username);
                    user.setPassword(userpwd);
                    user.setNickname(username); //默认为用户名
                    user.signUp(RegisterActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Log.i("快乐贷", "注册成功");
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(RegisterActivity.this, "注册失败！", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(RegisterActivity.this, "验证码错误！", Toast.LENGTH_SHORT).show();

                    Log.i("快乐贷", "验证失败：code =" + ex.getErrorCode()
                            + ",msg = " + ex.getLocalizedMessage());
                }
            }
        });
    }

    public void Back(View v) {
        finish();
    }
}
