package com.gxg.demojiuxi6.mydemo6.http.progress;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/**
 * @author yuliuyue
 */
public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

//    private CustomProgressDialog cpd;

    private Context context;
    private boolean cancelable;
    private boolean showProgressDialog = false;
    private ProgressCancelListener mProgressCancelListener;

    public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener,
                                 boolean cancelable) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
    }

    public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener,
                                 boolean cancelable, boolean showProgressDialog) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
        this.showProgressDialog = showProgressDialog;
    }

    private void initProgressDialog() {

//        if (cpd == null) {
//            cpd = new CustomProgressDialog(context, "加载中...");
//            cpd.setCancelable(cancelable);
//
//            if (cancelable) {
//                cpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                    @Override
//                    public void onCancel(DialogInterface dialogInterface) {
//                        mProgressCancelListener.onCancelProgress();
//                    }
//                });
//            }
//            if (!cpd.isShowing()) {
//                cpd.show();
//            }
//        }

    }

    private void dismissProgressDialog() {

//        if (cpd != null) {
//            cpd.dismiss();
//            cpd = null;
//        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                if (showProgressDialog)
//                    initProgressDialog();
                    break;
            case DISMISS_PROGRESS_DIALOG:
                if (showProgressDialog)
//                    dismissProgressDialog();
                    break;
        }
    }

}
