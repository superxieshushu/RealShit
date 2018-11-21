package com.saltedfish.realshit.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saltedfish.realshit.R;
import com.saltedfish.realshit.data.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SaltedFish on 2018/11/19.
 * 简单描述作用
 */
public class AndroidFragment extends Fragment {
    private RecyclerView mRvCategory;
    private AndroidAdapter mAndroidAdapter;
    private CompositeDisposable mCompositeDisposable;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        initView(view);
        fetchData();
        return view;
    }

    private void initView(View view) {
        mRvCategory = view.findViewById(R.id.rv_item);
        mAndroidAdapter = new AndroidAdapter();
        mRvCategory.setAdapter(mAndroidAdapter);
    }

    private void fetchData() {
        mCompositeDisposable = new CompositeDisposable();
        Disposable disposable = RetrofitUtil.getInstance().getApiService()
                .fetchAndroidInfo("Android", "10", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mAndroidAdapter);
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
    }
}
