package com.gw.newstart.net;

import android.app.Activity;

import com.gw.newstart.model.ResponseEntity;
import com.gw.newstart.utils.ToastUtil;

import java.lang.ref.WeakReference;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by GongWen on 17/5/26.
 */

public abstract class WebObserver<T> implements Observer<ResponseEntity<T>> {
    private WeakReference<Activity> mRefActivity;

    public WebObserver(Activity mActivity) {
        mRefActivity = new WeakReference<>(mActivity);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (mRefActivity.get() == null) {
            Activity mActivity = mRefActivity.get();
            if (mActivity.isDestroyed() || mActivity.isFinishing()) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }
        }
    }

    @Override
    public void onNext(@NonNull ResponseEntity<T> responseEntity) {
        if (responseEntity.isSuccess()) {
            onSuccess(responseEntity.getBody());
        } else {
            onBusiness(responseEntity.getCode(), responseEntity.getMsg());
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        onFailure(new Exception(e));
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);

    public void onBusiness(int code, String msg) {
        ToastUtil.showToastShort(code + "---" + msg);
    }

    public void onFailure(Exception e) {
    }
}
