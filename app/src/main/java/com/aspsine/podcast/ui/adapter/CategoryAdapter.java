package com.aspsine.podcast.ui.adapter;

import android.graphics.Color;
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
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private Section mSection;

    public interface OnItemClickListener {
        public void onItemClick(View v, int position);
    }

    public static class Type {
        public static final int TYPE_GENRES = -2;
        public static final int TYPE_SUB_TITLE = -1;
        public static final int TYPE_CATAGORY = 0;
    }

    public CategoryAdapter() {
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
        List<Station> genres = mSection.getGenres();

        int genresSize = genres.size();
        int genresColumnNum = genresSize / 2 + genresSize % 2;

        if (position < genresColumnNum) {
            return Type.TYPE_GENRES;
        } else if (position == genresColumnNum) {
            return Type.TYPE_SUB_TITLE;
        } else {
            return Type.TYPE_CATAGORY;
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;

        List<Station> genres = mSection.getGenres();

        //genres
        if (!ListUtils.isEmpty(genres)) {
            count += getGenresColumnNum();
        }

        if (!ListUtils.isEmpty(mSection.getStataions())) {
            //sub title;
            count++;
            //categories
            count += mSection.getStataions().size();
        }
        return count;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Type.TYPE_GENRES:
                return new GenerationHolder(UIUtils.inflate(R.layout.item_category_generation, parent));
            case Type.TYPE_SUB_TITLE:
                return new SubTitleHolder(UIUtils.inflate(R.layout.item_category_sub, parent));
            case Type.TYPE_CATAGORY:
                return new CategoryHolder(UIUtils.inflate(R.layout.item_category, parent));
            default:
                throw new IllegalArgumentException("Wrong type");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case Type.TYPE_GENRES:
                bindGenresView((GenerationHolder) holder, position);
                break;
            case Type.TYPE_SUB_TITLE:
                bindSubTitleView((SubTitleHolder) holder, position);
                break;
            case Type.TYPE_CATAGORY:
                bindCategoryView((CategoryHolder) holder, position);
                break;
            default:
                throw new IllegalArgumentException("onBindViewHolder:Wrong type");
        }
    }

    void bindGenresView(GenerationHolder holder, int position) {
        List<Station> genres = mSection.getGenres();
        int percentNum = genres.size() % 2;
        int columnNum = genres.size() / 2 + percentNum;

        try {
            if (columnNum - 1 == position && percentNum == 1) {
                holder.setVisibility(View.VISIBLE, View.GONE);
                holder.tvOne.setText(genres.get(position * 2).getName());
            } else {
                holder.setVisibility(View.VISIBLE, View.VISIBLE);
                holder.tvOne.setText(genres.get(position * 2).getName());
                holder.tvTwo.setText(genres.get(position * 2 + 1).getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void bindSubTitleView(SubTitleHolder holder, int position) {
        holder.tvSubTitle.setText("Category");
    }

    void bindCategoryView(CategoryHolder holder, int position) {
        position = position - (getGenresColumnNum() + 1);
        holder.tvStation.setText(mSection.getStataions().get(position).getName());
    }

    private int getGenresColumnNum() {
        int size = mSection.getGenres().size();
        return size / 2 + size % 2;
    }

    public static class GenerationHolder extends RecyclerView.ViewHolder {
        TextView tvOne;
        TextView tvTwo;

        int dp = DensityUtil.dip2px(itemView.getContext(), 8);
        int screenWidth = DensityUtil.getScreenWidth(itemView.getContext());

        public GenerationHolder(View itemView) {
            super(itemView);
            tvOne = (TextView) itemView.findViewById(R.id.tvOne);
            tvTwo = (TextView) itemView.findViewById(R.id.tvTwo);

            RecyclerView.LayoutParams lpItem = (RecyclerView.LayoutParams) itemView.getLayoutParams();
            lpItem.height = (screenWidth - dp) / 8;
            lpItem.width = (screenWidth - dp);
            lpItem.setMargins(dp / 2, dp / 2, dp / 2, dp / 2);
            itemView.setLayoutParams(lpItem);

            LinearLayout.LayoutParams lpTvOne = new LinearLayout.LayoutParams(lpItem.width/2 - dp, lpItem.height);
            lpTvOne.setMargins(0, 0, dp / 2, 0);
            tvOne.setLayoutParams(lpTvOne);

            LinearLayout.LayoutParams lpTvTwo = new LinearLayout.LayoutParams(lpItem.width/2 - dp, lpItem.height);
            lpTvTwo.setMargins(dp / 2, 0, 0, 0);
            tvTwo.setLayoutParams(lpTvTwo);
        }

        public void setVisibility(int visibilityOne, int visibilityTwo) {
            tvOne.setVisibility(visibilityOne);
            tvTwo.setVisibility(visibilityTwo);
        }
    }

    public static class SubTitleHolder extends RecyclerView.ViewHolder {
        TextView tvSubTitle;

        public SubTitleHolder(View itemView) {
            super(itemView);
            tvSubTitle = (TextView) itemView.findViewById(R.id.tvSubTitle);
        }
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder {
        TextView tvStation;

        int dp = DensityUtil.dip2px(itemView.getContext(), 8);
        int screenWidth = DensityUtil.getScreenWidth(itemView.getContext());

        public CategoryHolder(View itemView) {
            super(itemView);
            tvStation = (TextView) itemView.findViewById(R.id.tvStation);

            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) itemView.getLayoutParams();
            lp.height = (screenWidth - dp) / 8;
            lp.width = (screenWidth - dp);
            lp.setMargins(dp / 2, dp / 2, dp / 2, dp / 2);
            itemView.setLayoutParams(lp);
        }
    }


}
