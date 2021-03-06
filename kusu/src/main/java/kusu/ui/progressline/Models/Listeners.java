package kusu.ui.progressline.Models;

import kusu.ui.progressline.Listeners.OnStepChangeListener;
import kusu.ui.progressline.Listeners.TimeChangeListener;
import kusu.ui.progressline.Views.ProgressLine;

/**
 * Created by KuSu on 28.01.2017.
 */

public class Listeners {
    private OnStepChangeListener onStepChangeListener;
    private TimeChangeListener timeChangeListener;
    private ProgressLine progressLine;

    public Listeners(ProgressLine progressLine) {
        this.progressLine = progressLine;
    }

    public OnStepChangeListener getOnStepChangeListener() {
        return onStepChangeListener;
    }

    public void setOnStepChangeListener(OnStepChangeListener onStepChangeListener) {
        this.onStepChangeListener = onStepChangeListener;
    }

    public TimeChangeListener getTimeChangeListener() {
        return timeChangeListener;
    }

    public void setTimeChangeListener(TimeChangeListener timeChangeListener) {
        this.timeChangeListener = timeChangeListener;
    }

    public void nextStep() {
        if (onStepChangeListener != null)
            onStepChangeListener.changeStep(progressLine, progressLine.getState().getCurrentStep(), progressLine.getSettings().getStepMax());
    }

    public void nextTime() {
        if (timeChangeListener != null)
            timeChangeListener.timeChange(progressLine, progressLine.getState().getCurrentTime(), progressLine.getSettings().getTimeMax());
    }
}
