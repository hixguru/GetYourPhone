package kr.hwanik.get.presenter;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import kr.hwanik.get.adapter.ViewPagerAdapter;
import kr.hwanik.get.view.StepFragment;

/**
 * Created by hwanik on 2017. 2. 27..
 */

public class StepPresenterImpl implements StepPresenter {

    private StepPresenter.View view;
    private ViewPagerAdapter<Fragment> adapter;

    public StepPresenterImpl(StepPresenter.View view, ViewPagerAdapter<Fragment> adapter) {
        this.view = view;
        this.adapter = adapter;
    }

    @Override
    public void attachView(Fragment f) {
        adapter.add(f);
        view.refresh();
    }

    @Override
    public void addStep(int currentItem) {
        StepFragment currentStep = (StepFragment) adapter.getItem(currentItem);
        int maxLength = adapter.getCount() - 1;

        if (currentItem == maxLength && TextUtils.isEmpty(currentStep.etMessage.getText().toString())) {
            view.showToastEmptyMessage();
        } else if (currentItem < maxLength) {
            view.setViewPagerPosition(currentItem + 1);
        } else {
            attachView(new StepFragment());
            view.setViewPagerPosition(currentItem + 1);
        }
    }
}
