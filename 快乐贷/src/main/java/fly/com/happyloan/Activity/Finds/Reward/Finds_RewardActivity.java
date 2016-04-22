package fly.com.happyloan.Activity.Finds.Reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Finds_RewardActivity extends Activity implements View.OnClickListener {

    ImageView finds_reward_me;
    ImageView finds_reward_compile;
    ListView finds_reward_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_reward);
        finds_reward_me = (ImageView) findViewById(R.id.finds_reward_me);
        finds_reward_compile = (ImageView) findViewById(R.id.finds_reward_compile);
        finds_reward_listView = (ListView) findViewById(R.id.finds_reward_listView);
        listener();
    }

    public void back(View view){
        finish();
    }

    public void listener(){
        finds_reward_me.setOnClickListener(this);
        finds_reward_compile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finds_reward_me:
                Toast.makeText(Finds_RewardActivity.this, "我的！", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Finds_Reward_MeActivity.class));
                break;
            case R.id.finds_reward_compile:
                Toast.makeText(Finds_RewardActivity.this, "编辑！", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Finds_Reward_CompileActivity.class));
                break;
        }
    }
}
