package com.gw.newstart.rxhelper;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by GongWen on 17/5/26.
 */

public class SchedulersCompat {

    private static final ObservableTransformer computationTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return upstream.subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };

    private static final ObservableTransformer ioTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final ObservableTransformer newThreadTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return upstream.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };

    private static final ObservableTransformer singleTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return upstream.subscribeOn(Schedulers.single())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final ObservableTransformer trampolineTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return upstream.subscribeOn(Schedulers.trampoline())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final ObservableTransformer executorTransformer = new ObservableTransformer() {

        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return upstream.subscribeOn(Schedulers.from(ExecutorManager.eventExecutor))
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };

    /**
     * Don't break the chain: use RxJava's compose() operator
     */
    public static <T> ObservableTransformer<T, T> applyComputationSchedulers() {
        return (ObservableTransformer<T, T>) computationTransformer;
    }

    public static <T> ObservableTransformer<T, T> applyIoSchedulers() {
        return (ObservableTransformer<T, T>) ioTransformer;
    }

    public static <T> ObservableTransformer<T, T> applyNewThreadSchedulers() {
        return (ObservableTransformer<T, T>) newThreadTransformer;
    }

    public static <T> ObservableTransformer<T, T> applySingleSchedulers() {
        return (ObservableTransformer<T, T>) singleTransformer;
    }

    public static <T> ObservableTransformer<T, T> applyTrampolineSchedulers() {
        return (ObservableTransformer<T, T>) trampolineTransformer;
    }

    public static <T> ObservableTransformer<T, T> applyExecutorSchedulers() {
        return (ObservableTransformer<T, T>) executorTransformer;
    }
}
