package fly.com.happyloan.Activity.Finds;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Finds_ContactsActivity extends Activity implements View.OnClickListener {

    TextView contacts_share;//分享
    ListView contacts_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_contacts);
        contacts_share = (TextView) findViewById(R.id.contacts_share);
        contacts_listView = (ListView) findViewById(R.id.contacts_listView);
        listener();
    }

    public void listener(){
        contacts_share.setOnClickListener(this);
    }

    public void back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(Finds_ContactsActivity.this, "分享到QQ！", Toast.LENGTH_SHORT).show();
    }
}
