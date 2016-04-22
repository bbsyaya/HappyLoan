package fly.com.happyloan.Activity.Me.Wallet;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Bankcard_InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankcard_information);
    }
    public void Back(View view){
        finish();
    }
    public void Warn(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("手机号说明");
        builder.setPositiveButton("确定", null);
        builder.setMessage("银行预留手机号码是办理该银行卡是所填写的手机号码。" +
                "没有预留、手机号忘记或者已停用，请联系银行客服更新处理。");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void Next(View view){
        Toast.makeText(this, "功能正在完善中...", Toast.LENGTH_SHORT).show();
    }
}
