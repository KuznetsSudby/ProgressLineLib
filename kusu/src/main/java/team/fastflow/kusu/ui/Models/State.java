package team.fastflow.kusu.ui.Models;

import java.util.HashMap;

/**
 * Created by KuSu on 27.01.2017.
 */

public class State {

    public static final int EMPTY = 0;
    public static final int GOOD = 1;
    public static final int BAD = 2;

    private int currentTime;
    private int currentStep;
    public HashMap<Integer, Integer> results = new HashMap<>();

    public void clearResults() {
        results.clear();
    }

    public void addResult(int step, int res) {
        results.remove(step);
        results.put(step, res);
    }

    public void clear() {
        clearCurrentTime();
        clearCurrentStep();
    }

    private void clearCurrentStep() {
        currentStep = 0;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void incCurrentTime() {
        currentTime++;
    }

    public void clearCurrentTime() {
        currentTime = 0;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void incCurrentStep() {
        currentStep++;
    }

    public Integer getResult(int step) {
        if (results.containsKey(step))
            return results.get(step);
        return EMPTY;
    }

    public boolean isEnd(int stepMax) {
        return currentStep == stepMax;
    }
}
