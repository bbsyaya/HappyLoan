package fly.com.happyloan.Activity.Finds.Reward;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Finds_Reward_Me_MessagesActivity extends AppCompatActivity implements View.OnClickListener {

    TextView finds_reward_me_messages;//清空
    ListView finds_reward_me_messages_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_reward_me_messages);
        finds_reward_me_messages = (TextView) findViewById(R.id.finds_reward_me_messages);
        finds_reward_me_messages_listView = (ListView) findViewById(R.id.finds_reward_me_messages_listView);
        listener();
    }

    public void listener(){
        finds_reward_me_messages.setOnClickListener(this);
    }

    public void back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(Finds_Reward_Me_MessagesActivity.this, "消息清空！", Toast.LENGTH_SHORT).show();
    }
}
