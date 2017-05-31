package com.gw.newstart.net;

import android.app.Activity;

import com.gw.newstart.model.ResponseEntity;
import com.gw.newstart.utils.StringUtils;
import com.gw.newstart.utils.ToastUtil;
import com.orhanobut.logger.Logger;

import java.lang.ref.WeakReference;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

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
        if (mRefActivity.get() == null || mRefActivity.get().isFinishing() || mRefActivity.get().isDestroyed()) {
            if (!d.isDisposed()) {
                d.dispose();
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
        onFailure(e);
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);

    public void onBusiness(int code, String msg) {
        ToastUtil.showToastShort(code + "---" + msg);
    }

    public void onFailure(Throwable e) {
        Logger.i("onFailure:Throwable--->" + e.getCause());

        if (e instanceof SocketException) {//ConnectException is a subClass of SocketException
            ToastUtil.showToastShort(StringUtils.getNetErrorTip());
        } else if (e instanceof UnknownHostException) {
        } else if (e instanceof SocketTimeoutException) {
        }

    }
}
