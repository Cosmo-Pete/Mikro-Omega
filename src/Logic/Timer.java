package Logic;

public class Timer {

    private int totalSeconds;
    private int remainingSeconds;
    private boolean running;
    private javax.swing.Timer swingTimer;   // Swing timer pro UI

    public Timer(int totalSeconds) {
        this.totalSeconds = totalSeconds;
        this.remainingSeconds = totalSeconds;
        this.running = false;
    }

    // Ovládání
    public void start() {
        // TODO: Implementace
    }

    public void stop() {
        // TODO: Implementace
    }

    public void reset() {
        // TODO: Implementace
    }

    public void reset(int newSeconds) {
        // TODO: Implementace
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

    // Callback – zavolá se při vypršení nebo tiknutí
    public void setOnTick(Runnable onTick) {
        // TODO: Implementace
    }

    public void setOnExpire(Runnable onExpire) {
        // TODO: Implementace
    }
}