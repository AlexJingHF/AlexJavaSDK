package com.alex.sdk.Ui;

import android.app.Activity;
import android.os.Bundle;

/**
 * 基础Activity 可完善一些方法
 * Created by alex on 14-8-24.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
