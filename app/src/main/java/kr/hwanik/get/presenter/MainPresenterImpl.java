package kr.hwanik.get.presenter;

/**
 * Created by hwanik on 2017. 2. 22..
 */

public class MainPresenterImpl implements MainPresenter {
    private MainPresenter.View view;

    public MainPresenterImpl(View view) {
        this.view = view;
    }

    @Override
    public void onClickAddButton() {
        view.startAddActivity();
    }
}
