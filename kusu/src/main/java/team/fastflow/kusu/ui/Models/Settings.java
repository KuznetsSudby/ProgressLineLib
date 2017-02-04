package team.fastflow.kusu.ui.Models;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import team.fastflow.kusu.R;
import team.fastflow.kusu.ui.Utils.Default;

/**
 * Created by KuSu on 28.01.2017.
 */

public class Settings {

    public final static int TIMER = 0;
    //    задается время на весь тест и шаги.

    public final static int STEP = 1;
    //    задаются шаги, таймер считает сколько потрачено времени

    public final static int TIME_STEP = 2;
    // задается время на 1 шаг, отображается полоска времени шага (цикличный timer)

    private int type = Default.type;
    private int layout = Default.layout;

    private int timeMax = Default.timeMax;
    private int stepMax = Default.stepMax;
    private int timeRed = Default.timeRed;

    private int backgroundColor;
    private int progressColor;
    private int currentColor;
    private int dividerColor;
    private int timeEndColor;

    private int duration;

    private boolean drawTime;
    private boolean drawArrow;

    private int dividerHeight = Default.dividerHeight;
    private boolean stepVisible = Default.stepVisible;
    private int stepPadding = Default.stepPadding;

    private Drawable stepEmpty;
    private Drawable stepGood;
    private Drawable stepBad;

    public Settings(Context context, AttributeSet attrs) {
        if (attrs != null){
            TypedArray pianoAttrs = context.obtainStyledAttributes(attrs, R.styleable.pl);
            loadValues(context, pianoAttrs);
            loadColors(context, pianoAttrs);
            loadDrawables(context, pianoAttrs);
        }
        updateColor(context);
        updateDrawables(context);
    }

    private void updateDrawables(Context context) {
        if (stepEmpty == null)
            stepEmpty = context.getResources().getDrawable(Default.stepEmpty);
        if (stepBad == null)
            stepBad = context.getResources().getDrawable(Default.stepBad);
        if (stepGood == null)
            stepGood = context.getResources().getDrawable(Default.stepGood);
    }

    private void updateColor(Context context) {
        if (backgroundColor == 0)
            backgroundColor = context.getResources().getColor(Default.background);
        if (progressColor == 0)
            progressColor = context.getResources().getColor(Default.progress);
        if (currentColor == 0)
            currentColor = context.getResources().getColor(Default.current);
        if (dividerColor == 0)
            dividerColor = context.getResources().getColor(Default.divider);
        if (timeEndColor == 0)
            timeEndColor = context.getResources().getColor(Default.timeEnd);
    }

    private void loadDrawables(Context context, TypedArray pianoAttrs) {
        stepEmpty = getDrawables(context, pianoAttrs, R.styleable.pl_step_empty, Default.stepEmpty);
        stepGood = getDrawables(context, pianoAttrs, R.styleable.pl_step_good, Default.stepGood);
        stepBad = getDrawables(context, pianoAttrs, R.styleable.pl_step_bad, Default.stepBad);
    }

    private Drawable getDrawables(Context context, TypedArray pianoAttrs, int pl, int def) {
        Drawable drawable = pianoAttrs.getDrawable(pl);
        return drawable == null ? context.getResources().getDrawable(def) : drawable;
    }

    private void loadColors(Context context, TypedArray pianoAttrs) {
        backgroundColor = pianoAttrs.getColor(R.styleable.pl_background_color, context.getResources().getColor(Default.background));
        progressColor = pianoAttrs.getColor(R.styleable.pl_progress_color, context.getResources().getColor(Default.progress));
        currentColor = pianoAttrs.getColor(R.styleable.pl_current_color, context.getResources().getColor(Default.current));
        dividerColor = pianoAttrs.getColor(R.styleable.pl_divider_color, context.getResources().getColor(Default.divider));
        timeEndColor = pianoAttrs.getColor(R.styleable.pl_time_end_color, context.getResources().getColor(Default.timeEnd));
    }

    private void loadValues(Context context, TypedArray pianoAttrs) {
        type = pianoAttrs.getInt(R.styleable.pl_type, Default.type);
        layout = pianoAttrs.getResourceId(R.styleable.pl_layout, Default.layout);

        timeRed = pianoAttrs.getInt(R.styleable.pl_time_red, Default.timeRed);
        timeMax = pianoAttrs.getInt(R.styleable.pl_time_max, Default.timeMax);
        stepMax = pianoAttrs.getInt(R.styleable.pl_step_max, Default.stepMax);

        duration = pianoAttrs.getInt(R.styleable.pl_duration, Default.duration);

        drawTime = pianoAttrs.getBoolean(R.styleable.pl_draw_time, Default.drawTime);
        drawArrow = pianoAttrs.getBoolean(R.styleable.pl_draw_arrow, Default.drawArrow);

        dividerHeight = (int) pianoAttrs.getDimension(R.styleable.pl_divide_height, Default.dividerHeight);
        stepVisible = pianoAttrs.getBoolean(R.styleable.pl_step_visible, Default.stepVisible);
        stepPadding = (int) pianoAttrs.getDimension(R.styleable.pl_step_padding, Default.stepPadding);
    }

    public boolean isDrawArrow() {
        return drawArrow;
    }

    public void setDrawArrow(boolean drawArrow) {
        this.drawArrow = drawArrow;
    }

    public boolean isDrawTime() {
        return drawTime;
    }

    public void setDrawTime(boolean drawTime) {
        this.drawTime = drawTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getTimeMax() {
        return timeMax;
    }

    public void setTimeMax(int timeMax) {
        this.timeMax = timeMax;
    }

    public int getStepMax() {
        return stepMax;
    }

    public void setStepMax(int stepMax) {
        this.stepMax = stepMax;
    }

    public int getTimeRed() {
        return timeRed;
    }

    public void setTimeRed(int timeRed) {
        this.timeRed = timeRed;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getProgressColor() {
        return progressColor;
    }

    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
    }

    public int getDividerColor() {
        return dividerColor;
    }

    public int getCurrentColor() {
        return currentColor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCurrentColor(int currentColor) {
        this.currentColor = currentColor;
    }

    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
    }

    public int getTimeEndColor() {
        return timeEndColor;
    }

    public void setTimeEndColor(int timeEndColor) {
        this.timeEndColor = timeEndColor;
    }

    public int getDividerHeight() {
        return dividerHeight;
    }

    public void setDividerHeight(int dividerHeight) {
        this.dividerHeight = dividerHeight;
    }

    public boolean isStepVisible() {
        return stepVisible;
    }

    public void setStepVisible(boolean stepVisible) {
        this.stepVisible = stepVisible;
    }

    public int getStepPadding() {
        return stepPadding;
    }

    public void setStepPadding(int stepPadding) {
        this.stepPadding = stepPadding;
    }

    public Drawable getStepEmpty() {
        return stepEmpty;
    }

    public void setStepEmpty(Drawable stepEmpty) {
        this.stepEmpty = stepEmpty;
    }

    public Drawable getStepGood() {
        return stepGood;
    }

    public void setStepGood(Drawable stepGood) {
        this.stepGood = stepGood;
    }

    public Drawable getStepBad() {
        return stepBad;
    }

    public void setStepBad(Drawable stepBad) {
        this.stepBad = stepBad;
    }

    public boolean isStep() {
        return type == STEP;
    }

    public Drawable getDrawable(int result) {
        switch (result){
            case State.BAD:
                return stepBad;
            case State.GOOD:
                return stepGood;
        }
        return stepEmpty;
    }
}
