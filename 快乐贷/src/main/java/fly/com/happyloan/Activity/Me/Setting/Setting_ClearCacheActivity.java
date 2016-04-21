package fly.com.happyloan.Activity.Me.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Setting_ClearCacheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_clear_cache);
    }

    public void clearCache(View view){
        //清理缓存
        Toast.makeText(Setting_ClearCacheActivity.this, "清理缓存!", Toast.LENGTH_SHORT).show();
    }

    public void back(View view){
        finish();
    }

}
