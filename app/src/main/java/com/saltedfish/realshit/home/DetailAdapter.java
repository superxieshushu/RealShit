package com.saltedfish.realshit.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.saltedfish.realshit.R;
import com.saltedfish.realshit.data.TodayInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SaltedFish on 2018/11/18.
 * 简单描述作用
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    private Context mContext;
    private AndroidAdapter.Category mCategory;
    private List<TodayInfo.ResultsBean.AppBean> mAppList;
    private List<TodayInfo.ResultsBean.IOSBean> mIOSList;
    private List<TodayInfo.ResultsBean.WebBean> mWebList;
    private List<TodayInfo.ResultsBean.VideoBean> mVideoList;
    private List<TodayInfo.ResultsBean.ExtendBean> mExtendList;
    private List<TodayInfo.ResultsBean.AndroidBean> mAndroidList;
    private List<TodayInfo.ResultsBean.BenefitBean> mBenefitList;
    private List<TodayInfo.ResultsBean.RecommendBean> mRecommendList;


    public DetailAdapter(AndroidAdapter.Category category) {
        mCategory = category;
    }

    public void setAppList(List<TodayInfo.ResultsBean.AppBean> appList) {
        mAppList = appList;
    }

    public void setAndroidList(List<TodayInfo.ResultsBean.AndroidBean> androidList) {
        mAndroidList = androidList;
    }

    public void setIOSList(List<TodayInfo.ResultsBean.IOSBean> IOSList) {
        mIOSList = IOSList;
    }

    public void setBenefitList(List<TodayInfo.ResultsBean.BenefitBean> benefitList) {
        mBenefitList = benefitList;
    }

    public void setExtendList(List<TodayInfo.ResultsBean.ExtendBean> extendList) {
        mExtendList = extendList;
    }

    public void setRecommendList(List<TodayInfo.ResultsBean.RecommendBean> recommendList) {
        mRecommendList = recommendList;
    }

    public void setVideoList(List<TodayInfo.ResultsBean.VideoBean> videoList) {
        mVideoList = videoList;
    }

    public void setWebList(List<TodayInfo.ResultsBean.WebBean> webList) {
        mWebList = webList;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_detail, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        switch (mCategory) {
            case RECOMMEND:
                holder.tvContent.setText(mRecommendList.get(position).getDesc());
                break;
            case BENEFIT:
                holder.tvContent.setText(mBenefitList.get(position).getDesc());
                Glide.with(mContext).load(mBenefitList.get(position).getUrl()).into(holder.iv1);
                break;
            case ANDROID:
                holder.tvContent.setText(mAndroidList.get(position).getDesc());
                List<String> androidImgUrl = mAndroidList.get(position).getImages();
                for (int i = 0; i < androidImgUrl.size()&& i < holder.mIvList.size(); i++) {
                    Glide.with(mContext).load(androidImgUrl.get(i)).into(holder.mIvList.get(i));
                }
                break;
            case EXTEND:
                holder.tvContent.setText(mExtendList.get(position).getDesc());
                break;
            case VIDEO:
                holder.tvContent.setText(mVideoList.get(position).getDesc());
                break;
            case WEB:
                holder.tvContent.setText(mWebList.get(position).getDesc());
                break;
            case IOS:
                holder.tvContent.setText(mIOSList.get(position).getDesc());
                List<String> iOSImgUrl = mIOSList.get(position).getImages();
                for (int i = 0; i < iOSImgUrl.size()&& i < holder.mIvList.size(); i++) {
                    Glide.with(mContext).load(iOSImgUrl.get(i)).into(holder.mIvList.get(i));
                }
                break;
            case APP:
                holder.tvContent.setText(mAppList.get(position).getDesc());
                List<String> appImgUrl = mAppList.get(position).getImages();
                for (int i = 0; i < appImgUrl.size() && i < holder.mIvList.size(); i++) {
                    Glide.with(mContext).load(appImgUrl.get(i)).into(holder.mIvList.get(i));
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        switch (mCategory) {
            case APP:
                return mAppList == null ? 0 : mAppList.size();
            case IOS:
                return mIOSList == null ? 0 : mIOSList.size();
            case WEB:
                return mWebList == null ? 0 : mWebList.size();
            case VIDEO:
                return mVideoList == null ? 0 : mVideoList.size();
            case EXTEND:
                return mExtendList == null ? 0 : mExtendList.size();
            case ANDROID:
                return mAndroidList == null ? 0 : mAndroidList.size();
            case BENEFIT:
                return mBenefitList == null ? 0 : mBenefitList.size();
            case RECOMMEND:
                return mRecommendList == null ? 0 : mRecommendList.size();
        }
        return 0;
    }

    static class DetailViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv1;
        private ImageView iv2;
        private ImageView iv3;
        private TextView tvContent;
        private List<ImageView> mIvList;

        DetailViewHolder(View itemView) {
            super(itemView);
            mIvList = new ArrayList<>();
            iv1 = itemView.findViewById(R.id.iv_1);
            iv2 = itemView.findViewById(R.id.iv_2);
            iv3 = itemView.findViewById(R.id.iv_3);
            mIvList.add(iv1);
            mIvList.add(iv2);
            mIvList.add(iv3);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }


}
