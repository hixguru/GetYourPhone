package kr.hwanik.get.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import kr.hwanik.get.R;
import kr.hwanik.get.adapter.RecyclerViewAdapter;
import kr.hwanik.get.presenter.MainPresenter;
import kr.hwanik.get.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private List<String> dataSet;

    // BINDING VIEW
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.fab) FloatingActionButton fab;

    private RecyclerViewAdapter<String> adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        dataSet = new ArrayList<>();
        adapter = new RecyclerViewAdapter(dataSet);
        presenter = new MainPresenterImpl(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(v -> presenter.onClickAddButton());
    }

    @Override
    public void startAddActivity() {
        Intent intent = new Intent(this, StepActivity.class);
        startActivity(intent);
    }
}
