package fly.com.happyloan.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.Activity.MainActivity;
import fly.com.happyloan.Adapter.FindsFragmentAdapter;
import fly.com.happyloan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindsFragment extends Fragment implements AdapterView.OnItemClickListener{


    ArrayList<HashMap<String,Object>> list = new ArrayList<>();
    FindsFragmentAdapter adapter;

    ListView list_finds;
    private int[] imageIds = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,};
    private String[] names = new  String[]{"悬赏","公告","借款订阅","人脉榜","投资有道","活动","人人催"};
    private String[] sign = new String[]{">",">",">",">",">",">",">"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finds, container, false);
        init();
        list_finds = (ListView) view.findViewById(R.id.list_finds);
        MainActivity mainActivity = (MainActivity) getActivity();
        adapter = new FindsFragmentAdapter(list,mainActivity);
        list_finds.setAdapter(adapter);
        list_finds.setOnItemClickListener(this);
        return view;
    }

    private void init(){
        list.clear();
        for (int i = 0 ; i <imageIds.length ; i++){
            HashMap<String,Object> list_finds = new HashMap<>();
            list_finds.put("icon",imageIds[i]);
            list_finds.put("name",names[i]);
            list_finds.put("desc",sign[i]);
            list.add(list_finds);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
