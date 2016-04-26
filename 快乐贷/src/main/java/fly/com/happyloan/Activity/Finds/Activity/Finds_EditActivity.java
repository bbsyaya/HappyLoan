package fly.com.happyloan.Activity.Finds.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import fly.com.happyloan.R;

public class Finds_EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_edit);
    }

    public void Publish(View view){
        //发表
        //startActivity(new Intent(this, LoginActivity.class));
        Toast.makeText(this, "发表", Toast.LENGTH_SHORT).show();
    }

    public void Back(View view){
        finish();
    }
}
