package fly.com.happyloan.Activity.Me.Sincere;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import fly.com.happyloan.R;

public class Me_SincereActivity extends Activity {

    ListView me_sincere_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_sincere);
        me_sincere_list = (ListView) findViewById(R.id.me_sincere_list);
    }

    public void back(View view){
        finish();
    }
}
