package kr.hwanik.get.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import kr.hwanik.get.R;
import kr.hwanik.get.adapter.model.BaseAdapterModel;
import kr.hwanik.get.adapter.view.BaseAdapterView;

/**
 * Created by hwanik on 2017. 2. 22..
 */

public class RecyclerViewAdapter<T extends String> extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
    implements BaseAdapterModel<T>, BaseAdapterView {

    private List<T> dataSet;

    public RecyclerViewAdapter(List<T> dataSet) {
        this.dataSet = dataSet;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_get_title) TextView tvTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.get_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public void add(T item) {
        dataSet.add(item);
    }

    @Override
    public void refresh() {
        notifyDataSetChanged();
    }
}
