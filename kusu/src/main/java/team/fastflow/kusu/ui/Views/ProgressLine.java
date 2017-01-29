package team.fastflow.kusu.ui.Views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import team.fastflow.kusu.R;
import team.fastflow.kusu.ui.Listeners.OnStepChangeListener;
import team.fastflow.kusu.ui.Models.Clock;
import team.fastflow.kusu.ui.Models.Draw;
import team.fastflow.kusu.ui.Models.Listeners;
import team.fastflow.kusu.ui.Models.Logic;
import team.fastflow.kusu.ui.Models.Settings;
import team.fastflow.kusu.ui.Models.State;

/**
 * Created by KuSu on 26.01.2017.
 */

public class ProgressLine extends FrameLayout{

    private Listeners listeners;
    private Clock clock;
    private Logic logic;
    private Settings settings;
    private State state;
    private Draw draw;

    public ProgressLine(Context context) {
        super(context);
        initLayout(context, null);
    }

    public ProgressLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context, attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        listeners = new Listeners(this);
        draw = new Draw(this);
        settings = new Settings(context, attrs);
        state = new State();
        logic = new Logic(this);
        clock = new Clock(logic);

        inflate(getContext(), R.layout.def_progress_line, this);

        clock.startTime();
    }

    public Listeners getListeners() {
        return listeners;
    }

    public Clock getClock() {
        return clock;
    }

    public void nextStep() {
        state.incCurrentStep();
        if (!settings.isStep())
            state.clearCurrentTime();
        listeners.nextStep();
        draw.drawProgress();
    }

    public Settings getSettings() {
        return settings;
    }

    public void recreateType(int type){
        clock.stopTime();
        state.clear();
        settings.changeType(type);
        clock.startTime();
    }

    public State getState() {
        return state;
    }

    public Draw getDraw() {
        return draw;
    }

    //мигать, когда остается мало секунд --- atribute
    //задавать основные цвета и размер текста через стили


}
