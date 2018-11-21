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
import com.saltedfish.realshit.data.IOSInfo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by SaltedFish on 2018/11/15.
 * 主界面适配器
 */
public class IOSAdapter extends RecyclerView.Adapter<IOSAdapter.DetailViewHolder>
        implements Consumer<IOSInfo> {
    private Context mContext;
    private List<IOSInfo.ResultsBean> mIOSInfo = new ArrayList<>();

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_detail, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        holder.tvContent.setText(mIOSInfo.get(position).getDesc());
        List<String> images = mIOSInfo.get(position).getImages();
        if (images != null) {
            for (int i = 0; i < images.size() && i < holder.mIvList.size(); i++) {
                Glide.with(mContext).load(images.get(i)).into(holder.mIvList.get(i));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mIOSInfo == null ? 0 : mIOSInfo.size();
    }

    @Override
    public void accept(IOSInfo iosInfo) throws Exception {
        if (iosInfo.getPage() == 1) {
            mIOSInfo.clear();
        }
        if (iosInfo.getResults() != null) {
            mIOSInfo.addAll(iosInfo.getResults());
            notifyDataSetChanged();
        }
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
