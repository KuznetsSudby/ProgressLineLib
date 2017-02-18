package kusu.ui.progressline.Listeners;

import kusu.ui.progressline.Views.ProgressLine;

/**
 * Created by KuSu on 28.01.2017.
 */

public interface TimeChangeListener {
    void timeChange(ProgressLine line, int time, int max);
}
