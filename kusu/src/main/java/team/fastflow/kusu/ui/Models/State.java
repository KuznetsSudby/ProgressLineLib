package team.fastflow.kusu.ui.Models;

/**
 * Created by KuSu on 27.01.2017.
 */

public class State {


    private int currentTime;
    private int currentStep;

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

    public void clearCurrentTime(){
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
}
