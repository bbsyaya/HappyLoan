package fly.com.happyloan.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import fly.com.happyloan.Activity.MainActivity;
import fly.com.happyloan.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void VerificationCode(View view){
        Toast.makeText(this, "验证码", Toast.LENGTH_SHORT).show();
    }

    public void Register(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void Back(View v){
        finish();
    }
}
