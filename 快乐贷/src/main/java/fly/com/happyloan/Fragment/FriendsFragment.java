package fly.com.happyloan.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import fly.com.happyloan.Adapter.FriendsAdapter;
import fly.com.happyloan.Object.Happy_friend;
import fly.com.happyloan.Object.Happy_user;
import fly.com.happyloan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {


    ArrayList<HashMap<String,String>> lists = new ArrayList<>();
    FriendsAdapter adapter;
    Happy_friend friend;
    ListView list_friends;
    Happy_user user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        list_friends = (ListView) view.findViewById(R.id.list_friends);
        //
        user = BmobUser.getCurrentUser(getContext(),Happy_user.class);
        friend = new Happy_friend();
        BmobQuery<Happy_friend> query = new BmobQuery<>();
        query.addWhereEqualTo("meName", user.getUsername());
        lists.clear();
        query.findObjects(getContext(), new FindListener<Happy_friend>() {
            @Override
            public void onSuccess(List<Happy_friend> list) {
                Log.i("查询结果：", "查询结果：" + list.size());
                for (Happy_friend happy_friend : list) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("headimage", happy_friend.getFriendImage());
                    map.put("name", happy_friend.getName());
                    lists.add(map);
                }
                adapter = new FriendsAdapter(lists,getContext());
                list_friends.setAdapter(adapter);
            }

            @Override
            public void onError(int i, String s) {
                Log.i("失败：", "失败："+s);
            }
        });
        return view;
    }

}
