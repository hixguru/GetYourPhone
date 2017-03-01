package kr.hwanik.get.presenter;

import android.support.v4.app.Fragment;

/**
 * Created by hwanik on 2017. 2. 27..
 */

public interface StepPresenter {

    void attachView(Fragment f);

    void addStep(int currentItem);

    interface View {

        void setViewPagerPosition(int position);

        void showToastEmptyMessage();

        void refresh();
    }
}
