package team.fastflow.kusu.ui.Models;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by KuSu on 28.01.2017.
 */

public class Settings {

    public static int TIMER = 0;
    public static int STEP = 1;
    public static int TIME_STEP = 2;
    public static int TIME_STEP_PART = 3;
    public static int TIME_STEP_FULL = 4;

    private int type;
    private int layout;

    private int maxTime;
    private int maxStep;

    private boolean seeTime;
    private int redTime;

    public Settings(Context context, AttributeSet attrs) {

    }

    public int getType() {
        return type;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getMaxStep() {
        return maxStep;
    }

    public void setMaxStep(int maxStep) {
        this.maxStep = maxStep;
    }


    public void changeType(int type){
        this.type = type;
    }

    public boolean isStep() {
        return type == STEP;
    }
}
