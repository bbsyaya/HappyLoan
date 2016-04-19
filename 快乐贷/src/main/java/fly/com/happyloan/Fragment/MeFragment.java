package fly.com.happyloan.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.Adapter.MeFragmentAdapter;
import fly.com.happyloan.MainActivity;
import fly.com.happyloan.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements AdapterView.OnItemClickListener {


    ArrayList<HashMap<String,Object>> list = new ArrayList<>();
    MeFragmentAdapter adapter;
    ListView list_me;
    int[] icon = {R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,};
    String[] title = {"借入","借出","赚利差","收还款","钱包","安全","关于"};
    String[] menoy = {"0元","324元","345元","453元","542元","243元","654元"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        init();
        list_me = (ListView) view.findViewById(R.id.list_me);
        MainActivity mainActivity = (MainActivity) getActivity();
        adapter = new MeFragmentAdapter(list,mainActivity);
        list_me.setAdapter(adapter);
        list_me.setOnItemClickListener(this);
        return view;
    }

    private void init(){
        list.clear();
        for (int i = 0 ; i <icon.length ; i++){
            HashMap<String,Object> list_map = new HashMap<>();
            list_map.put("icon",icon[i]);
            list_map.put("borrow",title[i]);
            list_map.put("menoy",menoy[i]);
            list_map.put("come",icon[i]);
            list.add(list_map);
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
