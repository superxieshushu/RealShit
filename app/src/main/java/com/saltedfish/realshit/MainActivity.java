package com.saltedfish.realshit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.saltedfish.realshit.data.RetrofitUtil;
import com.saltedfish.realshit.data.TodayInfo;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCompositeDisposable = new CompositeDisposable();
        Disposable disposable = RetrofitUtil.getInstance().getApiService().fetchTodayInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TodayInfo>() {
                    @Override
                    public void accept(TodayInfo todayInfo) throws Exception {

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCompositeDisposable.dispose();
    }
}
