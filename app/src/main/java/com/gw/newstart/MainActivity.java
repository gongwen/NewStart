package com.gw.newstart;

import android.os.Bundle;
import android.widget.TextView;

import com.gw.newstart.model.ResponseEntity;
import com.gw.newstart.model.UserEntity;
import com.gw.newstart.net.ApiGetService;
import com.gw.newstart.net.ApiPostService;
import com.gw.newstart.net.WebObserver;
import com.gw.newstart.net.WebServiceManager;
import com.gw.newstart.rxhelper.SchedulersCompat;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends RxAppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ApiGetService apiGetService = WebServiceManager.getInstance().getApiGetService();
        ApiPostService apiPostService = WebServiceManager.getInstance().getApiPostService();
        apiGetService.getGankList()
                .compose(bindToLifecycle())
                .compose(SchedulersCompat.<ResponseEntity<UserEntity>>applyIoSchedulers())
                .subscribe(new WebObserver<UserEntity>(this) {
                    @Override
                    public void onSuccess(UserEntity resultEntity) {
                        Logger.i("get--->" + resultEntity.toString());
                    }
                });
        apiPostService.getGankList("用户名", "密码")
                .compose(this.<ResponseEntity<UserEntity>>bindToLifecycle())
                .compose(SchedulersCompat.<ResponseEntity<UserEntity>>applyIoSchedulers())
                .subscribe(new WebObserver<UserEntity>(this) {
                    @Override
                    public void onSuccess(UserEntity resultEntity) {
                        Logger.i("post--->" + resultEntity.toString());
                    }
                });
    }
}
