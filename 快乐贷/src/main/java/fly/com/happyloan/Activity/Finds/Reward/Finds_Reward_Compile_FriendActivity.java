package fly.com.happyloan.Activity.Finds.Reward;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fly.com.happyloan.R;

public class Finds_Reward_Compile_FriendActivity extends AppCompatActivity {

    EditText search_linkman;//搜索联系人

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_reward_compile_friend);
        search_linkman = (EditText) findViewById(R.id.search_linkman);
    }

    public void back(View view){
        finish();
    }

}
