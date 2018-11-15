package com.saltedfish.realshit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.saltedfish.realshit.data.TodayInfo;

import io.reactivex.functions.Consumer;

/**
 * Created by SaltedFish on 2018/11/15.
 * 主界面适配器
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>
        implements Consumer<TodayInfo> {
    private TodayInfo mTodayInfo;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mTodayInfo == null ? 0 : mTodayInfo.getCategory().size();
    }

    @Override
    public void accept(TodayInfo todayInfo) throws Exception {
        mTodayInfo = todayInfo;
        notifyDataSetChanged();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
