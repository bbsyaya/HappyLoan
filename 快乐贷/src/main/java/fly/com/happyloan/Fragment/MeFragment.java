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

import fly.com.happyloan.Activity.Me.Me_AboutActivity;
import fly.com.happyloan.Activity.Me.Me_BorrowComeActivity;
import fly.com.happyloan.Activity.Me.Me_BorrowOutActivity;
import fly.com.happyloan.Activity.Me.Me_MenoyActivity;
import fly.com.happyloan.Activity.Me.Me_ProfitActivity;
import fly.com.happyloan.Activity.Me.Me_SecuityActivity;
import fly.com.happyloan.Activity.Me.Me_SincereActivity;
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
            R.drawable.borrow_out,R.drawable.me_profit,
            R.drawable.me_sincere,R.drawable.me_menoy,
            R.drawable.me_secuity,R.drawable.me_about};
    String[] title = {"借入","借出","赚利差","收还款","钱包","安全","关于"};
    String[] money = {"100元","324元","25元","","充值、提现","",""};
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
            list_map.put("money",money[i]);
            list_map.put("come",greater[i]);
            list.add(list_map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "我是"+title[position], Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                startActivity(new Intent(getContext(),Me_BorrowComeActivity.class));
                break;
            case 1:
                startActivity(new Intent(getContext(),Me_BorrowOutActivity.class));
                break;
            case 2:
                startActivity(new Intent(getContext(),Me_ProfitActivity.class));
                break;
            case 3:
                startActivity(new Intent(getContext(),Me_SincereActivity.class));
                break;
            case 4:
                startActivity(new Intent(getContext(),Me_MenoyActivity.class));
                break;
            case 5:
                startActivity(new Intent(getContext(),Me_SecuityActivity.class));
                break;
            case 6:
                startActivity(new Intent(getContext(),Me_AboutActivity.class));
                break;
        }
    }

}
