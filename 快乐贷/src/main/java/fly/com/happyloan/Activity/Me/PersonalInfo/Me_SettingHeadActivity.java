package fly.com.happyloan.Activity.Me.PersonalInfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import fly.com.happyloan.ImageLoader.ImageLoad;
import fly.com.happyloan.ImageLoader.ImageSelectActivity;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

public class Me_SettingHeadActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView me_setting_head_listView;
    SimpleAdapter simpleAdapter;
    ImageView me_setting_head_image;
    List<HashMap<String, String>> datas = new ArrayList<>();
    private String[] title = {"从相册选一张", "拍一张照片"};

    Happy_user user;
    BmobFile bmobFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_setting_head);
        me_setting_head_listView = (ListView) findViewById(R.id.me_setting_head_listView);
        initData();

        String[] from = {"title"};
        int[] to = {R.id.tv_title};
        simpleAdapter = new SimpleAdapter(this, datas, R.layout.me_setting_problem_list, from, to);
        me_setting_head_listView.setAdapter(simpleAdapter);
        me_setting_head_listView.setOnItemClickListener(this);

        me_setting_head_image = (ImageView) findViewById(R.id.me_setting_head_image);
        user = BmobUser.getCurrentUser(this, Happy_user.class);
        ImageLoader.getInstance().displayImage(user.getHeadImage().getUrl(), me_setting_head_image);

    }

    public void initData() {

        datas.clear();
        for (int i = 0; i < title.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("title", title[i]);
            datas.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, title[position], Toast.LENGTH_SHORT).show();
        if (position == 0) {
            Intent intent = new Intent(this, ImageSelectActivity.class);
            intent.putExtra("images", 1);
            startActivityForResult(intent, 999);
        } else if (position == 1) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //拍照
            startActivityForResult(intent, 9527);
        }
    }

    public void Back(View view) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 999) {
                Bundle bundle = data.getExtras();
                HashSet<String> set = (HashSet<String>) bundle.get("dirPaths");
                System.out.println("图片数量" + set.size());
                ArrayList<String> paths = new ArrayList<>();
                paths.addAll(set);
                ArrayList<Bitmap> bitmap = ImageLoad.getImageLoad().fromPathGetBitmap(paths);
                me_setting_head_image.setImageBitmap(bitmap.get(0));
                bmobFile = new BmobFile(new File(paths.get(0)));
                final ProgressDialog progressDialog = new ProgressDialog(Me_SettingHeadActivity.this);
                progressDialog.setMessage("正在上传......");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                bmobFile.uploadblock(this, new UploadFileListener() {
                    @Override
                    public void onSuccess() {
                        Log.i("文件上传成功", bmobFile.getFileUrl(Me_SettingHeadActivity.this));
                        progressDialog.dismiss();
                        user.setHeadImage(bmobFile);
                        user.update(Me_SettingHeadActivity.this, user.getObjectId(), new UpdateListener() {
                            @Override
                            public void onSuccess() {
                                Log.i("更新成功", "");
                            }

                            @Override
                            public void onFailure(int i, String s) {
                                Log.i("更新失败", s);
                            }
                        });
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Log.i("文件上传失败", s);
                    }
                });
            } else if (requestCode == 9527) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                me_setting_head_image.setImageBitmap(bitmap);
            }
        }
    }
}
