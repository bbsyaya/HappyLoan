package fly.com.happyloan.Fragment.Find_Reward_me_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import fly.com.happyloan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Find_Reward_me_RecruitedFragment extends Fragment {

    ListView Find_reward_me_recruited_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_reward_me_recruited, container, false);
        Find_reward_me_recruited_list= (ListView) view.findViewById(R.id.Find_reward_me_recruited_list);
        return view;
    }


}
