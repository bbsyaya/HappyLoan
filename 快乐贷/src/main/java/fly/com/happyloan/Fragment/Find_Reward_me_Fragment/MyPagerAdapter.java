package fly.com.happyloan.Fragment.Find_Reward_me_Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Candy-X on 2016/3/7.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments;
    String[] titles;

    public MyPagerAdapter(FragmentManager fm, ArrayList fragments, String[] titles){
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {//加载碎片的数量
        Fragment f = fragments.get(position);
        return f;
    }

    @Override
    public int getCount() {//碎片（com.kylen.classroom.Fragment）的总数
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
