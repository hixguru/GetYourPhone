package kr.hwanik.get.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kr.hwanik.get.adapter.model.BaseAdapterModel;
import kr.hwanik.get.adapter.view.BaseAdapterView;

/**
 * Created by hwanik on 2017. 2. 23..
 */

public class ViewPagerAdapter<T extends Fragment> extends FragmentStatePagerAdapter
    implements BaseAdapterModel<T>, BaseAdapterView {
    private List<T> items;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public void add(T item) {
        items.add(item);
    }

    @Override
    public void refresh() {
        notifyDataSetChanged();
    }
}
