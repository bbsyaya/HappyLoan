package fly.com.happyloan.Activity.Finds.Reward;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Finds_Reward_CompileActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_reward_content;//悬赏内容
    ImageView add_images;//添加照片
    EditText edt_reward_num;//赏金个数
    EditText edt_reward_countMoney;//总金额
    LinearLayout finds_reward_compile_friend;//指定好友
    TextView tv_countMoney;//金额

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_reward_compile);
        edt_reward_content = (EditText) findViewById(R.id.edt_reward_content);
        add_images = (ImageView) findViewById(R.id.add_images);
        edt_reward_num = (EditText) findViewById(R.id.edt_reward_num);
        edt_reward_countMoney = (EditText) findViewById(R.id.edt_reward_countMoney);
        finds_reward_compile_friend = (LinearLayout) findViewById(R.id.finds_reward_compile_friend);
        tv_countMoney = (TextView) findViewById(R.id.tv_countMoney);
        listener();
    }

    public void listener(){
        finds_reward_compile_friend.setOnClickListener(this);
    }

    public void releaseReward(View view){
        //发布悬赏
        Toast.makeText(Finds_Reward_CompileActivity.this, "发布悬赏！", Toast.LENGTH_SHORT).show();
    }

    public void back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(Finds_Reward_CompileActivity.this, "指定好友！", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,Finds_Reward_Compile_FriendActivity.class));
    }
}
