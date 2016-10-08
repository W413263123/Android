package com.example.jesophwen.josephwenandroidtext.BaseFiles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenkui on 16/9/19.
 * 活动管理器
 */
public class ActivityController {
    static List<Activity> activities = new ArrayList<Activity>();  // 存放活动的数组

    /** 添加活动到数组中 */
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /** 从数组中移除指定活动 */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /** 退出程序 */
    public static void finishAll() {
        for (Activity activity: activities) {
            activity.finish();
        }
    }

    /** 返回到上一层 */
    public static void backToLastActivity(Context context, Class cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }


}
