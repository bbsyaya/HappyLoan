package fly.com.happyloan.Activity.Login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import fly.com.happyloan.Activity.MainActivity;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * 通过手机号码/密码提供登录的登录界面。
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {

    /**
     * 身份认同READ_CONTACTS权限请求。
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * 一个包含已知用户名和密码的虚拟身份验证存储。
     * TODO: 删除后连接到一个真正的身份验证系统。
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "15274964531:123456", "12345678910:666666"
    };
    /**
     * 跟踪登录的任务，以确保如果请求的话，我们可以取消它。
     */
    //private UserLoginTask mAuthTask = null;

    // 用户界面参考。
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView forget_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Happy_user user = BmobUser.getCurrentUser(this,Happy_user.class);
        if (user != null){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }

        // 设置登录表单。
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        //忘记密码
        forget_password = (TextView) findViewById(R.id.forget_password);
    }

    public void Publish(View view){
        startActivity(new Intent(this,RegisterActivity.class));
    }

    private void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }

        getLoaderManager().initLoader(0, null, this);
    }

    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            Snackbar.make(mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
                        }
                    });
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }

    /**
     * 当已完成权限请求时收到的回调。
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateAutoComplete();
            }
        }
    }


    /**
     * 尝试登录或注册登录表单所指定的帐户。
     * 如果有形式错误（无效的手机号，缺少的字段等），该错误被提出并没有实际的登录尝试。
     */
    private void attemptLogin() {

//        if (mAuthTask != null) {
//            return;
//        }

        // 复位误差。
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // 在登录尝试时存储值。
        String phone = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // 检查一个有效的密码，如果用户输入了一个。
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // 检查有效的手机号码。
        if (TextUtils.isEmpty(phone)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(phone)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // 有一个错误，不要尝试登录，并将第一个焦点集中在一个错误的领域中。
            focusView.requestFocus();
        } else {
            // 显示进度微调，并启动一个后台任务执行用户登录尝试。

            Happy_user user = new Happy_user();
            user.setUsername(phone);
            user.setPassword(password);
            user.login(this, new SaveListener() {
                @Override
                public void onSuccess() {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }

                @Override
                public void onFailure(int i, String s) {
                    mPasswordView.setError(getString(R.string.error_incorrect_password));
                    mPasswordView.requestFocus();
                }
            });

            //showProgress(true);
            //mAuthTask = new UserLoginTask(phone, password);
            //mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String phone) {
        //判断用户名
        if (phone.length() == 11){
            return true;
        }else {
            return false;
        }
    }

    private boolean isPasswordValid(String password) {
        //判断密码
        return password.length() >= 6;
    }

    /**
     * 显示进程的用户界面并隐藏登录表单。
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // 在 Honeycomb MR2 我们有ViewPropertyAnimator APIs,
        // 可以很容易的动画. 如果可用, 使用这些 APIs 淡入 progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // ViewPropertyAnimator API是不可用的，所以简单的显示和隐藏相关的UI组件。
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                //检索设备用户的“配置文件”联系人的数据行。
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // 选择电子邮件地址。
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // 显示主电子邮件地址。请注意，如果用户没有指定一个主电子邮件地址，
                // 那将不会有一个主电子邮件地址。
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> phones = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            phones.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(phones);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }


    private void addEmailsToAutoComplete(List<String> phoneAddressCollection) {
        //创建适配器告诉自动完成文本视图如何在其下拉列表中显示。
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, phoneAddressCollection);

        mEmailView.setAdapter(adapter);
    }

    /**
     * 表示用于验证用户身份的异步登录/注册任务。
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mPhone;
        private final String mPassword;

        UserLoginTask(String phone, String password) {
            mPhone = phone;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: 尝试对网络服务的身份验证。

            try {
                // 模拟网络接入。
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mPhone)) {
                    // 账户存在,返回true,如果密码匹配
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: 注册新帐户
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
           // mAuthTask = null;
            showProgress(false);

            if (success) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                //finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            //mAuthTask = null;
            showProgress(false);
        }
    }
}

