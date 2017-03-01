package kr.hwanik.get.presenter;

/**
 * Created by hwanik on 2017. 2. 22..
 */

public interface MainPresenter {
    void onClickAddButton();

    interface View {
        void startAddActivity();
    }
}
