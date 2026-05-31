package Logic;

public class Timer {

    private int totalSeconds;
    private int remainingSeconds;
    private boolean running;
    private javax.swing.Timer swingTimer; // Swing timer for UI updates
    private Runnable onTick;
    private Runnable onExpire;

    /**
     * Creates a new timer with the given time limit.
     * @param totalSeconds total time in seconds
     */
    public Timer(int totalSeconds) {
        this.totalSeconds = totalSeconds;
        this.remainingSeconds = totalSeconds;
        this.running = false;
    }

    /**
     * Starts the timer. Decreases remaining seconds every second.
     * Calls onTick every second and onExpire when time runs out.
     */
    public void start() {
        swingTimer = new javax.swing.Timer(1000, e -> {
            remainingSeconds--;
            if (onTick != null) onTick.run();
            if (remainingSeconds == 0) {
                swingTimer.stop();
                if (onExpire != null) onExpire.run();
            }
        });
        swingTimer.start();
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        swingTimer.stop();
    }

    /**
     * Resets the timer to a new time limit.
     * @param newSeconds new time limit in seconds
     */
    public void resetTODefault(int newSeconds) {
        if (swingTimer != null) {
            swingTimer.stop();
        }
        totalSeconds = newSeconds;
        remainingSeconds = newSeconds;
    }

    /**
     * Resets the timer to the original time limit.
     */
    public void resetTODefault() {
        if (swingTimer != null) {
            swingTimer.stop();
        }
        remainingSeconds = totalSeconds;
    }

    /**
     * Returns the remaining seconds on the timer.
     * @return remaining seconds
     */
    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    /**
     * Sets the callback to be called every second.
     * @param onTick runnable to call on each tick
     */
    public void setOnTick(Runnable onTick) {
        this.onTick = onTick;
    }

    /**
     * Sets the callback to be called when the timer expires.
     * @param onExpire runnable to call on expiry
     */
    public void setOnExpire(Runnable onExpire) {
        this.onExpire = onExpire;
    }
}