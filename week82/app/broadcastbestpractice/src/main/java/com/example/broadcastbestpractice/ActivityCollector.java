package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    public static List<MainActivity> activities=new ArrayList<>();
    public static void addActvity(Activity activity){
        activities.add((MainActivity) activity);
    }
    public static void removeActivity(Activity activity){
        activities.add((MainActivity) activity);
    }
    public static void finishAll(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }

    public static void addAcitivity(BaseActivity baseActivity) {
    }

    public static void addActivity(BaseActivity baseActivity) {
    }
}
