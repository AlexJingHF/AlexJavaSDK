package com.alex.sdk.Ui;

import android.app.Activity;

import java.util.ArrayList;

/**
 * 可以退出所有应用
 * Created by alex on 14-8-24.
 */
public class ActivityCollector {
    public static ArrayList<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing())
                activity.finish();
        }
    }

}
