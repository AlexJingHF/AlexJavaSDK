package com.alex.sdk.Ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Administrator on 2014/9/17.
 */
public class GuideToast
{
    private Context mContext;
    private HandlerThread mThread;
    private ToastHandler mHander;
//    private Toast mToast;
    private View targetView;
    private ImageView imageView;
    private WindowManager mWM;
    private int[] location;
    private WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
    private boolean isShow = false;
    public GuideToast(Context context, View targetView)
    {
        this.targetView = targetView;
        mContext = context;
        imageView = new ImageView(context);
//        imageView.setImageResource(R.drawable.ic_launcher);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                hide();
            }
        });
//        mToast = new Toast(mContext);
//        mToast.setView(imageView);
        mThread = new HandlerThread("GuideToast");
        mThread.start();
        mHander = new ToastHandler(mThread.getLooper());
    }

    class ToastHandler extends Handler{

        ToastHandler(Looper looper)
        {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case SHOW:
                    showInHander();
                    new RThread().start();
                break;
                case HIDE:
                    handleHide();
                    break;
                case FRESH:
                    handleFresh();
                    break;
                default:
                {

                }
            }
        }
    }

    private void handleFresh()
    {
        if (mWM != null && imageView != null)
        {
            Rect rect = getShowRect(location);
            mParams.x = rect.left;
            mParams.y = rect.top;
            mWM.updateViewLayout(imageView,mParams);
        }
    }

    private void handleHide()
    {
        if (mWM != null && imageView != null)
        {
            mWM.removeView(imageView);
            isShow = false;
        }
    }

    private void showInHander()
    {
         location = getTargetLocation();
        if (location[0] ==0 && location[1] == 0)
        {
            mHander.sendEmptyMessageDelayed(SHOW,20);
        }else
        {
            Rect rect = getShowRect(location);
            mWM = (WindowManager) targetView.getContext().getSystemService(Context.WINDOW_SERVICE);

            mParams.x = rect.left;
            mParams.y = rect.top;
            mParams.gravity = Gravity.TOP|Gravity.LEFT;
            mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            mParams.flags =  WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            mParams.format = PixelFormat.TRANSLUCENT;
//            mParams.windowAnimations = com.android.internal.R.style.Animation_Toast;
            mParams.type = WindowManager.LayoutParams.TYPE_TOAST;
            mParams.setTitle("Toast");
            mWM.addView(imageView,mParams);
//            mToast.setGravity(Gravity.TOP | Gravity.LEFT, rect.left, rect.top);
//            mToast.show();
            isShow = true;
        }
    }

    private Rect getShowRect(int[] location)
    {
//        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.ic_launcher);
//        int w = bitmap.getWidth();
        int h = 0;
        Rect window = new Rect();
        targetView.getWindowVisibleDisplayFrame(window);
        int statusHeight = window.top;
        Rect newRect = new Rect();
        newRect.top = statusHeight + h +location[1];
        newRect.left = location[0];
        return newRect;
    }

    private int[] getTargetLocation()
    {
        int[] location = new int[2];
        targetView.getLocationInWindow(location);
        return location;
    }

    public static GuideToast make(Context context,View targetView,String value)
    {
        GuideToast guideToast = new GuideToast(context,targetView);
        return guideToast;
    }

    private static final int SHOW = 1;
    private static final int HIDE = 0;
    private static final int FRESH = 2;
    private void refesh()
    {
        mHander.sendEmptyMessage(FRESH);
    }
    public void show()
    {
        mHander.sendEmptyMessage(SHOW);
    }

    public void hide()
    {
        mHander.sendEmptyMessage(HIDE);
    }

    class RThread extends Thread
    {
        @Override
        public void run()
        {
            while (isShow)
            {
                int[] newLocation = getTargetLocation();
                if (newLocation[0] != location[0] || newLocation[1] != location[1])
                {
                    location = newLocation;
                    refesh();
                }

                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
