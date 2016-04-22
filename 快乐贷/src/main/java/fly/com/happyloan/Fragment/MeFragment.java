package fly.com.happyloan.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import fly.com.happyloan.Activity.Me.BorrowCome.Me_BorrowComeActivity;
import fly.com.happyloan.Activity.Me.BorrowOut.Me_BorrowOutActivity;
import fly.com.happyloan.Activity.Me.GainProfit.Me_GainProfitActivity;
import fly.com.happyloan.Activity.Me.Me_AboutActivity;
import fly.com.happyloan.Activity.Me.Me_SecurityActivity;
import fly.com.happyloan.Activity.Me.Me_SincereActivity;
import fly.com.happyloan.Activity.Me.PersonalInfo.Me_PersonalInfoActivity;
import fly.com.happyloan.Activity.Me.Setting.SettingActivity;
import fly.com.happyloan.Activity.Me.Wallet.Me_WalletActivity;
import fly.com.happyloan.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener,View.OnTouchListener{

    LinearLayout me_personal_info;
    LinearLayout me_borrow_come;
    LinearLayout me_borrow_out;
    LinearLayout me_profit;
    LinearLayout me_sincere;
    LinearLayout me_money;
    LinearLayout me_security;
    LinearLayout me_about;

    TextView me_borrow_come_money;
    TextView me_borrow_out_money;
    TextView me_profit_money;
    TextView me_setting;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        //设置
        me_setting = (TextView)view.findViewById(R.id.me_setting);
        //每项的显示
        me_personal_info = (LinearLayout) view.findViewById(R.id.me_personal_info);
        me_borrow_come = (LinearLayout) view.findViewById(R.id.me_borrow_come);
        me_borrow_out = (LinearLayout) view.findViewById(R.id.me_borrow_out);
        me_profit = (LinearLayout) view.findViewById(R.id.me_profit);
        me_sincere = (LinearLayout) view.findViewById(R.id.me_sincere);
        me_money = (LinearLayout) view.findViewById(R.id.me_money);
        me_security = (LinearLayout) view.findViewById(R.id.me_security);
        me_about = (LinearLayout) view.findViewById(R.id.me_about);

        //借出、借入、利润差的金额显示
        me_borrow_come_money = (TextView) view.findViewById(R.id.me_borrow_come_money);
        me_borrow_out_money = (TextView) view.findViewById(R.id.me_borrow_out_money);
        me_profit_money = (TextView) view.findViewById(R.id.me_profit_money);

        Listener();

        return view;
    }
    private void Listener(){

        me_personal_info.setOnClickListener(this);

        me_borrow_come.setOnClickListener(this);
        me_borrow_come.setOnTouchListener(this);

        me_borrow_out.setOnClickListener(this);
        me_borrow_out.setOnTouchListener(this);

        me_profit.setOnClickListener(this);
        me_profit.setOnTouchListener(this);

        me_sincere.setOnClickListener(this);
        me_sincere.setOnTouchListener(this);

        me_money.setOnClickListener(this);
        me_money.setOnTouchListener(this);

        me_security.setOnClickListener(this);
        me_security.setOnTouchListener(this);

        me_about.setOnClickListener(this);
        me_about.setOnTouchListener(this);

        me_setting.setOnClickListener(this);
    }

    private void startActivity(View v){
        switch (v.getId()){
            case R.id.me_personal_info:
                startActivity(new Intent(getContext(),Me_PersonalInfoActivity.class));
                break;
            case R.id.me_borrow_come:
                startActivity(new Intent(getContext(),Me_BorrowComeActivity.class));
                break;
            case R.id.me_borrow_out:
                startActivity(new Intent(getContext(),Me_BorrowOutActivity.class));
                break;
            case R.id.me_profit:
                startActivity(new Intent(getContext(),Me_GainProfitActivity.class));
                break;
            case R.id.me_sincere:
                startActivity(new Intent(getContext(),Me_SincereActivity.class));
                break;
            case R.id.me_money:
                startActivity(new Intent(getContext(),Me_WalletActivity.class));
                break;
            case R.id.me_security:
                startActivity(new Intent(getContext(),Me_SecurityActivity.class));
                break;
            case R.id.me_about:
                startActivity(new Intent(getContext(),Me_AboutActivity.class));
                break;
            case R.id.me_setting:
                startActivity(new Intent(getContext(), SettingActivity.class));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(v);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()){
            //触摸屏幕时刻
            case MotionEvent.ACTION_DOWN:  // = 0
                switch (v.getId()){
                    case R.id.me_borrow_come:
                        me_borrow_come.setSelected(true);
                        break;
                    case R.id.me_borrow_out:
                        me_borrow_out.setSelected(true);
                        break;
                    case R.id.me_profit:
                        me_profit.setSelected(true);
                        break;
                    case R.id.me_sincere:
                        me_sincere.setSelected(true);
                        break;
                    case R.id.me_money:
                        me_money.setSelected(true);
                        break;
                    case R.id.me_security:
                        me_security.setSelected(true);
                        break;
                    case R.id.me_about:
                        me_about.setSelected(true);
                        break;
                }
                break;
            //终止触摸时刻
            case MotionEvent.ACTION_UP:  // = 1
                me_borrow_come.setSelected(false);
                me_borrow_out.setSelected(false);
                me_profit.setSelected(false);
                me_sincere.setSelected(false);
                me_money.setSelected(false);
                me_security.setSelected(false);
                me_about.setSelected(false);

                onClick(v);
                break;
        }
        return false;
    }

}
