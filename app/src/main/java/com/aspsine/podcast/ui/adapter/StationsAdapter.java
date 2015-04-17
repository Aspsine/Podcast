package com.aspsine.podcast.ui.adapter;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Section;
import com.aspsine.podcast.model.Station;
import com.aspsine.podcast.util.DensityUtil;
import com.aspsine.podcast.util.ListUtils;
import com.aspsine.podcast.util.UIUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/4/15.
 */
public class StationsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private Section mSection;

    public interface OnItemClickListener {
        public void onItemClick(View v, int position);
    }

    public static class Type {
        public static final int TYPE_TITLE = -1;
        public static final int TYPE_STATIONS = 0;
    }

    public StationsAdapter() {
        mSection = new Section(new ArrayList<Station>(), new ArrayList<Station>());
    }

    public void setSection(Section section) {
        this.mSection.getStataions().clear();
        this.mSection.getGenres().clear();
        this.mSection.getStataions().addAll(section.getStataions());
        this.mSection.getGenres().addAll(section.getGenres());
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (!ListUtils.isEmpty(mSection.getGenres())) {
            count += mSection.getGenres().size();
        }
        if (!ListUtils.isEmpty(mSection.getStataions())) {
            count += mSection.getStataions().size();
        }
        return count;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(UIUtils.inflate(R.layout.item_station, parent), mSection);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        itemHolder.bindData(position);

    }

    public static class ItemHolder extends RecyclerView.ViewHolder {
        TextView tvStation;
        Section mmSection;
        int dp = DensityUtil.dip2px(itemView.getContext(), 8);
        int screenWidth = DensityUtil.getScreenWidth(itemView.getContext());
        public ItemHolder(View itemView, Section section) {
            super(itemView);
            GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) itemView.getLayoutParams();
            lp.height = (screenWidth - 4*dp)/3;
            lp.width = (screenWidth - 4*dp)/3;
            lp.setMargins(dp/2, dp/2, dp/2, dp/2);
            itemView.setLayoutParams(lp);

            mmSection = section;

            tvStation = (TextView) itemView.findViewById(R.id.tvStation);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "1", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bindData(int position){
            if (position < mmSection.getGenres().size()) {
                tvStation.setText(mmSection.getGenres().get(position).getName());
                tvStation.setTextColor(Color.WHITE);
                itemView.setBackgroundColor(mmSection.getGenres().get(position).getColor());
            } else {
                tvStation.setText(mmSection.getStataions().get(position - mmSection.getGenres().size()).getName());
                tvStation.setTextColor(Color.WHITE);
                itemView.setBackgroundColor(itemView.getResources().getColor(R.color.style_color_primary));
            }
        }
    }
}
