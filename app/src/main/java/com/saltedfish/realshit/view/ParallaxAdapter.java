package com.saltedfish.realshit.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.saltedfish.realshit.R;
import com.saltedfish.realshit.data.BenefitInfo;

import io.reactivex.functions.Consumer;

/**
 * Created by SaltedFish on 2018/1/14.
 * 适配器
 */

public class ParallaxAdapter extends BaseAdapter implements Consumer<BenefitInfo> {
    private int firstVisibleItem;
    private BenefitInfo mBenefitInfo;

    @Override
    public void accept(BenefitInfo benefitInfo) throws Exception {
        mBenefitInfo = benefitInfo;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mBenefitInfo == null || mBenefitInfo.getResults() == null ? 0 : mBenefitInfo.getResults().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ParallaxViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ParallaxViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_benefit, viewGroup, false);
            viewHolder.ivMask = (ImageView) view.findViewById(R.id.iv_mask);
            viewHolder.ivContent = (ImageView) view.findViewById(R.id.iv_content);
            viewHolder.parallaxItem = (ParallaxItem) view.findViewById(R.id.item);
            viewHolder.tvContent = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(viewHolder);
        }
        viewHolder = (ParallaxViewHolder) view.getTag();
        Glide.with(viewGroup).load(mBenefitInfo.getResults().get(position).getUrl()).into(viewHolder.ivContent);
        viewHolder.parallaxItem.parallax(firstVisibleItem >= position ? 1f : 0);
        return view;
    }

    public void setFirstVisibleItem(int firstVisibleItem) {
        this.firstVisibleItem = firstVisibleItem;
    }

    static class ParallaxViewHolder {
        ImageView ivMask;
        TextView tvContent;
        ImageView ivContent;
        ParallaxItem parallaxItem;
    }
}
