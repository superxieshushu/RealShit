package com.saltedfish.realshit.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saltedfish.realshit.R;
import com.saltedfish.realshit.data.RetrofitUtil;
import com.saltedfish.realshit.view.ParallaxAdapter;
import com.saltedfish.realshit.view.ParallaxListView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SaltedFish on 2018/11/19.
 * 简单描述作用
 */
public class BenefitFragment extends Fragment {
    private ParallaxListView mParallaxListView;
    private CompositeDisposable mCompositeDisposable;
    private ParallaxAdapter mParallaxAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_benefit, container, false);
        mParallaxListView = view.findViewById(R.id.lv);
        initView();
        fetchData();
        return view;
    }

    private void initView() {
        mParallaxAdapter = new ParallaxAdapter();
        mParallaxListView.setAdapter(mParallaxAdapter);
    }

    private void fetchData() {
        mCompositeDisposable = new CompositeDisposable();
        Disposable disposable = RetrofitUtil.getInstance().getApiService()
                .fetchBenefitInfo("福利", "10", "1")
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
