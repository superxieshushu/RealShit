package com.saltedfish.realshit.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saltedfish.realshit.R;
import com.saltedfish.realshit.data.TodayInfo;

import io.reactivex.functions.Consumer;

/**
 * Created by SaltedFish on 2018/11/15.
 * 主界面适配器
 */
public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.MainViewHolder>
        implements Consumer<TodayInfo> {
    private Context mContext;
    private TodayInfo mTodayInfo;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.tvCategory.setText(mTodayInfo.getCategory().get(position));
        switch (mTodayInfo.getCategory().get(position)) {
            case "App":
                DetailAdapter appAdapter = new DetailAdapter(Category.APP);
                appAdapter.setAppList(mTodayInfo.getResults().getApp());
                holder.rvDetail.setAdapter(appAdapter);
                break;
            case "拓展资源":
                DetailAdapter extendAdapter = new DetailAdapter(Category.EXTEND);
                extendAdapter.setExtendList(mTodayInfo.getResults().getExtend());
                holder.rvDetail.setAdapter(extendAdapter);
                break;
            case "前端":
                DetailAdapter webAdapter = new DetailAdapter(Category.WEB);
                webAdapter.setWebList(mTodayInfo.getResults().getWeb());
                holder.rvDetail.setAdapter(webAdapter);
                break;
            case "iOS":
                DetailAdapter iOSAdapter = new DetailAdapter(Category.IOS);
                iOSAdapter.setIOSList(mTodayInfo.getResults().getIOS());
                holder.rvDetail.setAdapter(iOSAdapter);
                break;
            case "福利":
                DetailAdapter benefitAdapter = new DetailAdapter(Category.BENEFIT);
                benefitAdapter.setBenefitList(mTodayInfo.getResults().getBenefit());
                holder.rvDetail.setAdapter(benefitAdapter);
                break;
            case "休息视频":
                DetailAdapter videoAdapter = new DetailAdapter(Category.VIDEO);
                videoAdapter.setVideoList(mTodayInfo.getResults().getVideo());
                holder.rvDetail.setAdapter(videoAdapter);
                break;
            case "Android":
                DetailAdapter androidAdapter = new DetailAdapter(Category.ANDROID);
                androidAdapter.setAndroidList(mTodayInfo.getResults().getAndroid());
                holder.rvDetail.setAdapter(androidAdapter);
                break;
            case "瞎推荐":
                DetailAdapter recommendAdapter = new DetailAdapter(Category.RECOMMEND);
                recommendAdapter.setRecommendList(mTodayInfo.getResults().getRecommend());
                holder.rvDetail.setAdapter(recommendAdapter);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mTodayInfo == null || mTodayInfo.getCategory() == null ? 0 : mTodayInfo.getCategory().size();
    }

    @Override
    public void accept(TodayInfo todayInfo) throws Exception {
        mTodayInfo = todayInfo;
        notifyDataSetChanged();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCategory;
        private RecyclerView rvDetail;

        MainViewHolder(View itemView) {
            super(itemView);
            rvDetail = itemView.findViewById(R.id.rv_detail);
            tvCategory = itemView.findViewById(R.id.tv_category);
        }
    }

    public enum Category {
        APP("App"),
        WEB("前端"),
        IOS("iOS"),
        BENEFIT("福利"),
        VIDEO("休息视频"),
        EXTEND("拓展资源"),
        ANDROID("Android"),
        RECOMMEND("瞎推荐");

        private final String value;

        Category(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
