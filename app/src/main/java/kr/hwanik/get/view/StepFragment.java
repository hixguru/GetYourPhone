package kr.hwanik.get.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import kr.hwanik.get.R;

public class StepFragment extends Fragment {

    @BindView(R.id.iv_background) public ImageView ivBackground;
    @BindView(R.id.et_message) public EditText etMessage;

    public StepFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step, container, false);
        ButterKnife.bind(this, view);

        Glide.with(this)
            .load(R.drawable.bg1)
            .override(600, 300)
            .into(ivBackground);

        return view;
    }
}
