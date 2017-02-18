package kusu.ui.progressline.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import kusu.ui.progressline.R;
import kusu.ui.progressline.Models.Clock;
import kusu.ui.progressline.Models.Listeners;
import kusu.ui.progressline.Models.Logic;
import kusu.ui.progressline.Models.Settings;
import kusu.ui.progressline.Models.State;

/**
 * Created by KuSu on 26.01.2017.
 */

public class ProgressLine extends FrameLayout {

    private Listeners listeners;
    private Clock clock;
    private Logic logic;
    private Settings settings;
    private State state;
    private Line line;

    public ProgressLine(Context context) {
        super(context);
        initLayout(context, null);
    }

    public ProgressLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context, attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        settings = new Settings(context, attrs);
        inflate(getContext(), settings.getLayout(), this);
        listeners = new Listeners(this);
        state = new State();
        logic = new Logic(this);
        clock = new Clock(logic);
        line = (Line) findViewById(R.id.progress);
        line.setProgressLine(this);

        clock.startTime();
    }

    public void update() {
        logic.invalidate();
    }

    public Listeners getListeners() {
        return listeners;
    }

    public Clock getClock() {
        return clock;
    }

    public void nextStep() {
        if (state.isEnd(settings.getStepMax()))
            return;
        state.incCurrentStep();
        if (!settings.isStep())
            if (!state.isEnd(settings.getStepMax()))
                state.clearCurrentTime();
        if (state.isEnd(settings.getStepMax()))
            clock.stopTime();
        listeners.nextStep();
        logic.invalidate();
    }

    public void nextStep(int result) {
        if (state.isEnd(settings.getStepMax()))
            return;
        state.addResult(state.getCurrentStep(), result);
        nextStep();
    }

    public Settings getSettings() {
        return settings;
    }

    public void recreateType(int type) {
        clock.stopTime();
        state.clear();
        settings.setType(type);
        clock.startTime();
    }

    public State getState() {
        return state;
    }

    public Line getLine() {
        return line;
    }

    @Override
    public void draw(Canvas canvas) {
        if (isInEditMode())
            return;
        super.draw(canvas);
    }

    public void pause(){
        clock.pause();
    }

    public void resume(){
        clock.resume();
    }
}
