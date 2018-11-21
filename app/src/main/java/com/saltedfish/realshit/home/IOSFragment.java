package com.saltedfish.realshit.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saltedfish.realshit.R;
import com.saltedfish.realshit.data.IOSInfo;
import com.saltedfish.realshit.data.RetrofitUtil;
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
public class IOSFragment extends Fragment {
    private RecyclerView mRvCategory;
    private IOSAdapter mIOSAdapter;
    private SmartRefreshLayout mSrl;
    private int mPage = 1;
    private CompositeDisposable mCompositeDisposable;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        mRvCategory = view.findViewById(R.id.rv_item);
        mSrl = view.findViewById(R.id.srl);
        initView();
        fetchData();
        return view;
    }

    private void initView() {
        mIOSAdapter = new IOSAdapter();
        mRvCategory.setAdapter(mIOSAdapter);
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
                .fetchIOSInfo("iOS", "10", "1")
                .map(new Function<IOSInfo, IOSInfo>() {
                    @Override
                    public IOSInfo apply(IOSInfo iosInfo) throws Exception {
                        iosInfo.setPage(1);
                        return iosInfo;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mIOSAdapter);
        mCompositeDisposable.add(disposable);
    }

    private void fetchMoreData(final int page) {
        Disposable disposable = RetrofitUtil.getInstance().getApiService()
                .fetchIOSInfo("iOS", "10", page + "")
                .map(new Function<IOSInfo, IOSInfo>() {
                    @Override
                    public IOSInfo apply(IOSInfo iosInfo) throws Exception {
                        iosInfo.setPage(page);
                        return iosInfo;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mIOSAdapter);
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
    }
}
