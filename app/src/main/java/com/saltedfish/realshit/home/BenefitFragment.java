package com.saltedfish.realshit.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saltedfish.realshit.R;
import com.saltedfish.realshit.data.AndroidInfo;
import com.saltedfish.realshit.data.BenefitInfo;
import com.saltedfish.realshit.data.RetrofitUtil;
import com.saltedfish.realshit.view.ParallaxAdapter;
import com.saltedfish.realshit.view.ParallaxListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SaltedFish on 2018/11/19.
 * 简单描述作用
 */
public class BenefitFragment extends Fragment {
    private ParallaxListView mParallaxListView;
    private CompositeDisposable mCompositeDisposable;
    private ParallaxAdapter mParallaxAdapter;
    private SmartRefreshLayout mSrl;
    private int mPage = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_benefit, container, false);
        mParallaxListView = view.findViewById(R.id.lv);
        mSrl = view.findViewById(R.id.srl);
        initView();
        fetchData();
        return view;
    }

    private void initView() {
        mParallaxAdapter = new ParallaxAdapter();
        mParallaxListView.setAdapter(mParallaxAdapter);
        mCompositeDisposable = new CompositeDisposable();
        mSrl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                fetchData();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSrl.finishRefresh();
                    }
                }, 2000);
            }
        });
        mSrl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                fetchMoreData(++mPage);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSrl.finishLoadMore();
                    }
                }, 2000);
            }
        });
    }

    private void fetchData() {
        Disposable disposable = RetrofitUtil.getInstance().getApiService()
                .fetchBenefitInfo("福利", "10", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mParallaxAdapter);
        mCompositeDisposable.add(disposable);
    }

    private void fetchMoreData(final int page) {
        Disposable disposable = RetrofitUtil.getInstance().getApiService()
                .fetchBenefitInfo("福利", "10", page + "")
                .map(new Function<BenefitInfo, BenefitInfo>() {
                    @Override
                    public BenefitInfo apply(BenefitInfo benefitInfo) throws Exception {
                        benefitInfo.setPage(page);
                        return benefitInfo;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mParallaxAdapter);
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
    }

}
