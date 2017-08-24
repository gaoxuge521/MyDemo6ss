package com.gxg.demojiuxi6.mydemo6.http.subscribers;

import android.app.Activity;

import com.gxg.demojiuxi6.mydemo6.http.progress.ProgressCancelListener;
import com.gxg.demojiuxi6.mydemo6.http.progress.ProgressDialogHandler;

import rx.Subscriber;

//import com.blankj.utilcode.util.ToastUtils;
//import com.blankj.utilcode.util.newer.IntentParam;
//import com.blankj.utilcode.util.newer.IntentUtil;
//import com.jiuxi.marriage.commonlib.utils.RxBus;
//import com.jiuxi.marriage.commonlib.widget.dialog.CustomDialog;
//import com.jiuxi.marriage.event.UserEvent;
//import com.jiuxi.marriage.http.exception.ApiException;
//import com.jiuxi.marriage.http.progress.ProgressCancelListener;
//import com.jiuxi.marriage.http.progress.ProgressDialogHandler;
//import com.jiuxi.marriage.module.huanxin.controller.HXController;
//import com.jiuxi.marriage.module.main.GlobalVar;
//import com.jiuxi.marriage.module.main.MainActivity;
//import com.jiuxi.marriage.module.user.login.LoginRegisterActivity;

/**
 * 用于在Http请求开始时，自动显示一个ProgressDialog
 * 在Http请求结束是，关闭ProgressDialog
 * 调用者自己对请求数据进行处理
 *
 * @author yuliuyue
 */
public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {

    private SubscriberOnNextListener mSubscriberOnNextListener;
    private SubscriberOnErrorListener mSubscriberOnErrorListener;
    private UploadSubscriberOnNextListener mUploadSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;

    private Activity context;

    private int showNoNetWork = 0;
    private int position = -1;

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Activity context) {
        this(mSubscriberOnNextListener, context, false, 0, 0);
    }

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, SubscriberOnErrorListener mSubscriberOnErrorListener, Activity context) {
        this(mSubscriberOnNextListener, context, false, 0, 0);
        this.mSubscriberOnErrorListener = mSubscriberOnErrorListener;
    }

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Activity context, int showNoNetWork) {
        this(mSubscriberOnNextListener, context, false, showNoNetWork, 0);
    }

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Activity context, boolean showProgressDialog) {
        this(mSubscriberOnNextListener, context, showProgressDialog, 0, 0);
    }

    public ProgressSubscriber(UploadSubscriberOnNextListener mSubscriberOnNextListener, SubscriberOnErrorListener mSubscriberOnErrorListener, Activity context, boolean showProgressDialog, int position) {
        this.mUploadSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true, showProgressDialog);
        this.mSubscriberOnErrorListener = mSubscriberOnErrorListener;
        this.position = position;
    }

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Activity context, boolean showProgressDialog, int showNoNetWork, int position) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true, showProgressDialog);
        this.showNoNetWork = showNoNetWork;
        this.position = position;
    }


    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
        showProgressDialog();
    }

    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     */
    @Override
    public void onError(Throwable e) {

//        if (mSubscriberOnErrorListener != null) {
//            mSubscriberOnErrorListener.onError((Exception) e);
//        }
//
//        if (e instanceof SocketTimeoutException) {
//            ToastUtils.showShortToast("网络中断，请检查您的网络状态 ");
//        } else if (e instanceof ConnectException) {
//            if (showNoNetWork == 0)
//                ToastUtils.showShortToast("网络中断，请检查您的网络状态 ");
//
//        } else if (e instanceof ApiException) {
//            if ("000010".equals(((ApiException) e).getCode())) {
//
//                synchronized (context) {
//                    if (!GlobalVar.isLogin()) {
//                        return;
//                    } else {
//                        GlobalVar.logout();
//                        HXController.logoutHX(null);
//                        RxBus.getDefault().post(new UserEvent(UserEvent.USER_OUT_EVENT));
//                    }
//                }
//
//                CustomDialog customDialog = new CustomDialog(context);
//                customDialog.baseDialog(context, "退出通知", "您的账号已在其他手机登录,本端自动退出", "知道了", "再去登录", new CustomDialog.NegativeOnClick() {
//                    @Override
//                    public void onNegativeClick() {
//
//                        IntentUtil.launch(context, MainActivity.class);
//                    }
//                }, new CustomDialog.PositiveOnClick() {
//                    @Override
//                    public void onPositiveClick() {
//                        IntentParam intentParam = new IntentParam();
//                        intentParam.putExtra("outByOther","outByOther");
//                        IntentUtil.launch(context,intentParam, LoginRegisterActivity.class);
//                    }
//                }, false);
//            }else if("000002".equals(((ApiException) e).getCode())) {
//                synchronized (context) {
//                    if (!GlobalVar.isLogin()) {
//                        return;
//                    } else {
//                        GlobalVar.logout();
//                        HXController.logoutHX(null);
//                        RxBus.getDefault().post(new UserEvent(UserEvent.USER_OUT_EVENT));
//                    }
//                }
//
//                IntentParam intentParam = new IntentParam();
//                intentParam.putExtra("outByOther","outByOther");
//                IntentUtil.launch(context,intentParam, LoginRegisterActivity.class);
//            }
//            else {
//                ToastUtils.showShortToast(e.getMessage());
//            }
//        }

        dismissProgressDialog();
    }

    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext(t);
        } else if (mUploadSubscriberOnNextListener != null) {
            mUploadSubscriberOnNextListener.onPositionNext(t, position);
        }
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}