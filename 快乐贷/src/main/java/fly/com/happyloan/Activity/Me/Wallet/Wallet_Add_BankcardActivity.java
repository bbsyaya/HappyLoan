package fly.com.happyloan.Activity.Me.Wallet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fly.com.happyloan.R;

public class Wallet_Add_BankcardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet__add__bankcard);
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
        startActivity(new Intent(this,Bankcard_InformationActivity.class));
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
