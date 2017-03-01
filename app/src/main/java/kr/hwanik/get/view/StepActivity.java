package kr.hwanik.get.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.hwanik.get.R;
import kr.hwanik.get.adapter.ViewPagerAdapter;
import kr.hwanik.get.presenter.StepPresenter;
import kr.hwanik.get.presenter.StepPresenterImpl;

public class StepActivity extends AppCompatActivity implements StepPresenter.View {

    @BindView(R.id.view_pager) ViewPager viewPager;

    private ViewPagerAdapter<Fragment> adapter;
    private StepPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        ButterKnife.bind(this);

        adapter = new ViewPagerAdapter<>(getSupportFragmentManager());
        presenter = new StepPresenterImpl(this, adapter);
        viewPager.setAdapter(adapter);

        presenter.attachView(new StepFragment());
    }

    @OnClick(R.id.btn_next)
    public void addStep() {
        presenter.addStep(viewPager.getCurrentItem());
    }

    @Override
    public void setViewPagerPosition(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void showToastEmptyMessage() {
        Toast.makeText(this, "전할 메시지를 입력해주세요.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refresh() {
        adapter.refresh();
    }
}
