package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import fly.com.happyloan.R;

public class Me_ScanActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    TextView me_scan_scan;
    ImageView me_scan_image;
    ImageView me_info_scan_back;

    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__scan);
        me_scan_scan = (TextView) findViewById(R.id.me_scan_scan);
        me_scan_image = (ImageView) findViewById(R.id.me_scan_image);
        me_info_scan_back = (ImageView) findViewById(R.id.me_info_scan_back);

        me_scan_scan.setOnClickListener(this);
        me_info_scan_back.setOnClickListener(this);
        me_scan_image.setOnLongClickListener(this);
        make();
    }
    public void make(){
        String context = "二维码";
        bitmap = EncodingUtils.createQRCode(context,600,600,null);
        me_scan_image.setImageBitmap(bitmap);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Toast.makeText(Me_ScanActivity.this, "二维码信息:"+result, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_scan_scan:
                startActivityForResult(new Intent(this, CaptureActivity.class), 99);
                break;
            case R.id.me_info_scan_back:
                finish();
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos); //压缩到数组里
        byte[] bytes = bos.toByteArray();
        Calendar c = Calendar.getInstance();
        System.out.println("当前时间："+c.getTimeInMillis());
        File f = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/Download/"+c.getTimeInMillis()+".png");
        try{
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bytes);
            fos.flush();
            fos.close();
            Toast.makeText(this, "保存成功！", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "保存失败！", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
