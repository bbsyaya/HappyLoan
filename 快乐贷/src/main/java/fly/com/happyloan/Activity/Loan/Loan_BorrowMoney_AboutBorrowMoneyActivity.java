package fly.com.happyloan.Activity.Loan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.R;

public class Loan_BorrowMoney_AboutBorrowMoneyActivity extends AppCompatActivity {

    ListView About_listView;
    String[] title = {"借钱如何方便快捷","年利率如何设置","利息如何计算","借款如何取出"};
    String[] content = {
            "您可以自由设置借钱金额，年利率以及还款日期，一键发布到平台好友圈；好友觉得您信用号又有利息可赚，就会马上借款给您，而且好友的借出是匿名的，见面不会尴尬。",
            "合适年利率会让借款来的更快更容易，急需借款或短期转账，可以使用高利率；其他可以使用一般利率。",
            "计息期是从借款到账后的次日至还款日，如果有多个朋友借钱给您，每个朋友的利息单独计算。",
            "朋友借款成功后，资金直接划入到您的钱包，您可立即从钱包体现到已绑定到银行卡。"};
    ArrayList<HashMap<String,Object>> list = new ArrayList<>();
    SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_borrow_money_about_borrow_money);
        About_listView = (ListView) findViewById(R.id.About_listView);
        initData();
    }

    public void initData(){
        String from[] = {"title","content"};
        int to[] = {R.id.title,R.id.content};
        for (int i=0;i<title.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("title",title[i]);
            map.put("content",content[i]);
            list.add(map);
        }
        adapter = new SimpleAdapter(this,list,R.layout.loan_borrowmoney_aboutborrowmoney_list,from,to);
        About_listView.setAdapter(adapter);
        About_listView.setEnabled(false);
    }

    public void back(View view){
        finish();
    }

}
