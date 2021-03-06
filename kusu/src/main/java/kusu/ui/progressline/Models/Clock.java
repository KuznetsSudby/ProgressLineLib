package kusu.ui.progressline.Models;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by KuSu on 28.01.2017.
 */

public class Clock {

    private Logic logic;
    private Timer timer = null;

    boolean pause = false;

    public Clock(Logic logic) {
        this.logic = logic;
    }

    public void startTime() {
        stopTime();
        timer = new Timer();
        timer.schedule(new ClockTimerTask(this), 1000, 1000);
    }

    public void stopTime() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void pause() {
        pause = true;
    }

    public void resume(){
        pause = false;
    }

    private class ClockTimerTask extends TimerTask {

        Clock clock;

        public ClockTimerTask(Clock clock) {
            this.clock = clock;
        }

        @Override
        public void run() {
            if (!clock.pause)
                clock.logic.step();
        }
    }
}
