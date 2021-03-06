package com.efly.flyhelper.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.efly.flyhelper.R;

/**
 * dialog 类库
 * 这里的context 要用activity的上下文,
 *
 */

public class DialogCreator {

    public static Dialog createLoadingDialog(Context context, String msg) {
        Log.e("create-->", "createLoadingDialog" + "");
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_view, null);
        RelativeLayout layout = (RelativeLayout) v.findViewById(R.id.dialog_view);
        ImageView mLoadImg = (ImageView) v.findViewById(R.id.loading_img);
        TextView mLoadText = (TextView) v.findViewById(R.id.loading_txt);
        AnimationDrawable mDrawable = (AnimationDrawable) mLoadImg.getDrawable();
        mDrawable.start();
        mLoadText.setText(msg);
        final Dialog loadingDialog = new Dialog(context, R.style.LoadingDialog);
        loadingDialog.setCancelable(true);
        loadingDialog.setCanceledOnTouchOutside(false);
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        return loadingDialog;
    }



    public static Dialog createTitleExitDialog(Context context, String tltles, View.OnClickListener onClickListener) {
        final Dialog loadingDialog = new Dialog(context, R.style.default_dialog_style);
        LayoutInflater inflater = LayoutInflater.from(context);
       // loadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        View v = inflater.inflate(R.layout.dialog_exit, null);
        loadingDialog.setContentView(v);
        loadingDialog.setCancelable(true);
        loadingDialog.setCanceledOnTouchOutside(false);
        TextView tv_tltle = (TextView) v.findViewById(R.id.tv_tltle);
        tv_tltle.setText(tltles);
        final Button cancel = (Button) v.findViewById(R.id.cancel_btn);
        final Button commit = (Button) v.findViewById(R.id.commit_btn);
        cancel.setOnClickListener(onClickListener);
        commit.setOnClickListener(onClickListener);
        return loadingDialog;
    }

    public static Dialog createBaseCustomDialog(Context context, String title, String text,
                                                View.OnClickListener onClickListener) {
        Dialog baseDialog = new Dialog(context, R.style.default_dialog_style);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_base, null);
        baseDialog.setContentView(v);
        TextView titleTv = (TextView) v.findViewById(R.id.dialog_base_title_tv);
        TextView textTv = (TextView) v.findViewById(R.id.dialog_base_text_tv);
        Button confirmBtn = (Button) v.findViewById(R.id.dialog_base_confirm_btn);
        titleTv.setText(title);
        textTv.setText(text);
        confirmBtn.setOnClickListener(onClickListener);
        baseDialog.setCancelable(false);
        return baseDialog;
    }

    /*dialog.getWindow().setLayout((int) (0.8 * mWidth), WindowManager.LayoutParams.WRAP_CONTENT);
    dialog.show();*/


}
