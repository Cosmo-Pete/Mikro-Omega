package Logic;

public class Timer {

    private int totalSeconds;
    private int remainingSeconds;
    private boolean running;
    private javax.swing.Timer swingTimer; // Swing timer pro UI
    private Runnable onTick;
    private Runnable onExpire;

    public Timer(int totalSeconds) {
        this.totalSeconds = totalSeconds;
        this.remainingSeconds = totalSeconds;
        this.running = false;
    }

    // Ovládání
    public void start() {
        swingTimer = new javax.swing.Timer(1000, e ->{
            remainingSeconds--;
            if (onTick != null) onTick.run();
            if (remainingSeconds == 0){
                swingTimer.stop();
                if (onExpire != null) onExpire.run();
            }
        });
        swingTimer.start();
    }

    public void stop() {
        swingTimer.stop();
    }

    public void reset() {
        swingTimer.stop();
        remainingSeconds = totalSeconds;
    }

    public void reset(int newSeconds) {
        swingTimer.stop();
        totalSeconds = newSeconds;
        remainingSeconds = newSeconds;
    }

    // Gettery
    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isExpired() {
        return remainingSeconds <= 0;
    }

    // Callback – calls when the timer expires or gets interrupted
    public void setOnTick(Runnable onTick) {
        this.onTick = onTick;
    }

    public void setOnExpire(Runnable onExpire) {
        this.onExpire = onExpire;
    }
}