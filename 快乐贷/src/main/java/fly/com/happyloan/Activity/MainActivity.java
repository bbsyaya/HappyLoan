package fly.com.happyloan.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import fly.com.happyloan.Fragment.FindsFragment;
import fly.com.happyloan.Fragment.FriendsFragment;
import fly.com.happyloan.Fragment.LoanFragment;
import fly.com.happyloan.Fragment.MeFragment;
import fly.com.happyloan.R;

public class MainActivity extends AppCompatActivity {

    FrameLayout frame_content;
    TextView tv_loan;
    TextView tv_friends;
    TextView tv_finds;
    TextView tv_me;

    FragmentManager fm = null;
    FragmentTransaction ft = null; //Fragment事务
    LoanFragment loan_fragment;
    FriendsFragment friends_fragment;
    FindsFragment finds_fragment;
    MeFragment me_fragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        // 碎片
        Fragment();

    }

    private void findViewById(){
        frame_content = (FrameLayout) findViewById(R.id.frame_content);

        tv_loan = (TextView) findViewById(R.id.tv_loan);
        tv_friends = (TextView) findViewById(R.id.tv_friends);
        tv_finds = (TextView) findViewById(R.id.tv_finds);
        tv_me = (TextView) findViewById(R.id.tv_me);
    }

    private void Fragment(){
        fm = getSupportFragmentManager();

        loan_fragment = new LoanFragment();
        friends_fragment = new FriendsFragment();
        finds_fragment = new FindsFragment();
        me_fragment = new MeFragment();

        //默认
        tv_loan.setSelected(true);
        tv_loan.setTextColor(Color.parseColor("#ff00bb9c"));
        ft = fm.beginTransaction();
        ft.add(R.id.frame_content,loan_fragment);
        ft.commit();
    }

    public void change(View v){
        BottomMenu(v);
        if (v.getId() == R.id.tv_loan){

            ft = fm.beginTransaction();
            ft.replace(R.id.frame_content, loan_fragment);
            ft.commit();
        }else if (v.getId() == R.id.tv_friends){

            ft = fm.beginTransaction();
            ft.replace(R.id.frame_content, friends_fragment);
            ft.commit();
        }else if (v.getId() ==R.id.tv_finds){

            ft = fm.beginTransaction();
            ft.replace(R.id.frame_content, finds_fragment);
            ft.commit();
        }else if (v.getId() == R.id.tv_me) {

            ft = fm.beginTransaction();
            ft.replace(R.id.frame_content, me_fragment);
            ft.commit();
        }
    }

    public void BottomMenu(View v){
        if (v.getId() == R.id.tv_loan){

            tv_loan.setSelected(true);
            tv_friends.setSelected(false);
            tv_finds.setSelected(false);
            tv_me.setSelected(false);
            tv_loan.setTextColor(Color.parseColor("#ff00bb9c"));
            tv_friends.setTextColor(Color.parseColor("#000000"));
            tv_finds.setTextColor(Color.parseColor("#000000"));
            tv_me.setTextColor(Color.parseColor("#000000"));

        }else if (v.getId() == R.id.tv_friends){

            tv_loan.setSelected(false);
            tv_friends.setSelected(true);
            tv_finds.setSelected(false);
            tv_me.setSelected(false);
            tv_loan.setTextColor(Color.parseColor("#000000"));
            tv_friends.setTextColor(Color.parseColor("#ff00bb9c"));
            tv_finds.setTextColor(Color.parseColor("#000000"));
            tv_me.setTextColor(Color.parseColor("#000000"));

        }else if (v.getId() ==R.id.tv_finds){

            tv_loan.setSelected(false);
            tv_friends.setSelected(false);
            tv_finds.setSelected(true);
            tv_me.setSelected(false);
            tv_loan.setTextColor(Color.parseColor("#000000"));
            tv_friends.setTextColor(Color.parseColor("#000000"));
            tv_finds.setTextColor(Color.parseColor("#ff00bb9c"));
            tv_me.setTextColor(Color.parseColor("#000000"));

        }else if (v.getId() == R.id.tv_me) {

            tv_loan.setSelected(false);
            tv_friends.setSelected(false);
            tv_finds.setSelected(false);
            tv_me.setSelected(true);
            tv_loan.setTextColor(Color.parseColor("#000000"));
            tv_friends.setTextColor(Color.parseColor("#000000"));
            tv_finds.setTextColor(Color.parseColor("#000000"));
            tv_me.setTextColor(Color.parseColor("#ff00bb9c"));
        }
    }
}
