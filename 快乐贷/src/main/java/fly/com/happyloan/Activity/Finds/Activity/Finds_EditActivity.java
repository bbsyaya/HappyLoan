package fly.com.happyloan.Activity.Finds.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UploadBatchListener;
import fly.com.happyloan.Adapter.EditAdapter;
import fly.com.happyloan.ImageLoader.ImageLoad;
import fly.com.happyloan.ImageLoader.ImageSelectActivity;
import fly.com.happyloan.Object.Happy_activity;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

public class Finds_EditActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    EditText edit_write;
    GridView edit_grid_images;
    EditAdapter adapter;
    ArrayList<Bitmap> images;

    ArrayList<String> paths;

    Happy_user user;
    Happy_activity activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds_edit);

        edit_write = (EditText) findViewById(R.id.edit_write);
        edit_grid_images = (GridView) findViewById(R.id.edit_grid_images);

        user = BmobUser.getCurrentUser(this, Happy_user.class);
        activities = new Happy_activity();

        images = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.edit_finds_activity);
        images.add(bitmap);
        adapter = new EditAdapter(this, images);
        edit_grid_images.setAdapter(adapter);
        edit_grid_images.setOnItemClickListener(this);
        edit_grid_images.setOnItemLongClickListener(this);
    }

    public void Publish(View view) {

        final String[] filePaths = new String[paths.size()];

        for (int i = 0; i < paths.size(); i++) {
            filePaths[i] = paths.get(i);
        }

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在发表......");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        BmobFile.uploadBatch(this, filePaths, new UploadBatchListener() {
            @Override
            public void onSuccess(List<BmobFile> list, List<String> list1) {
                if (list1.size() == filePaths.length) {
                    Log.i("上传成功", list1.get(0));
                    progressDialog.dismiss();
                    activities.setType(edit_write.getText().toString());
                    activities.setName(user.getUsername());
                    activities.setHeadImage(user.getHeadImage().getUrl());
                    activities.setPhotos(list);
                    activities.save(Finds_EditActivity.this);
                    Toast.makeText(Finds_EditActivity.this, "发表成功", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onProgress(int i, int i1, int i2, int i3) {
                Log.i("文件数量", "当前上传：" + i + "文件总数：" + i2);
            }

            @Override
            public void onError(int i, String s) {
                Log.i("上传失败", s);
            }
        });
    }

    public void Back(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            if (images.size() == 1) {
                Intent intent = new Intent(this, ImageSelectActivity.class);
                intent.putExtra("images", 6);
                startActivityForResult(intent, 123);
            } else {
                if (images.size()-1 < 6) {
                    Intent intent = new Intent(this, ImageSelectActivity.class);
                    intent.putExtra("images", 6 - images.size());
                    startActivityForResult(intent, 123);
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            HashSet<String> set = (HashSet<String>) bundle.get("dirPaths");
            System.out.println("图片数量" + set.size());
            paths = new ArrayList<>();
            paths.addAll(set);
            ArrayList<Bitmap> bitmap = ImageLoad.getImageLoad().fromPathGetBitmap(paths);
            images.addAll(bitmap);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
            images.remove(position);
            adapter.notifyDataSetChanged();
        }
        return false;
    }
}
