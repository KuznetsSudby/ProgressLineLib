package team.fastflow.kusu.ui.Models;

import team.fastflow.kusu.ui.Listeners.TimerListener;
import team.fastflow.kusu.ui.Views.ProgressLine;

/**
 * Created by KuSu on 28.01.2017.
 */

public class Logic implements TimerListener {

    private final ProgressLine progressLine;

    public Logic(ProgressLine progressLine) {
        this.progressLine = progressLine;
    }

    @Override
    public void step() {
        progressLine.getState().incCurrentTime();
        progressLine.getListeners().nextTime();
        if (!progressLine.getSettings().isStep()){
            if (progressLine.getState().getCurrentTime() >= progressLine.getSettings().getMaxTime())
                progressLine.nextStep();
        }
        progressLine.getDraw().drawProgress();
    }
}
