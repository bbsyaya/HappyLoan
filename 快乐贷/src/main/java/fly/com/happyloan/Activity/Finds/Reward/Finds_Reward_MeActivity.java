package fly.com.happyloan.Activity.Finds.Reward;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fly.com.happyloan.Fragment.Find_Reward_me_Fragment.Find_Reward_me_RecruitedFragment;
import fly.com.happyloan.Fragment.Find_Reward_me_Fragment.Find_Reward_me_RewardFragment;
import fly.com.happyloan.Fragment.Find_Reward_me_Fragment.MyPagerAdapter;
import fly.com.happyloan.R;

public class Finds_Reward_MeActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    ImageView finds_reward_me_message;
    TextView finds_reward_me_meReward;//我的悬赏
    TextView finds_reward_me_meRecruited;//我的揭榜
    //
    MyPagerAdapter adapter = null;
    ArrayList<Fragment> fragments = new ArrayList<>();
    ViewPager finds_reward_me_ViewPager = null;
    Find_Reward_me_RewardFragment find_Reward_me_RewardFragment = null;
    Find_Reward_me_RecruitedFragment find_Reward_me_RecruitedFragment =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_reward_me);
        finds_reward_me_message = (ImageView) findViewById(R.id.finds_reward_me_message);
        finds_reward_me_meReward = (TextView) findViewById(R.id.finds_reward_me_meReward);
        finds_reward_me_meRecruited = (TextView) findViewById(R.id.finds_reward_me_meRecruited);
        finds_reward_me_ViewPager = (ViewPager) findViewById(R.id.finds_reward_me_ViewPager);
        listener();
        find_Reward_me_RewardFragment = new Find_Reward_me_RewardFragment();
        find_Reward_me_RecruitedFragment = new Find_Reward_me_RecruitedFragment();
        fragments.add(find_Reward_me_RewardFragment);
        fragments.add(find_Reward_me_RecruitedFragment);
        //
        finds_reward_me_meReward.setTextColor(Color.parseColor("#00bb9c"));
        finds_reward_me_meRecruited.setTextColor(Color.parseColor("#000000"));
        //
        adapter = new MyPagerAdapter(getSupportFragmentManager(),fragments,null);
        finds_reward_me_ViewPager.setAdapter(adapter);
        finds_reward_me_ViewPager.setOnPageChangeListener(this);
    }

    public void listener(){
        finds_reward_me_message.setOnClickListener(this);
    }

    public void back(View view){
        finish();
    }

    public void change(View view){
        if(view.getId() == R.id.finds_reward_me_meReward){
            finds_reward_me_ViewPager.setCurrentItem(0);//当前显示的页面
        }else {
            finds_reward_me_ViewPager.setCurrentItem(1);
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(Finds_Reward_MeActivity.this, "消息！", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,Finds_Reward_Me_MessagesActivity.class));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position==0){
            finds_reward_me_meReward.setTextColor(Color.parseColor("#00bb9c"));
            finds_reward_me_meRecruited.setTextColor(Color.parseColor("#000000"));
        }else {
            finds_reward_me_meReward.setTextColor(Color.parseColor("#000000"));
            finds_reward_me_meRecruited.setTextColor(Color.parseColor("#00bb9c"));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
