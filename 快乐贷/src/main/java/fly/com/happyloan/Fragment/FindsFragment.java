package fly.com.happyloan.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import fly.com.happyloan.Activity.Finds.Finds_ActivitysActivity;
import fly.com.happyloan.Activity.Finds.Finds_ContactsActivity;
import fly.com.happyloan.Activity.Finds.Finds_NoticeActivity;
import fly.com.happyloan.Activity.Finds.Reward.Finds_RewardActivity;
import fly.com.happyloan.Activity.Finds.Finds_SubscriptionActivity;
import fly.com.happyloan.Activity.Finds.Urges.Finds_UrgesActivity;
import fly.com.happyloan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindsFragment extends Fragment implements View.OnClickListener, View.OnTouchListener {

    LinearLayout Finds_reward;//悬赏
    LinearLayout Finds_notice;//公告
    LinearLayout Finds_subscription;//借款订阅
    LinearLayout Finds_contacts;//人脉榜
    LinearLayout Finds_activitys;//活动
    LinearLayout Finds_urges;//人人催

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finds, container, false);
        //每项的显示
        Finds_reward = (LinearLayout) view.findViewById(R.id.Finds_reward);
        Finds_notice = (LinearLayout) view.findViewById(R.id.Finds_notice);
        Finds_subscription = (LinearLayout) view.findViewById(R.id.Finds_subscription);
        Finds_contacts = (LinearLayout) view.findViewById(R.id.Finds_contacts);
        Finds_activitys = (LinearLayout) view.findViewById(R.id.Finds_activitys);
        Finds_urges = (LinearLayout) view.findViewById(R.id.Finds_urges);
        listener();
        return view;
    }

    public void listener(){
        Finds_reward.setOnClickListener(this);
        Finds_reward.setOnTouchListener(this);

        Finds_notice.setOnClickListener(this);
        Finds_notice.setOnTouchListener(this);

        Finds_subscription.setOnClickListener(this);
        Finds_subscription.setOnTouchListener(this);

        Finds_contacts.setOnClickListener(this);
        Finds_contacts.setOnTouchListener(this);

        Finds_activitys.setOnClickListener(this);
        Finds_activitys.setOnTouchListener(this);

        Finds_urges.setOnClickListener(this);
        Finds_urges.setOnTouchListener(this);
    }

    private void startActivity(View v){
        switch (v.getId()){
            case R.id.Finds_reward:
                startActivity(new Intent(getContext(),Finds_RewardActivity.class));
                break;
            case R.id.Finds_notice:
                startActivity(new Intent(getContext(),Finds_NoticeActivity.class));
                break;
            case R.id.Finds_subscription:
                startActivity(new Intent(getContext(),Finds_SubscriptionActivity.class));
                break;
            case R.id.Finds_contacts:
                startActivity(new Intent(getContext(),Finds_ContactsActivity.class));
                break;
            case R.id.Finds_activitys:
                startActivity(new Intent(getContext(),Finds_ActivitysActivity.class));
                break;
            case R.id.Finds_urges:
                startActivity(new Intent(getContext(),Finds_UrgesActivity.class));
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
                    case R.id.Finds_reward:
                        Finds_reward.setSelected(true);
                        break;
                    case R.id.Finds_notice:
                        Finds_notice.setSelected(true);
                        break;
                    case R.id.Finds_subscription:
                        Finds_subscription.setSelected(true);
                        break;
                    case R.id.Finds_contacts:
                        Finds_contacts.setSelected(true);
                        break;
                    case R.id.Finds_activitys:
                        Finds_activitys.setSelected(true);
                        break;
                    case R.id.Finds_urges:
                        Finds_urges.setSelected(true);
                        break;
                }
                break;
            //终止触摸时刻
            case MotionEvent.ACTION_UP:  // = 1
                Finds_reward.setSelected(false);
                Finds_notice.setSelected(false);
                Finds_subscription.setSelected(false);
                Finds_contacts.setSelected(false);
                Finds_activitys.setSelected(false);
                Finds_urges.setSelected(false);

                onClick(v);
                break;
        }
        return false;
    }
}
