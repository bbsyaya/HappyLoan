package fly.com.happyloan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.Activity.Loan.Loan_BorrowMoneyActivity;
import fly.com.happyloan.Activity.Loan.Loan_KnockdownActivity;
import fly.com.happyloan.Activity.Loan.Loan_ListViewActivity;
import fly.com.happyloan.R;
import fly.com.happyloan.View.AdvInfo;
import fly.com.happyloan.View.ViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoanFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView loan_knockdown;
    TextView loan_borrowMoney;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    /**
     * handler处理定时任务
     */
    private Handler mMyHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            mMyHandler.sendEmptyMessageDelayed(0, 3000);
        }
    };
    private ArrayList<AdvInfo> list = new ArrayList<AdvInfo>();

    SimpleAdapter adapter = null;
    ListView list_loan;
    ArrayList<HashMap<String, Object>> datas = new ArrayList<>();
    private String name[] = {"1","2","3"};
    private String percent[] = {"1%","2%","3%"};
    private String time[] = {"1天","2天","3天"};
    private String money[] = {"1万","2万","3万"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loan, container, false);
        list_loan = (ListView) view.findViewById(R.id.list_loan);
        loan_knockdown = (TextView) view.findViewById(R.id.loan_knockdown);
        loan_borrowMoney = (TextView) view.findViewById(R.id.loan_borrowMoney);
        mViewPager = (ViewPager) view.findViewById(R.id.loan_viewPager);
        initData();
        listener();
        initDatas();
        return view;
    }

    private void initData() {
        list.add(new AdvInfo(R.drawable.finds_activitys));
        list.add(new AdvInfo(R.drawable.find_blue));
        list.add(new AdvInfo(R.drawable.finds_reward));
        list.add(new AdvInfo(R.drawable.finds_reward_me_message));
        list.add(new AdvInfo(R.drawable.me_profit));

        mViewPagerAdapter = new ViewPagerAdapter(list,getContext());
        mViewPager.setAdapter(mViewPagerAdapter);

        //默认在1亿多
        mViewPager.setCurrentItem(Integer.MAX_VALUE / 2 - ((Integer.MAX_VALUE / 2) % list.size()));
        //3秒定时
        mMyHandler.sendEmptyMessageDelayed(0, 3000);
    }

    public void listener(){
        loan_knockdown.setOnClickListener(this);
        loan_borrowMoney.setOnClickListener(this);
        list_loan.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loan_knockdown:
                Toast.makeText(getContext(), "成交", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), Loan_KnockdownActivity.class));
                break;
            case R.id.loan_borrowMoney:
                Toast.makeText(getContext(), "借钱", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),Loan_BorrowMoneyActivity.class));
                break;
        }
    }

    public void initDatas(){
        datas.clear();
        String from[] = {"name","percent","time","money"};
        int to[] = {R.id.loan_name,R.id.loan_percent,R.id.loan_time,R.id.loan_money};
        for (int i=0;i<name.length;i++){
            HashMap<String,Object> map = new HashMap();
            map.put("name",name[i]);
            map.put("percent",percent[i]);
            map.put("time",time[i]);
            map.put("money",money[i]);
            datas.add(map);
        }
        adapter = new SimpleAdapter(getContext(),datas,R.layout.loan_list,from,to);
        list_loan.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(getContext(),Loan_ListViewActivity.class));
    }
}
