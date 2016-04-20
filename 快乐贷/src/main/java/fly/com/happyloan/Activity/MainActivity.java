package fly.com.happyloan.Activity;

import android.support.v7.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import android.widget.LinearLayout;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //setActionBarLayout(R.layout.actionbar_me, this);
        return true;
    }

    @SuppressLint("NewApi")
    public void setActionBarLayout(int layoutId, Context context) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(layoutId,new LinearLayout(context),false);
            ActionBar.LayoutParams layout = new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
            actionBar.setCustomView(view, layout);
        }
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
        ft = fm.beginTransaction();
        ft.add(R.id.frame_content,loan_fragment);
        ft.commit();
    }

    public void change(View v){
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

    public void setting(View view) {
        Toast.makeText(MainActivity.this, "设置！", Toast.LENGTH_SHORT).show();
    }

}
