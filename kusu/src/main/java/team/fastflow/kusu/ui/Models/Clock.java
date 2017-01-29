package team.fastflow.kusu.ui.Models;

import java.util.Timer;
import java.util.TimerTask;

import team.fastflow.kusu.ui.Views.ProgressLine;

/**
 * Created by KuSu on 28.01.2017.
 */

public class Clock {

    private Logic logic;
    private Timer timer = null;

    public Clock(Logic logic){
        this.logic = logic;
    }

    public void startTime(){
        stopTime();
        timer = new Timer();
        timer.schedule(new ClockTimerTask(this), 1000, 1000);
    }

    public void stopTime(){
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private class ClockTimerTask extends TimerTask{

        Clock clock;

        public ClockTimerTask(Clock clock){
            this.clock = clock;
        }

        @Override
        public void run() {
            clock.logic.step();
        }
    }
}
