package team.fastflow.kusu.ui.Models;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.view.animation.Animation;
import android.widget.TextView;

import team.fastflow.kusu.R;
import team.fastflow.kusu.ui.Listeners.TimerListener;
import team.fastflow.kusu.ui.Utils.Utils;
import team.fastflow.kusu.ui.Views.ProgressLine;

/**
 * Created by KuSu on 28.01.2017.
 */

public class Logic implements TimerListener {

    private final ProgressLine progressLine;
    private final TextView time;
    private final TextView step;
    private ObjectAnimator anim;

    Integer color = null;

    public Logic(ProgressLine progressLine) {
        this.progressLine = progressLine;
        time = (TextView) progressLine.findViewById(R.id.firstText);
        step = (TextView) progressLine.findViewById(R.id.secondText);
    }

    @Override
    public void step() {
        progressLine.getState().incCurrentTime();
        progressLine.getListeners().nextTime();
        if (!progressLine.getSettings().isStep()) {
            if (progressLine.getState().getCurrentTime() >= progressLine.getSettings().getTimeMax())
                progressLine.nextStep();
            if (progressLine.getState().isEnd(progressLine.getSettings().getStepMax()))
                progressLine.getClock().stopTime();
        }
        invalidate();
    }

    private void drawStep() {
        step.setText(progressLine.getState().getCurrentStep() + " / " + progressLine.getSettings().getStepMax());
    }

    private void drawTime() {
        saveColor();
        if (progressLine.getSettings().isStep()) {
            if (progressLine.getSettings().isDrawTime())
                time.setText(Utils.getTime(progressLine.getState().getCurrentTime()));
            else
                time.setText("");
        } else {
            int timeLast = progressLine.getSettings().getTimeMax() - progressLine.getState().getCurrentTime();
            time.setText(Utils.getTime(timeLast));
            if (timeLast > 0 && timeLast <= progressLine.getSettings().getTimeRed()) {
                if (anim == null) {
                    anim = ObjectAnimator.ofInt(time,
                            "textColor",
                            color,
                            progressLine.getSettings().getTimeEndColor());
                    anim.setDuration(progressLine.getSettings().getDuration());
                    anim.setEvaluator(new ArgbEvaluator());
                    anim.setRepeatMode(ValueAnimator.RESTART);
                    anim.setRepeatCount(Animation.INFINITE);
                    anim.start();
                }
            } else {
                if (anim != null) {
                    anim.cancel();
                    anim.end();
                    anim = null;
                    time.setTextColor(color);
                }
            }
        }
    }

    private void saveColor() {
        if (color == null)
            color = time.getCurrentTextColor();
    }

    public void invalidate() {
        Activity activity = ((Activity) progressLine.getContext());
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    drawStep();
                    drawTime();
                    progressLine.getLine().invalidate();
                }
            });
        }
    }
}
