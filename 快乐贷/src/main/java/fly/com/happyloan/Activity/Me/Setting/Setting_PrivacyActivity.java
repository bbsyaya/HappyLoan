package fly.com.happyloan.Activity.Me.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import fly.com.happyloan.R;

public class Setting_PrivacyActivity extends AppCompatActivity {

    Switch switch_phoneNumAddFriend;
    Switch switch_NameAddFriend;
    Switch switch_contactsFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_privacy);
        //
        switch_phoneNumAddFriend = (Switch) findViewById(R.id.switch_phoneNumAddFriend);
        switch_NameAddFriend = (Switch) findViewById(R.id.switch_NameAddFriend);
        switch_contactsFind = (Switch) findViewById(R.id.switch_contactsFind);
    }

    public void back(View view){
        finish();
    }

}
