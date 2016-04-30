package fly.com.happyloan.Activity.Me.Wallet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;
import fly.com.happyloan.Util.App;

public class Wallet_Add_BankcardActivity extends AppCompatActivity {

    TextView me_bank_name;
    EditText me_bankcard_number;
    Happy_user user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_add_bankcard);

        App.getInstance().addActivity(this);

        me_bank_name = (TextView) findViewById(R.id.me_bank_name);
        me_bankcard_number = (EditText) findViewById(R.id.me_bankcard_number);

        user = BmobUser.getCurrentUser(this,Happy_user.class);
        me_bank_name.setText(user.getName());
    }

    public void Back(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("取消银行卡绑定?\n\n");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:

                        break;
                }
            }
        };
        builder.setPositiveButton("确定", listener);
        builder.setNegativeButton("取消", listener);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void Next(View v) {
        Intent intent = new Intent(this,Bankcard_InformationActivity.class);
        String bank_num = me_bankcard_number.getText().toString();
        if (!bank_num.equals("") && bank_num.length() == 19){
            intent.putExtra("bank_num",bank_num);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "卡号错误", Toast.LENGTH_SHORT).show();
        }
    }

    public void Warn(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("持卡人说明");
        builder.setPositiveButton("确定", null);
        builder.setMessage("为保障账户资金安全，只能绑定认证用户本人的银行卡。");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
