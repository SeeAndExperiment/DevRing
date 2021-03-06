package com.dev.base.di.module.activity;

import android.content.Context;
import android.view.View;

import com.dev.base.mvp.model.UploadModel;
import com.dev.base.mvp.model.imodel.IUploadModel;
import com.dev.base.mvp.presenter.UploadPresenter;
import com.dev.base.mvp.view.iview.IUploadView;
import com.dev.base.mvp.view.widget.MaterialDialog;
import com.dev.base.mvp.view.widget.PhotoPopWindow;
import com.ljy.devring.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * author:  ljy
 * date:    2018/3/23
 * description: 对UploadActivity中的相关变量进行初始化
 */
@Module
public class UploadActivityModule {

    private Context mContext;

    public UploadActivityModule(Context context) {
        mContext = context;
    }

    @Provides
    @ActivityScope
    Context context() {
        return mContext;
    }

    @Provides
    @ActivityScope
    PhotoPopWindow photoPopWindow(Context context) {
        return new PhotoPopWindow(context, (View.OnClickListener) context);
    }

    @Provides
    @ActivityScope
    IUploadView iUploadView() {
        return (IUploadView) mContext;
    }

    @Provides
    @ActivityScope
    IUploadModel iUploadModel() {
        return new UploadModel();
    }

    @Provides
    @ActivityScope
    UploadPresenter uploadPresenter(IUploadView iUploadView, IUploadModel iUploadModel) {
        return new UploadPresenter(iUploadView, iUploadModel);
    }

    @Provides
    @ActivityScope
    MaterialDialog materialDialog(Context context) {
        return new MaterialDialog(context).setCanceledOnTouchOutside(true).setTitle("提示");
    }
}
