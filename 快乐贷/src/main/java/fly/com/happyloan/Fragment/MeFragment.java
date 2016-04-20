package fly.com.happyloan.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import fly.com.happyloan.Activity.AboutActivity;
import fly.com.happyloan.Activity.BorrowComeActivity;
import fly.com.happyloan.Activity.BorrowOutActivity;
import fly.com.happyloan.Activity.MenoyActivity;
import fly.com.happyloan.Activity.ProfitActivity;
import fly.com.happyloan.Activity.SecuityActivity;
import fly.com.happyloan.Activity.SincereActivity;
import fly.com.happyloan.Adapter.MeFragmentAdapter;
import fly.com.happyloan.Activity.MainActivity;
import fly.com.happyloan.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements AdapterView.OnItemClickListener {


    ArrayList<HashMap<String,Object>> list = new ArrayList<>();
    MeFragmentAdapter adapter;
    ListView list_me;
    int[] icon = {R.drawable.borrow_come,
            R.drawable.borrow_out,R.drawable.profit,
            R.drawable.sincere,R.drawable.menoy,
            R.drawable.secuity,R.drawable.about};
    String[] title = {"借入","借出","赚利差","收还款","钱包","安全","关于"};
    String[] menoy = {"0元","324元","345元","453元","542元","243元","654元"};
    int[] greater = {R.drawable.greater,
            R.drawable.greater,R.drawable.greater,
            R.drawable.greater,R.drawable.greater,
            R.drawable.greater,R.drawable.greater,};

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
            list_map.put("come",greater[i]);
            list.add(list_map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "我是"+title[position], Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                startActivity(new Intent(getContext(),BorrowComeActivity.class));
                break;
            case 1:
                startActivity(new Intent(getContext(),BorrowOutActivity.class));
                break;
            case 2:
                startActivity(new Intent(getContext(),ProfitActivity.class));
                break;
            case 3:
                startActivity(new Intent(getContext(),SincereActivity.class));
                break;
            case 4:
                startActivity(new Intent(getContext(),MenoyActivity.class));
                break;
            case 5:
                startActivity(new Intent(getContext(),SecuityActivity.class));
                break;
            case 6:
                startActivity(new Intent(getContext(),AboutActivity.class));
                break;
        }
    }

}
