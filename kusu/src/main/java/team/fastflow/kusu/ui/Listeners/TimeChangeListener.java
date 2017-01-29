package team.fastflow.kusu.ui.Listeners;

import team.fastflow.kusu.ui.Views.ProgressLine;

/**
 * Created by KuSu on 28.01.2017.
 */

public interface TimeChangeListener {
    void timeChange(ProgressLine line, int time, int max);
}
